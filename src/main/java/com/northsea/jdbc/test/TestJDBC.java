package com.northsea.jdbc.test;

import com.northsea.jdbc.connectionpool.c3p0.C3P0;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.*;

/**
 * JDBC连接数据库
 * @author ：mmzs
 * @date ：Created in 2021/1/22 10:13
 */
public class TestJDBC {

    public static final String URL = "jdbc:mysql://localhost:3306/northsea?serverTimezone=GMT%2B8&characterEncoding=utf-8&useSSL=FALSE";
    public static final String USERNAME= "root";
    public static final String PASSWORD = "123456";

    @Test
    public void testJDBC () {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = C3P0.getConnection();
            System.out.println(conn);
            // 3.生成发送器(语句发送器)
            // 通过Connection得到Statement对象
            // 使用Statement发送sql语句
            stmt = conn.createStatement();

            // 添加记录
            // String sql = "INSERT INTO branch(branchname, location) VALUES ('策划部', '济南市');";

            // 删除记录
            // String sql = "DELETE FROM branch WHERE id = 4;";

            // 修改记录
            // String sql = "UPDATE branch SET location = \"上海市\" WHERE id = 2;";

            // 查询记录
            String sql = "SELECT * FROM branch;";

            // 4.执行结果
            // (1)增、删、改返回结果
//            int row = stmt.executeUpdate(sql);
//            System.out.println(row);
//            if (row > 0) {
//                System.out.println("执行成功");
//            }else {
//                System.out.println("执行失败!!!");
//            }

            // (2)查询数据返回结果
            // 解析ResultSet
            // 把行光标移动到第一行，可以调用next()方法完成！
            rs = stmt.executeQuery(sql);
            while (rs.next()) {     //把光标向下移动一行，并判断下一行是否存在！
                String id = rs.getString(1);    //通过列编号来获取该列的值！
                String branchname = rs.getString("branchname");     //通过列名称来获取该列的值！
                String location = rs.getString("location");

                System.out.println(id + " " + branchname + " " + location);
            }

        } catch (SQLException e) {
            System.out.println("执行失败!!!");
        }  finally {      // 5.释放资源
            if (rs !=null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println("关闭ResultSet失败");
                }finally {
                    if (stmt != null) {
                        try {
                            stmt.close();
                        } catch (SQLException e) {
                            System.out.println("关闭Statement失败!!!");
                        }finally {
                            if (conn != null) {
                                try {
                                    conn.close();
                                } catch (SQLException e) {
                                    System.out.println("关闭Connection失败!!!");
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 获取数据库的连接
     * @return
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // 1.加载驱动类(注册驱动)
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2.获取连接
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("注册驱动失败!!!");
        } catch (SQLException throwables) {
            System.out.println("获取数据库连接失败!!!");
        }
        if (conn != null) {
            return conn;
        }else {
            return null;
        }
    }
}
