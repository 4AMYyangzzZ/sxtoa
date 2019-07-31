package com.bjsxt.util;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class MyConnectionPool {
    private static final  String URL;
    private static final String USERNAME;
    private static final String PASSWORD;
    private static final String DRIVER;
    private static final int INITSIZE;
    private static final int MAXSIZE;
    private static LinkedList<Connection> conPool;
    private static Logger logger=Logger.getLogger(MyConnectionPool.class);

    static {
        URL= PropertyUtil.getProperty("url");
        USERNAME = PropertyUtil.getProperty("username");
        PASSWORD= PropertyUtil.getProperty("password");
        DRIVER= PropertyUtil.getProperty("driver");
        INITSIZE= Integer.parseInt(PropertyUtil.getProperty("initSize"));
        MAXSIZE=Integer.parseInt(PropertyUtil.getProperty("maxSize"));
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            logger.fatal(e.getMessage());
        }
    }
    static {
        conPool=new LinkedList<>();
        for (int i = 1; i <=INITSIZE ; i++) {
            conPool.addLast(initCon());
        }
    }

    private static Connection initCon(){
        Connection con=null;
        try {
            con= DriverManager.getConnection(URL, USERNAME,PASSWORD);
        } catch (SQLException e) {
            logger.fatal(e.getMessage());
        }
        return con;
    }

    //向外界提供连接对象
    public static Connection getCon(){
        //如果连接池中有连接对象，则从连接池中取
        if (conPool.size()>0){
            Connection connection = conPool.removeFirst();
            return connection;
        }else {
            //如果没有则重新创建连接对象，并返回
            return initCon();
        }
    }

    //接收返回的对象
    public static void returnCon(Connection connection){
        if (null!=connection){
            //如果连接池没满，则放回连接池
            if (conPool.size()<MAXSIZE){
                conPool.addLast(connection);
            }else {
                //如果连接池满了，则释放连接
                try {
                    connection.close();
                } catch (SQLException e) {
                    logger.fatal(e.getMessage());
                }
            }
        }
    }
}
