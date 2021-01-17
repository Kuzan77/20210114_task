package com.northsea.IO;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * InputStreamReader的方法：
 * int read():一次读取一个字符
 * int read(char[] chs):一次读取一个字符数组
 *
 * 转换流 java.io.InputStreamReader ，是Reader的子类，是从字节流到字符流的桥梁。
 * 该类读取字节，并使用指定的字符集将其解码为字符。它的字符集可以由名称指定，也可以接受平台的默认字符集。
 *
 * 构造方法
 * InputStreamReader(InputStream in) 创建一个使用默认字符集的 InputStreamReader。
 * InputStreamReader(InputStream in, String charsetName) 创建使用指定字符集的 InputStreamReader
 */
public class InputStreamReaderDemo {
    @Test
    public void InputStreamReaderDemo() throws IOException {
        // 创建对象
        //将字节流转换成字符流
        InputStreamReader isr = new InputStreamReader(new FileInputStream("isr.txt"));

        // int read():一次读取一个字符
//        int by = 0;
//        while ((by = isr.read()) != -1) {
//            System.out.println((char)by);
//        }

        // int read(char[] chs):一次读取一个字符数组
        char[] chars = new char[1024];
        int len = 0;
        while ((len = isr.read(chars)) != -1) {
            // System.out.println(new String(chars, 0, len));
            // 在这里不用进行类型转换了
            System.out.println(chars);
        }

        // 释放资源
        isr.close();
    }
}
