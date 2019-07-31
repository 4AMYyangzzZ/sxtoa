package com.bjsxt.util;

import java.sql.*;

public class DBUtil {

    private DBUtil(){

    }

    /**
     * 获取数据库连接
     * @return
     */
    public static  Connection getConnection(){
        return MyConnectionPool.getCon();
    }

    /**
     * 执行查询操作时，释放资源
     * @param rs
     * @param stmt
     * @param conn
     */
    public static void closeAll(ResultSet rs, Statement stmt, Connection conn){
        try {
            if(rs != null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if(stmt != null){
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(conn != null){
            MyConnectionPool.returnCon(conn);
        }
    }

    /**
     * 执行增删操作时，释放资源
     * @param pstat
     * @param conn
     */
    public static void close(PreparedStatement pstat,Connection conn){
        if (null!=pstat){
            try {
                pstat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            MyConnectionPool.returnCon(conn);
        }
    }
}
