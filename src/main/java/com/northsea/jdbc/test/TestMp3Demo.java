package com.northsea.jdbc.test;

import com.mysql.cj.jdbc.exceptions.PacketTooBigException;
import com.northsea.jdbc.util.JdbcUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;


import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import java.io.*;
import java.sql.*;

/**
 * Mp3
 * @author ：mmzs
 * @date ：Created in 2021/1/22 16:21
 */
public class TestMp3Demo {

    /**
     * 向数据库添加MP3
     */
    @Test
    public void insertMp3() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // 获取连接
            conn = JdbcUtils.getConnection();
            // 创建sql语句
            String sql = "insert into music values(?,?,?)";
            //创建PreparedStatement对象
            pstmt = conn.prepareStatement(sql);
            // 设置参数
            pstmt.setInt(1,2);
            pstmt.setString(2, "Faded.mp3");

//            //把文件转换成byte[]
//            byte[] bytes= IOUtils.toByteArray(new FileInputStream("丢了你.mp3"));
//            //使用字节数组类型byte[]创建 Blob
//            Blob blob = new SerialBlob(bytes);
//            pstmt.setBlob(3, blob);

            InputStream in = new FileInputStream("Faded.mp3");
            pstmt.setAsciiStream(3, in);
            pstmt.executeUpdate();
        } catch (PacketTooBigException p) {
            System.out.println("文件过大!!!");
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在!!!");
        } catch (SQLException e) {
            System.out.println("执行sql失败!!!");
        }

        JdbcUtils.closep(conn, pstmt);
    }

    /**
     * 获取数据库的MP3文件
     * 读取二进制数据，需要在查询后使用 ResultSet 类的 getBinaryStream()方法来获取输入流对象。
     */
    @Test
    public void selectMp3() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 获取连接
            conn = JdbcUtils.getConnection();
            // 创建sql语句
            String sql = "select musicname, musicfile from music where id=?";

            // 生成发送器(语句发送器)
            // 通过Connection得到prepareStatement对象
            // 使用prepareStatement发送sql语句
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, 1);

            // 执行并返回执行结果
            rs = pstmt.executeQuery();
            rs.next();

            String filename = rs.getString("musicname");
            OutputStream out = new FileOutputStream(filename);
            InputStream in = rs.getBinaryStream("musicfile");
            IOUtils.copy(in, out);
            out.close();
        } catch (SQLException e) {
            System.out.println("执行sql失败!!!");
        } catch (FileNotFoundException e) {
            System.out.println("文件名不存在!!!");
        } catch (IOException e) {
            System.out.println("拷贝字节数据失败!!!");
        } finally {
            // 关闭资源
            JdbcUtils.closep(conn, pstmt, rs);
        }
    }

    /**
     * 把要存储的数据包装成 Blob 类型，然后调用 PreparedStatement 的 setBlob()
     * 方法来设置数据
     */
    @Test
    public void blobInsert() {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into music(musicname,musicfile) values(?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "a.jpg");

            //把文件转换成byte[]
            byte[] bytes= IOUtils.toByteArray(new FileInputStream("a.jpg"));
            //使用字节数组类型byte[]创建 Blob
            Blob blob = new SerialBlob(bytes);
            pstmt.setBlob(2, blob);     //设置Blob类型的参数
            int num = pstmt.executeUpdate();
            if (num != 0) {
                System.out.println("执行成功!!!");
            }else {
                System.out.println("执行失败!!!");
            }
        } catch (SerialException throwables) {
            System.out.println("创建创建 Blob对象失败!!!");
        } catch (FileNotFoundException e) {
            System.out.println("未找到文件");
        }catch (IOException e) {
            System.out.println("读取文件失败!!!");
        } catch (SQLException throwables) {
            System.out.println("sql语句执行失败");
        } finally {
            JdbcUtils.closep(conn, pstmt);
        }
    }

    @Test
    public void blobSelect() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = JdbcUtils.getConnection();
            String sql = "select musicname, musicfile from music where id=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, 3);
            rs = pstmt.executeQuery();
            rs.next();
            String filename = rs.getString("musicname");
//            File file = new File(filename) ;
            Blob blob = rs.getBlob("musicfile");

//            byte[] datas = blob.getBytes(0, (int)file.length());
//            FileUtils.writeByteArrayToFile(file, datas);

            /*
             * 1.通过Blob得到输入流对象
             * 2.自己创建输出流对象
             * 3.把输入流对象写入到输出流中
             * */
            InputStream in = blob.getBinaryStream();
            OutputStream out= new FileOutputStream(filename);
            IOUtils.copy(in, out);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // 关闭资源
            JdbcUtils.closep(con, pstmt, rs);
        }
    }
}
