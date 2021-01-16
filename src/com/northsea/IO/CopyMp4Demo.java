package com.northsea.IO;

import org.junit.Test;

import java.io.*;

/*
 * 需求：把e:\\xxx.mp4复制到当前项目目录下的copy.mp4中
 *
 * 字节流四种方式复制文件：
 * 基本字节流一次读写一个字节：	共耗时：   毫秒
 * 基本字节流一次读写一个字节数组： 共耗时：毫秒
 * 高效字节流一次读写一个字节： 共耗时：毫秒
 * 高效字节流一次读写一个字节数组： 共耗时：毫秒
 */
public class CopyMp4Demo {
    @Test
    public void CopyMp4Demo() throws IOException {
        // 开始时间
        long start = System.currentTimeMillis();

        // method1("E:\\1.mp4", "copy1.mp4");      // 60841ms
        // method2("E:\\1.mp4", "copy2.mp4");      // 86ms
        // method3("E:\\1.mp4", "copy3.mp4");      // 335ms
        method4("E:\\1.mp4", "copy4.mp4");      // 27ms

        // 结束时间
        long end = System.currentTimeMillis();
        System.out.println("共耗时：" + (end - start) + "毫秒");
    }

    // 基本字节流一次读写一个字节
    public static void method1(String srcString, String destString) throws IOException {
        // 创建字节输入流对象
        FileInputStream fis = new FileInputStream(srcString);
        // 创建字节输出流对象
        FileOutputStream fos = new FileOutputStream(destString);

        int by = 0;
        while ((by = fis.read()) != -1) {
            fos.write(by);
        }

        // 释放资源
        fos.close();
        fis.close();
    }


    // 基本字节流一次读写一个字节数组
    public static void method2(String srcString, String destString) throws IOException {
        FileInputStream fis = new FileInputStream(srcString);
        FileOutputStream fos = new FileOutputStream(destString);

        byte[] bys = new byte[1024];
        int len = 0;
        while ((len = fis.read(bys)) != -1) {
            fos.write(bys, 0, len);
        }

        fos.close();
        fis.close();
    }

    // 高效字节流一次读写一个字节：
    public static void method3(String srcString, String destString)
            throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcString));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destString));

        int by = 0;
        while ((by = bis.read()) != -1) {
            bos.write(by);

        }
        bos.close();
        bis.close();
    }

    // 高效字节流一次读写一个字节数组：
    public static void method4(String srcString, String destString) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcString));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destString));

        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }

        bos.close();
        bis.close();
    }
}
