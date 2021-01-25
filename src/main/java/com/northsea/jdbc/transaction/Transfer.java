package com.northsea.jdbc.transaction;

import com.northsea.jdbc.util.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author ：mmzs
 * @date ：Created in 2021/1/24 16:33
 * JDBC 中的事务:
 * Connection 的三个方法与事务相关：
 * ⚫ setAutoCommit(boolean)：设置是否为自动提交事务，如果 true（默认值就是 true）表示自
 * 动提交，也就是每条执行的 SQL 语句都是一个单独的事务，如果设置 false，那么就相当于
 * 开启了事务了；con.setAutoCommit(false)表示开启事务！！！
 * ⚫ commit()：提交结束事务；con.commit();表示提交事务
 * ⚫ rollback()：回滚结束事务。con.rollback();表示回滚事务
 * jdbc 处理事务的代码格式：
 * try {
 *  con.setAutoCommit(false);//开启事务…
 *  ….
 *  …
 *  con.commit();//try 的最后提交事务
 * } catch() {
 *  con.rollback();//回滚事务
 * }
 *
 * !!!同一事务中所有的操作，都在使用同一个 Connection 对象
 */
public class Transfer {

    @Test
    public void transferTest() {
        // transfer(true);
        transfer(false);
    }

    public void transfer(boolean b) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = JdbcUtils.getConnection();
            //手动提交
            con.setAutoCommit(false);
            String sql = "update account set balance=balance+? where id=?";
            pstmt = con.prepareStatement(sql);
            //操作
            pstmt.setDouble(1, -10000);
            pstmt.setInt(2, 1);
            pstmt.executeUpdate();
            // 在两个操作中抛出异常
            // 为了让catch捕获到
            if (b) {
                throw new Exception();
            }
            pstmt.setDouble(1, 10000);
            pstmt.setInt(2, 2);
            pstmt.executeUpdate();
            //提交事务
            con.commit();
        } catch (Exception e) {
            //回滚事务
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException ex) {
                    System.out.println("事务回滚失败!!!");
                }
            }
            throw new RuntimeException(e);
        } finally {
            //关闭资源
            JdbcUtils.close(con, pstmt);
        }
    }

}
