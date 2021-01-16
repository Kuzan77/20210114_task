package com.northsea.IO;

import org.junit.Test;

import java.io.*;

/*
 * 有一个缓冲区还是较为专业
 *
 * 类被称为：缓冲区类(高效类)
 * 写数据：BufferedOutputStream
 * 读数据：BufferedInputStream
 *
 * 构造方法可以指定缓冲区的大小，因为默认缓冲区大小就足够
 *
 * 为什么不传递一个具体的文件或者文件路径，而是传递一个OutputStream对象
 * 原因是字节缓冲区流仅仅提供缓冲区，为高效而设计。但是真正的读写操作还得靠基本的流对象实现。
 */
public class BufferedOutputStreamDemo {
    // 写入
    @Test
    public void BufferedOutputStreamDemo() throws IOException {
        // BufferedOutputStream(OutputStream out)
        // FileOutputStream fos = new FileOutputStream("bos.txt");
        // BufferedOutputStream bos = new BufferedOutputStream(fos);
        // 简单写法
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("bos.txt"));
        // 写数据
        bos.write("hello".getBytes());

        // 释放资源
        bos.close();
    }

    // 读取
    /*
     * 注意：有两种方式可以读取，但是，请注意，这两种方式针对同一个对象在一个代码中只能使用一个。
     */
    @Test
    public void BufferedInputStreamDemo() throws IOException {

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("bos.txt"));

        // 1.int read():一次读取一个字节
//        int by = 0;
//        // 读取，赋值，判断
//        while ((by = bis.read()) != -1) {
//            System.out.print((char) by);
//        }

        // 2.int read(byte[] b):一次读取一个字节数组
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = bis.read(bytes)) != -1) {
            // public String(byte[] bytes,int index,int length):把字节数组的一部分转成字符串
            System.out.println(new String(bytes, 0, len));
        }

        // 释放资源
        bis.close();
    }
}
