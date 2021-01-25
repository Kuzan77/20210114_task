package com.northsea.jdbc.connectionpool.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author ：mmzs
 * @date ：Created in 2021/1/24 20:58
 *
 * 连接池返回的 Connection 对象，它的 close()方法与众不同！调用它的 close()不是关闭，而是把连接
 * 归还给池！
 */
public class C3P0 {
//    private static ComboPooledDataSource ds = new ComboPooledDataSource();
//
//    public static Connection configDataSource() throws PropertyVetoException, SQLException {
//
//        ds.setJdbcUrl("jdbc:mysql://localhost:3306/northsea?serverTimezone=GMT%2B8&characterEncoding=utf-8&useSSL=FALSE");
//        ds.setUser("root");
//        ds.setPassword("123456");
//        ds.setDriverClass("com.mysql.cj.jdbc.Driver");
//        ds.setAcquireIncrement(5);
//        ds.setInitialPoolSize(20);
//        ds.setMinPoolSize(2);       // 最小空闲数
//        ds.setMaxPoolSize(50);      // 最大空闲数
//        Connection con = ds.getConnection();
//        return con;
//    }
    /**
     * 获取Connection连接
     * @return
     */
//    public static Connection getConnection(){
//        Connection conn = null;
//        try {
//            configDataSource();
//            conn = ds.getConnection();
//        } catch (PropertyVetoException e) {
//            e.printStackTrace();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return conn;
//    }

    /**
     * 读取配置文件
      */
    private static ComboPooledDataSource ds = new ComboPooledDataSource("oracle-config");
    /**
     * 获取Connection连接
     * @return
     */
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
