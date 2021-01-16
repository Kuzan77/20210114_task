package com.northsea.IO;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/*
 * 复制文本文件。
 *
 * 数据源：
 * a.txt	--	读取数据	--	FileInputStream
 *
 * 目的地：
 * b.txt	--	写数据		--	FileOutputStream
 *
 * java.io.FileNotFoundException: a.txt (系统找不到指定的文件。)
 *
 */
public class CopyFileDemo {

//    public static File getFile() {
//        System.out.println("请输入一个文件路径：");
//        Scanner s = new Scanner(System.in);
//        while (true) {
//            String ss = s.nextLine();
//            File file = new File(ss);
//            if (!file.exists()) {
//                System.out.println("文件路径不存在");
//            } else if (file.isDirectory()) {
//                System.out.println("您录入的是文件夹路径,请重新录入:");
//            } else {
//                return file;
//            }
//        }
//    }

    // 封装方法
    public static void CopyFile(String start, String over) throws IOException{
        // 封装数据源
        // 创建字节输入流对象
        FileInputStream fis = new FileInputStream(start);
        // 封装目的地
        // 创建字节输出流对象
        FileOutputStream fos = new FileOutputStream(over);

        // int read():一次读取一个字节
        int by = 0;
        while ((by = fis.read()) != -1) {
            fos.write(by);
        }
        // 释放资源(无顺序)
        fos.close();
        fis.close();
    }

    @Test
    public void CopyFileDemo() throws IOException {
//        // 封装数据源
//        // 创建字节输入流对象
//        FileInputStream fis = new FileInputStream("E:\\公司实习\\文件操作\\io\\a.txt");
//        // 封装目的地
//        // 创建字节输出流对象
//        FileOutputStream fos = new FileOutputStream("E:\\公司实习\\文件操作\\io\\b.txt");
//
//        // int read():一次读取一个字节
//        int by = 0;
//        while ((by = fis.read()) != -1) {
//            fos.write(by);
//        }
//        // 释放资源(无顺序)
//        fos.close();
//        fis.close();

        String start = "E:\\公司实习\\文件操作\\io\\a.txt";
        String over = "E:\\公司实习\\文件操作\\io\\b.txt";
        CopyFile(start, over);
    }

    /*
     * 需求：把c盘下的a.txt的内容复制到d盘下的b.txt中
     *
     * 数据源：
     * 		c:\\a.txt	--	读取数据--	FileInputStream
     * 目的地：
     * 		d:\\b.txt	--	写出数据	--	FileOutputStream
     */
    @Test
    public void CopyFileDemo2() throws IOException {
        String start = "C:\\a.txt";
        String over = "E:\\b.txt";
        CopyFile(start, over);
    }

    /*
     * 需求：把e:\\xxx.jpg内容复制到当前项目目录下的mn.jpg中
     *
     * 数据源：
     * 		e:\\xxx.jpg	--读取数据--FileInputStream
     * 目的地：
     * 		mn.jpg--写出数据--FileOutputStream
     */
    @Test
    public void CopyImageDemo() throws IOException {
        String start = "E:\\2.jpg";
        String over = "mn.jpg";
        CopyFile(start, over);
//        System.out.println("用户的当前工作目录:/n"+System.getProperty("user.dir"));
    }

    /*
     * 需求：把e:\\xxx.mp4复制到当前项目目录下的copy.mp4中
     *
     * 数据源：
     * 		e:\\xxx.mp4--读取数据--FileInputStream
     * 目的地：
     * 		copy.mp4--写出数据--FileOutputStream
     */
    @Test
    public void CopyMp4Demo() throws IOException {
        String start = "E:\\1.mp4";
        String over = "copy.mp4";
        CopyFile(start, over);
    }
}
