package com.northsea.File;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * 实现IO操作，须了解硬盘文件表现形式
 *   Java就提供了一个类File
 *
 * File:
       文件和目录(文件夹)路径名的抽象表示形式
 * 构造方法：
 * 		File(String pathname)：根据一个路径得到File对象
 * 		File(String parent, String child):根据一个目录和一个子文件/目录得到File对象
 * 		File(File parent, String child):根据一个父File对象和一个子文件/目录得到File对象
 */
public class FileDemo {
    @Test
    public void FileDemo() {
        // File(String pathname)：根据一个路径得到File对象
        // 把 E:\公司实习\文件操作\File\a.tex 封装成一个File对象
        File file = new File("E:\\公司实习\\文件操作\\File\\a.txt");

        // File(String parent, String child):根据一个目录和一个子文件/目录得到File对象
        File file2 = new File("E:\\公司实习\\文件操作\\File", "a.txt");

        // File(File parent, String child):根据一个父File对象和一个子文件/目录得到File对象
        File file3 = new File("E:\\公司实习\\文件操作\\File");
        File file4 = new File(file3, "a.txt");

        System.out.println(file4);
        // 三种方式效果一样
    }

    /*
     *创建功能:
     *  public boolean createNewFile():创建文件 如果文件存在，则不创建
     *  public boolean mkdir():创建文件夹 如果文件夹存在，则不创建
     *  public boolean mkdirs():创建文件夹,如果父文件夹不存在，则一同创建
     *
     *  boolean mkdir() :  创建此抽象路径名指定的目录。
        boolean mkdirs() :  创建此抽象路径名指定的目录，包括创建必需但不存在的父目录。
     *
     */
    @Test
    public void creatFileDemo() throws IOException {
        // 需求：在 E:\公司实习\文件操作 目录下创建一个文件夹demo
//        File file = new File("E:\\公司实习\\文件操作\\demo");
//        System.out.println("mkdir:" + file.mkdir());

        // 需求:在 E:\公司实习\文件操作\File 目录下创建一个文件a.txt
//        File file2 = new File("E:\\公司实习\\文件操作\\File\\a.txt");
//        System.out.println("createNewFile:" + file2.createNewFile());

        // 需求：在e盘目录test下创建一个文件b.txt
        // Exception in thread "main" java.io.IOException: 系统找不到指定路径。
        // 注意：要在某个目录下创建内容，该目录首先必须存在。
//        File file3 = new File("E:\\公司实习\\文件操作\\Filessss\\b.txt");
//        System.out.println("createNewFile:" + file3.createNewFile());


         // 需求:在 E:\公司实习\文件操作 目录下创建aaa目录
//         File file4 = new File("E:\\公司实习\\文件操作\\aaa");
//         System.out.println("mkdir:" + file4.mkdir());

//         File file5 = new File("E:\\公司实习\\文件操作\\test");
//         File file6 = new File("E:\\公司实习\\文件操作\\test\\aaa");
//         System.out.println("mkdir:" + file5.mkdir());
//         System.out.println("mkdir:" + file6.mkdir());


        // 更简单的方法
        File file7 = new File("E:\\公司实习\\文件操作\\aaa\\bbb\\ccc\\ddd");
        System.out.println("mkdirs:" + file7.mkdirs());



        File file8 = new File("E:\\公司实习\\文件操作\\demo\\a.txt");
        System.out.println("mkdirs:" + file8.createNewFile());
    }


    /*
     * 删除功能:public boolean delete()
     *
     * 注意：
     * 		A:如果创建文件或者文件夹无路径，默认是项目路径
     * 		B:Java中的删除不经过回收站。
     * 		C:要删除一个文件夹，请注意该文件夹内不能包含文件或者文件夹
     */
    @Test
    public void deleteFileDemo() {
        // 删除功能：要删除E:\公司实习\文件操作\demo\a.txt文件
//        File file = new File("E:\\公司实习\\文件操作\\demo\\a.txt");
//        System.out.println("delete:" + file.delete());

        // 删除功能：要删除E:\公司实习\文件操作\test\aaa文件夹
//        File file2 = new File("E:\\公司实习\\文件操作\\test\\aaa");
//        System.out.println("delete:" + file2.delete());

        // 删除功能：要删除E:\公司实习\文件操作\aaa文件夹
        // !!!要删除一个文件夹，请注意该文件夹内不能包含文件或者文件夹
//        File file3 = new File("E:\\公司实习\\文件操作\\aaa");
//        System.out.println("delete:" + file3.delete());


        File file4 = new File("E:\\公司实习\\文件操作\\aaa\\bbb");
        File file5 = new File("E:\\公司实习\\文件操作\\aaa");
        System.out.println("delete:" + file4.delete());
        System.out.println("delete:" + file5.delete());
    }


    /*
     * 重命名功能:public boolean renameTo(File dest)
     * 		如果路径名相同，就是改名。
     * 		如果路径名不同，就是改名并剪切。
     *
     * 路径以盘符开始：绝对路径	c:\\a.txt
     * 路径不以盘符开始：相对路径	a.txt
     */
    @Test
    public void renameToFileDemo() {
        File oldFileName = new File("E:\\公司实习\\文件操作\\File");
        File newFileName = new File("E:\\公司实习\\文件操作\\file");
        System.out.println("rename: " + oldFileName.renameTo(newFileName));
    }

    /*
     * 判断功能:
     * public boolean isDirectory():判断是否是目录
     * public boolean isFile():判断是否是文件
     * public boolean exists():判断是否存在
     * public boolean canRead():判断是否可读
     * public boolean canWrite():判断是否可写
     * public boolean isHidden():判断是否隐藏
     */
    @Test
    public void judgeFileDemo() {
        // 创建文件对象
        File file = new File("E:\\公司实习\\文件操作\\file\\a.txt");

        // public boolean isDirectory():判断是否是目录
        System.out.println("isDirectory: " + file.isDirectory());

        // public boolean isFile():判断是否是文件
        System.out.println("isFile: " + file.isFile());

        // public boolean exists():判断是否存在
        System.out.println("exists: " + file.exists());

        // public boolean canRead():判断是否可读
        System.out.println("canRead: " + file.canRead());

        // public boolean canWrite():判断是否可写
        System.out.println("canWrite: " + file.canWrite());

        // public boolean isHidden():判断是否隐藏
        System.out.println("isHidden: " + file.isHidden());
    }

    /*
     * 获取功能：
     * public String[] list():获取指定目录下的所有文件或者文件夹的名称数组
     * public File[] listFiles():获取指定目录下的所有文件或者文件夹的File数组
     */
    @Test
    public void getFileDemo() {
        // 指定一个目录
        File file = new File("E:\\公司实习\\文件操作\\");

        String[] list = file.list();
        for (String fileName : list) {
            System.out.println(fileName);
        }

        File[] listFile = file.listFiles();
        for (File fileName : listFile) {
            System.out.println(fileName);
            System.out.println("文件名: " + fileName.getName());
        }
    }
}
