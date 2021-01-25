package com.northsea.jdbc.connectionpool.dbcp;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author ：mmzs
 * @date ：Created in 2021/1/25 10:21
 */
//public class Dbcp2 {
//        public void fun1() throws SQLException {
//        BasicDataSource ds = new BasicDataSource();
//        ds.setUsername("root");
//        ds.setPassword("123");
//        ds.setUrl("jdbc:mysql://localhost:3306/mydb1");
//        ds.setDriverClassName("com.mysql.jdbc.Driver");
//        ds.setMaxActive(20);
//        ds.setMaxIdle(10);
//        ds.setInitialSize(10);
//        ds.setMinIdle(2);
//        ds.setMaxWait(1000);
//        Connection con = ds.getConnection();
//        System.out.println(con.getClass().getName());
//        con.close();
//    }
//}
