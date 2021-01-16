package com.northsea.IO;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * 字节输入流操作步骤：
 * A:创建字节输入流对象
 * B:调用read()方法读取数据，并把数据显示在控制台
 * C:释放资源
 *
 * 读取数据的方式：
 * A:int read():一次读取一个字节
 * B:int read(byte[] b):一次读取一个字节数组
 */
public class FileInputStreamDemo {
    @Test
    public void FileInputStreamDemo() throws IOException {
        // 创建字节输入流对象
        // FileInputStream(String name)
        // FileInputStream fis = new FileInputStream("fis.txt");
        FileInputStream fis = new FileInputStream("E:\\公司实习\\文件操作\\io\\fis.txt");
        int by = 0;
        // 读取，赋值，判断
        while ((by = fis.read()) != -1) {
            System.out.print((char) by);
        }

        // 释放资源
        fis.close();
    }


    /*
     * 一次读取一个字节数组：int read(byte[] b)
     * 返回值其实是实际读取的字节个数
     */
    @Test
    public void FileInputStreamDemo2() throws IOException {
        // 创建字节输入流对象
        FileInputStream fis = new FileInputStream("E:\\公司实习\\文件操作\\io\\fis.txt");

        // 最终版代码
        // 数组的长度一般是1024或者1024的整数倍
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fis.read(bytes)) != -1) {
            // public String(byte[] bytes,int index,int length):把字节数组的一部分转成字符串
            System.out.println(new String(bytes, 0, len));
        }

        // 释放资源
        fis.close();
    }


}
