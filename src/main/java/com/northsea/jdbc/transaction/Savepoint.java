package com.northsea.jdbc.transaction;

import com.northsea.jdbc.util.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author ：mmzs
 * @date ：Created in 2021/1/24 17:24
 * 保存点（了解）
 * 保存点是 JDBC3.0 的东西！当要求数据库服务器支持保存点方式的回滚。
 * 校验数据库服务器是否支持保存点！
 * boolean b = con.getMetaData().supportsSavepoints();
 * 保存点的作用是允许事务回滚到指定的保存点位置。在事务中设置好保存点，然后回滚时可以
 * 选择回滚到指定的保存点，而不是回滚整个事务！注意，回滚到指定保存点并没有结束事务！只有
 * 回滚了整个事务才算是结束事务！
 * Connection 类的设置保存点，以及回滚到指定保存点方法：
 * ⚫ 设置保存点：Savepoint setSavepoint()；
 * ⚫ 回滚到指定保存点：void rollback(Savepoint)。
 */
public class Savepoint {
    /*
    * 李四对张三说，如果你给我转1W，我就给你转100W。
    * ==========================================
    *
    * 张三给李四转1W（张三减去1W，李四加上1W）
    * 设置保存点！
    * 李四给张三转100W（李四减去100W，张三加上100W）
    * 查看李四余额为负数，那么回滚到保存点。
    * 提交事务
    */
    @Test
    public void fun() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = JdbcUtils.getConnection();
            //手动提交
            con.setAutoCommit(false);
            String sql = "update account set balance=balance+? where name=?";
            pstmt = con.prepareStatement(sql);
            //操作1（张三减去1W）
            pstmt.setDouble(1, -10000);
            pstmt.setString(2, "zs");
            pstmt.executeUpdate();
            //操作2（李四加上1W）
            pstmt.setDouble(1, 10000);
            pstmt.setString(2, "ls");
            pstmt.executeUpdate();
            // 设置保存点
            java.sql.Savepoint sp = con.setSavepoint();
            //操作3（李四减去100W）
            pstmt.setDouble(1, -1000000);
            pstmt.setString(2, "ls");
            pstmt.executeUpdate();
            //操作4（张三加上100W）
            pstmt.setDouble(1, 1000000);
            pstmt.setString(2, "zs");
            pstmt.executeUpdate();
            //操作5（查看李四余额）
            sql = "select balance from account where name=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "ls");
            rs = pstmt.executeQuery();
            rs.next();
            double balance = rs.getDouble(1);
            //如果李四余额为负数，那么回滚到指定保存点
            if (balance < 0) {
                con.rollback(sp);
                System.out.println("张三，你上当了！");
            }
            //提交事务
            con.commit();
        } catch (Exception e) {
            //回滚事务
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException ex) {
                }
            }
            throw new RuntimeException(e);
        } finally {
            //关闭
            JdbcUtils.close(con, pstmt, rs);
        }
    }

}
