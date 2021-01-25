package com.northsea.jdbc.test;

import com.northsea.jdbc.util.JdbcUtils;
import org.junit.Test;

import java.sql.*;

/**
 * 批处理
 *
 * @author ：mmzs
 * @date ：Created in 2021/1/24 11:41
 */
public class BatchDemo {
    /**
     * Statement 批处理
     * 批处理就是一批一批的处理，而不是一个一个的处理！
     * 当你有 10 条 SQL 语句要执行时，一次向服务器发送一条 SQL 语句，这么做效率上很差！处理的
     * 方案是使用批处理，即一次向服务器发送多条 SQL 语句，然后由服务器一次性处理。
     * 批处理只针对更新（增、删、改）语句，批处理没有查询什么事儿！
     * 可以多次调用 Statement 类的 addBatch(String sql)方法，把需要执行的所有 SQL 语句添加到一个
     * “批”中，然后调用 Statement 类的 executeBatch()方法来执行当前“批”中的语句。
     * ⚫ void addBatch(String sql)：添加一条语句到“批”中；
     * ⚫ int[] executeBatch()：执行“批”中所有语句。返回值表示每条语句所影响的行数据；
     * ⚫ void clearBatch()：清空“批”中的所有语句。
     */
    @Test
    public void statementBatch() {
        Connection conn = null;
        Statement stmt = null;
        try {
            // 获取连接
            conn = JdbcUtils.getConnection();

            // 通过Connection得到Statement对象
            // 使用Statement发送sql语句


            stmt = conn.createStatement();

            for (int i = 0; i < 10; i++) {
                String number = "S_10" + i;
                String name = "stu" + i;
                int age = 20 + i;
                String gender = i % 2 == 0 ? "male" : "female";
                String sql = "insert into stu values('" + number + "', '" + name + "', " + age + ", '" + gender + "')";
                // addBatch(String sql)：添加一条语句到“批”中
                stmt.addBatch(sql);
            }
            // 执行“批”中所有语句。返回值表示每条语句所影响的行数据
            int[] numbers = stmt.executeBatch();
            if (numbers.length != 0) {
                System.out.println("执行成功!!!");
            } else {
                System.out.println("执行失败!!!");
            }
        } catch (NullPointerException e) {
            System.out.println("空指针异常!!!");
        } catch (BatchUpdateException e) {
            System.out.println("未找到表!!!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            JdbcUtils.close(conn, stmt);
        }
    }

    /**
     * PreparedStatement 批处理:
     *      PreparedStatement 的批处理有所不同，因为每个 PreparedStatement 对象都绑定一条 SQL 模板。
     *      所以向 PreparedStatement 中添加的不是 SQL 语句，而是给“?”赋值。
     */
    @Test
    public void preparedStatementBatch() {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // 获取连接
            conn = JdbcUtils.getConnection();

            // 创建sql语句并发送
            String sql = "insert into stu values(?,?,?,?);";
            pstmt = conn.prepareStatement(sql);
            for(int i = 0; i < 10; i++) {
                pstmt.setString(1, "S_10" + i);
                pstmt.setString(2, "stu" + i);
                pstmt.setInt(3, 20 + i);
                pstmt.setString(4, i % 2 == 0 ? "male" : "female");
                pstmt.addBatch();
            }
            // 执行“批”中所有语句。返回值表示每条语句所影响的行数据
            int[] numbers = pstmt.executeBatch();
            if (numbers.length != 0) {
                System.out.println("执行成功!!!");
            } else {
                System.out.println("执行失败!!!");
            }
        } catch (BatchUpdateException e) {
            System.out.println("批量更新失败!!!");
        } catch (SQLException e) {
            System.out.println("执行sql语句失败!!!");
        } finally {
            // 关闭资源
            JdbcUtils.closep(conn, pstmt);
        }
    }
}
