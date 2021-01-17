package com.northsea.IO;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/*
 * OutputStreamWriter的方法：
 * public void write(int c):写一个字符
 * public void write(char[] cbuf):写一个字符数组
 * public void write(char[] cbuf,int off,int len):写一个字符数组的一部分
 * public void write(String str):写一个字符串
 * public void write(String str,int off,int len):写一个字符串的一部分
 *
 * 面试题：close()和flush()的区别?
 * A:close()关闭流对象，但是先刷新一次缓冲区。关闭之后，流对象不可以继续再使用了。
 * B:flush()仅仅刷新缓冲区,刷新之后，流对象还可以继续使用。
 */
public class OutputStreamWriterDemo {
    @Test
    public void OutputStreamWriterDemo() throws IOException {
        // 创建对象
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("osw.txt"));
        // 写数据
        // public void write(int c):写一个字符
        // osw.write('a');
        // osw.write(97);
        // 为什么数据没有进去呢?
        // 原因是：字符 = 2字节
        // 文件中数据存储的基本单位是字节。

        // public void write(char[] cbuf):写一个字符数组
        // char[] chars = {'a', 'b', 'c', 'd', 'e'};
        // osw.write(chars);

        // public void write(char[] cbuf,int off,int len):写一个字符数组的一部分
        // osw.write(chars, 1, 3);

        // public void write(String str):写一个字符串
        // osw.write("山东大学软件学院");

        // public void write(String str,int off,int len):写一个字符串的一部分
        // osw.write("山东大学软件学院", 2, 3);

        // 刷新缓冲区
        osw.flush();
        // osw.write("山东大学软件学院", 2, 3);

        // 释放资源
        osw.close();
        // java.io.IOException: Stream closed
        osw.write("山东大学软件学院", 2, 3);
    }


    public void CopyFileDemo() {

    }
}
