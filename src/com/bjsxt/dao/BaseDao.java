package com.bjsxt.dao;

import com.bjsxt.util.DBUtil;
import com.bjsxt.util.DBUtil1;
import com.bjsxt.util.DBUtil2;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * 用于操作数据库的两个通用方法，一个用于查询，一个用于增删改
 */
public class BaseDao {
    //log4j日志框架
    private static Logger logger=Logger.getLogger(BaseDao.class);
    //用于增删改操作
    public static int baseUpdate(String sql,Object...args){
        Connection conn=null;
        PreparedStatement pstat=null;
        int j=0;
        try {
            conn= DBUtil1.getConnection();
            pstat=conn.prepareStatement(sql);
            for (int i = 0; i <args.length ; i++) {
                pstat.setObject(i+1,args[i]);
            }
            j=pstat.executeUpdate();
        } catch (SQLException e) {
            logger.fatal(e.getMessage());
        }finally {
            DBUtil.close(pstat,conn);
        }
        return j;
    }

    //用于查询操作
    public static List baseQuery(Class c, String sql,Object...args){
        Connection conn=null;
        PreparedStatement pstat=null;
        ResultSet set=null;
        List list=null;
        Object o=null;
        try {
            conn = DBUtil.getConnection();
            pstat=conn.prepareStatement(sql);
            if (args!=null && args.length>0) {
                for (int i = 0; i < args.length; i++) {
                    pstat.setObject(i + 1, args[i]);
                }
            }
            set=pstat.executeQuery();
            Field[] fields = c.getDeclaredFields();
            for (Field f:fields){
                f.setAccessible(true);
            }

            while (set.next()){
                o= c.newInstance();//必须写在循环里，否则在给下一条记录赋值时会影响上一条记录的赋值，导致只有一个值
                for (Field f:fields) {
                    if (f.getType()==int.class){
                        f.set(o,set.getInt(f.getName()));
                    }else if (f.getType()==byte.class){
                        f.set(o,set.getByte(f.getName()));
                    }else if (f.getType()==short.class){
                        f.set(o,set.getShort(f.getName()));
                    }else if (f.getType()==long.class){
                        f.set(o,set.getLong(f.getName()));
                    }else if (f.getType()==double.class){
                        f.set(o,set.getDouble(f.getName()));
                    }else if (f.getType()==float.class){
                        f.set(o,set.getFloat(f.getName()));
                    }else {
                        f.set(o,set.getObject(f.getName()));
                    }
                }
                if (null==list){
                    list=new LinkedList<>();
                }
                list.add(o);
            }
        } catch (SQLException e) {
            logger.fatal(e.getMessage());
        } catch (IllegalAccessException e) {
            logger.fatal(e.getMessage());
        } catch (InstantiationException e) {
            logger.fatal(e.getMessage());
        } finally {
            DBUtil1.closeAll(set,pstat,conn);
        }
        return list;
    }
}
