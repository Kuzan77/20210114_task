package com.northsea.jdbc.connectionpool.ytfpool;

import javax.sql.DataSource;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * @author ：mmzs
 * @date ：Created in 2021/1/24 18:40
 */
//public class YTFPool implements DataSource {
//    private static Properties props = new Properties();
//    private List<Connection> list = new ArrayList<Connection>();
//
//    static {
//        InputStream in = YTFPool.class.getClassLoader()
//                .getResourceAsStream("dbconfig.properties");
//        try {
//            props.load(in);
//            Class.forName(props.getProperty("driverClassName"));
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//    public YTFPool() throws SQLException {
//        for (int i = 0; i < 5; i++) {
//            Connection con = DriverManager.getConnection(
//                    props.getProperty("url"), props.getProperty("username"),
//                    props.getProperty("password"));
//            YTFConnection conWapper = new YTFConnection(con, this);
//            list.add(conWapper);
//        }
//    }
//    public void add(Connection con) {
//        list.add(con);
//    }
//    public Connection getConnection() throws SQLException {
//        if(list.size() > 0) {
//            return list.remove(0);
//        }
//        throw new SQLException("没连接了");
//    }
//
//    @Override
//    public Connection getConnection(String username, String password) throws SQLException {
//        return null;
//    }
//
//    @Override
//    public <T> T unwrap(Class<T> iface) throws SQLException {
//        return null;
//    }
//
//    @Override
//    public boolean isWrapperFor(Class<?> iface) throws SQLException {
//        return false;
//    }
//
//    @Override
//    public PrintWriter getLogWriter() throws SQLException {
//        return null;
//    }
//
//    @Override
//    public void setLogWriter(PrintWriter out) throws SQLException {
//
//    }
//
//    @Override
//    public void setLoginTimeout(int seconds) throws SQLException {
//
//    }
//
//    @Override
//    public int getLoginTimeout() throws SQLException {
//        return 0;
//    }
//
//    @Override
//    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
//        return null;
//    }
//}
