package com.northsea.IO;

import org.junit.Test;

import java.io.*;

/*
 * 字符缓冲流特殊方法：
 * BufferedWriter:
 * 		public void newLine():根据系统决定换行符
 * BufferedReader:
 * 		public String readLine()：一次读取一行数据
 * 		包含该行内容的字符串，不包含任何行终止符，如果已到达流末尾，则返回 null
 */
public class BufferedDemo {
    @Test
    public void BufferedDemo() throws IOException {
        // write();
        read();
    }

    public static void read() throws IOException {
        // 创建字符缓冲输入流对象
        BufferedReader br = new BufferedReader(new FileReader("bw.txt"));

        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        // 释放资源
    }
    public static void write() throws IOException {
        // 创建字符缓冲输出流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("bw.txt"));

        for (int i = 0; i < 10; i++) {
            bw.write("hello" + i);
            // bw.write("\r\n");
            bw.newLine();

            // 刷新缓冲区
            bw.flush();
        }
        bw.close();
    }
}
