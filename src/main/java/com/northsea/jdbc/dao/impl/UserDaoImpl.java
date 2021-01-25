package com.northsea.jdbc.dao.impl;

import com.northsea.jdbc.dao.UserDao;
import com.northsea.jdbc.pojo.User;
import com.northsea.jdbc.util.JdbcUtils;
import com.northsea.jdbc.util.MyEncrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：mmzs
 * @date ：Created in 2021/1/23 16:00
 */
public class UserDaoImpl implements UserDao {
    /**
     * 添加用户
     * @param user
     */
    @Override
    public void add(User user) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // 获取连接
            conn = JdbcUtils.getConnection();
            String sql = "insert into user value(?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUid());
            pstmt.setString(2, user.getUsername());

            // MD5加密
            // String pwd = MyEncrypt.md5(user.getPassword());

            pstmt.setString(3, user.getPassword());
            pstmt.executeUpdate();
        } catch(Exception e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭资源
           JdbcUtils.closep(conn, pstmt);
        }
    }

    @Override
    public void mod(User user) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "update user set username=?, password=? where uid=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getUid());

            pstmt.executeUpdate();
        } catch(Exception e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭资源
            JdbcUtils.closep(conn, pstmt);
        }
    }

    /**
     * 删除用户
     * @param uid
     */
    @Override
    public void del(String uid) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "delete from user where uid=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, uid);
            pstmt.executeUpdate();
        } catch(Exception e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.closep(conn, pstmt);
        }
    }

    /**
     * 根据ID查询用户
     * @param uid
     * @return
     */
    @Override
    public User load(String uid) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = JdbcUtils.getConnection();
            String sql = "select * from user where uid=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, uid);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                return new User(rs.getString(1), rs.getString(2),
                        rs.getString(3));
            }
            return null;
        } catch(Exception e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.close(con, pstmt, rs);
        }
    }

    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<User> findAll() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = JdbcUtils.getConnection();
            String sql = "select * from user";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            List<User> userList = new ArrayList<>();
            while(rs.next()) {
                userList.add(new User(rs.getString(1), rs.getString(2),
                        rs.getString(3)));
            }
            return userList;
        } catch(Exception e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.closep(con, pstmt, rs);
        }
    }
}
