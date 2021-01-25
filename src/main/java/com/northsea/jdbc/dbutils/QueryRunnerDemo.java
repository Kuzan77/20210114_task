package com.northsea.jdbc.dbutils;
import com.northsea.jdbc.util.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author ：mmzs
 * @date ：Created in 2021/1/24 21:13
 *
 * DBUtils 主要类
 * ⚫ DbUtils：都是静态方法，一系列的 close()方法；
 * ⚫ QueryRunner：
 * ➢ update()：执行 insert、update、delete；
 * ➢ query()：执行 select 语句；
 * ➢ batch()：执行批处理。
 */
public class QueryRunnerDemo {
    @Test
    public void fun1() {
        // 创建Connection对象
        Connection conn = null;
        // 创建QueryRunner对象
        QueryRunner qr = new QueryRunner();
        try {
            // 获取连接
            conn = JdbcUtils.getConnection();
        } catch (SQLException se) {
            System.out.println("连接异常!!!");
        }
        String sql = "insert into user values(?,?,?)";
        try {
            // 使用QueryRunner 的 update()方法可以用来执行sql语句
            qr.update(conn, sql, "u4", "Jack", "123456");
        } catch (SQLException se) {
            System.out.println("更新数据库失败!!!");
        }finally {
            if (conn != null) {
                try {
                    // 关闭资源
                    conn.close();
                } catch (SQLException se) {
                    System.out.println("关闭Connection失败!!!");
                }
            }
        }
    }
}
