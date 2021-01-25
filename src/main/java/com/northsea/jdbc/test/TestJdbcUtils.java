package com.northsea.jdbc.test;

import com.northsea.jdbc.util.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author ：mmzs
 * @date ：Created in 2021/1/22 14:27
 */
public class TestJdbcUtils {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    @Test
    public void TestJDBCUtil() {
        // 1.获取连接
        conn = JdbcUtils.getConnection();
        // 2.生成发送器(语句发送器)
        // 通过Connection得到Statement对象
        // 使用Statement发送sql语句
        try {
            stmt = conn.createStatement();
            String sql = "SELECT * FROM branch;";
            // 3.执行结果
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
        }

        // 关闭资源
        JdbcUtils.close(conn, stmt ,rs);
    }
}
