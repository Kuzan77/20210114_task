package com.northsea.IO;

import org.junit.Test;

import java.io.*;

/*
 * 需求：把当前项目目录下的a.txt内容复制到当前项目目录下的b.txt中
 *
 * 数据源：
 * 		a.txt -- 读取数据 -- 字符转换流 -- InputStreamReader
 * 目的地：
 * 		b.txt -- 写出数据 -- 字符转换流 -- OutputStreamWriter
 */
public class CopyFileDemo2 {
    @Test
    public void CopyFileDemo2() throws IOException {
        // 封装数据源
        InputStreamReader isr = new InputStreamReader(new FileInputStream("a.txt"));

        // 封装目的地
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("b.txt"));

        char[] chars = new char[1024];
        int len = 0;
        while ((len = isr.read(chars)) != -1) {
            osw.write(chars, 0, len);
        }

        // 刷新缓冲区
        osw.flush();

        // 释放资源
        osw.close();
    }
}
