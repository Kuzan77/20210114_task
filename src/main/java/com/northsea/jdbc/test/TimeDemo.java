package com.northsea.jdbc.test;

import com.northsea.jdbc.util.JdbcUtils;
import org.junit.Test;
import java.sql.*;

/**
 * 时间类型
 * @author ：mmzs
 * @date ：Created in 2021/1/23 20:57
 *
 * java.sql 包下给出三个与数据库相关的日期时间类型，分别是：
 * ⚫ Date：表示日期，只有年月日，没有时分秒。会丢失时间；
 * ⚫ Time：表示时间，只有时分秒，没有年月日。会丢失日期；
 * ⚫ Timestamp：表示时间戳，有年月日时分秒，以及毫秒。
 *
 * 当需要把 java.util.Date 转换成数据库的三种时间类型时，这就不能直接赋值，这需要使用数据
 * 库三种时间类型的构造器。java.sql 包下的 Date、Time、TimeStamp 三个类的构造器都需要一个 long
 * 类型的参数，表示毫秒值。创建这三个类型的对象，只需要有毫秒值即可。我们知道 java.util.Date
 * 有 getTime()方法可以获取毫秒值，那么这个转换也就不是什么问题了。
 * java.utl.Date d = new java.util.Date();
 * java.sql.Date date = new java.sql.Date(d.getTime());//会丢失时分秒
 * Time time = new Time(d.getTime());//会丢失年月日
 * Timestamp timestamp = new Timestamp(d.getTime());
 */
public class TimeDemo {

    /**
     * 向dt表插入时间信息
     * @throws SQLException
     */
    @Test
    public void fun1() throws SQLException {
        // 获取连接
        Connection con = JdbcUtils.getConnection();
        String sql = "insert into dt value(?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        java.util.Date d = new java.util.Date();
        pstmt.setDate(1, new Date(d.getTime()));
        pstmt.setTime(2, new Time(d.getTime()));
        pstmt.setTimestamp(3, new Timestamp(d.getTime()));
        pstmt.executeUpdate();

        // 关闭资源
        JdbcUtils.closep(con, pstmt);
    }

    /**
     * 查询dt表的时间信息
     * @throws SQLException
     */
    @Test
    public void fun2() throws SQLException {
        Connection con = JdbcUtils.getConnection();
        String sql = "select * from dt";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        java.util.Date d1 = rs.getDate(1);
        java.util.Date d2 = rs.getTime(2);
        java.util.Date d3 = rs.getTimestamp(3);
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
    }
}
