package com.northsea.File;

import java.io.File;

/*
 * 判断 E:\公司实习\文件操作 目录下是否有后缀名为.xxx的文件，若有，则输出此文件名称
 *
 * 分析：
 * 		A:封装 E:\公司实习\文件操作 判断目录
 * 		B:获取该目录下所有文件或者文件夹的File数组
 * 		C:遍历该File数组，得到每一个File对象，然后判断
 * 		D:是否是文件
 * 			是：继续判断是否以.jpg结尾
 * 				是：就输出该文件名称
 * 				否：不搭理它
 * 			否：不搭理它
 */
public class FileDemoTest {
    public static void main(String[] args) {

//        // 封装 E:\公司实习\文件操作 判断目录
//        File file = new File("E:\\公司实习\\文件操作");
//
//        // public File[] listFiles():获取指定目录下的所有文件或者文件夹的File数组
//        File[] listFile = file.listFiles();
//        for (File f : listFile) {
//            // 判断是否是文件
//            if (f.isFile()) {
//                // 再判断文件名是否以.jpg结尾
//                if (f.getName().endsWith(".jpg")) {
//                    System.out.println(f.getName());
//                }
//            }
//        }
        String filePath = "E:\\资料整理";
        String fileSuffix = ".docx";
        findFile(filePath, fileSuffix);
    }

    // 封装代码
    public static void findFile(String filePath, String fileSuffix) {
        // 封装 E:\公司实习\文件操作 判断目录
        File file = new File(filePath);

        // public File[] listFiles():获取指定目录下的所有文件或者文件夹的File数组
        File[] listFile = file.listFiles();
        for (File f : listFile) {
            // 判断是否是文件
            if (f.isFile()) {
                // 再判断文件名是否以.jpg结尾
                if (f.getName().endsWith(fileSuffix)) {
                    System.out.println(f.getName());
                }
            }
        }
    }
}
