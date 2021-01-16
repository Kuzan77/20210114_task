package com.northsea.IO;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * IO流分类：
 * 		流向：
 * 			输入流	读取数据
 * 			输出流 写出数据
 * 		数据类型：
 * 			字节流
 * 				字节输入流	读取数据	InputStream
 * 				字节输出流	写出数据	OutputStream
 * 			字符流
 * 				字符输入流	读取数据	Reader
 * 				字符输出流	写出数据	Writer
 *
 * 		注意：默认情况下是按照数据类型分
 */
public class FileOutputStreamDemo {
    /* 需求：要向文本文件中输入："hello,io"
     *
     * 使用：OutputStream
     * 流对象是一个抽象类，不能实例化
     * 所以，要一个具体的子类。
     * 而要找的子类名称：
     * 文件：File
     * 然后用的是字节输出流：FileOutputStream
     * 注意：基类的子类都是以父类名作为后缀名。
     * 		XxxOutputStream
     * 		XxxInputStream
     * 		XxxReader
     * 		XxxWriter
     * FileOutputStream的构造方法：
     * 		FileOutputStream(File file)
     *		FileOutputStream(String name)
     *
     * 字节输出流操作步骤：
     * 		A:创建字节输出流对象
     * 		B:写数据
     * 		C:释放资源
     */
    @Test
    public void FileOutputStreamDemo() throws IOException {
        // 创建字节输出流对象
        // FileOutputStream(File file)
        // File file = new File("fos.txt");
        // FileOutputStream fos = new FileOutputStream(file);
        // FileOutputStream(String name)
        FileOutputStream fos = new FileOutputStream("E:\\公司实习\\文件操作\\io\\fos.txt");

        // 写数据
        fos.write("hello,io".getBytes());
        fos.write("java".getBytes());

        //释放资源
        //关闭此文件输出流并释放与此流有关的所有系统资源
        fos.close();
        /*
         * 一定要close()
         * A:流对象变成垃圾，就可以被垃圾回收器回收
         * B:通知系统去释放跟该文件相关的资源
         */
    }

    /*
     * 字节输出流操作步骤：
     * A:创建字节输出流对象
     * B:调用write()方法
     * C:释放资源
     *
     * public void write(int b):写一个字节
     * public void write(byte[] b):写一个字节数组
     * public void write(byte[] b,int off,int len):写一个字节数组的一部分
     */
    @Test
    public void FileOutputStreamDemo2() throws IOException {
        // 创建字节输出流对象
        // OutputStream os = new FileOutputStream("fos2.txt"); // 多态
        FileOutputStream fos = new FileOutputStream("E:\\公司实习\\文件操作\\io\\fos2.txt");
        // 调用write()方法
        // public void write(int b):写一个字节
//        fos.write(97);
//        fos.write(57);
//        fos.write(55);

        //public void write(byte[] b):写一个字节数组
        byte[] bys={97,98,99,100,101};
//        fos.write(bys);

        //public void write(byte[] b,int off,int len):写一个字节数组的一部分
        fos.write(bys,1,3);

        //释放资源
        fos.close();
    }

    /*
     * 实现换行
     *
     * 		windows:\r\n
     * 		linux:\n
     * 		Mac:\r
     * 		有些常见的个高级记事本，是可以识别任意换行符号的。
     *
     * 如何实现数据的追加写入
     * 		用构造方法带第二个参数是true的情况即可
     */
    @Test
    public void FileOutputStreamDemo3() throws IOException {
        // 创建字节输出流对象
        // FileOutputStream fos = new FileOutputStream("fos3.txt");
        // 创建一个向具有指定 name 的文件中写入数据的输出文件流。如果第二个参数为 true，则将字节写入文件末尾处，而不是写入文件开始处。
        FileOutputStream fos = new FileOutputStream("E:\\公司实习\\文件操作\\io\\fos3.txt", true);

        // 写数据
        for (int i = 0; i < 10; i++) {
            fos.write(("hello" + i).getBytes());
            fos.write("\r\n".getBytes());
        }
        // 释放资源
        fos.close();
    }

    /*
     * 加入异常处理的字节输出流操作
     */
    @Test
    public void FileOutputStreamDemo4() {
        // 在finally里面能够看到该对象则必须定义到外面，为了问不出问题，必须给初始化值
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("E:\\公司实习\\文件操作\\io\\fos4.txt");
            fos.write("java".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fos != null) {
                // 如果fos不为null，则需要释放资源
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
