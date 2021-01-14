package com.northsea.Exception;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FinallyDemo {
    /*
     * finally:
             被finally控制的语句体一定会执行
     * 注意：
           如果是执行finally之前jvm退出了，则不执行
     *
     * A:格式
     * 		try...catch...finally...
     * B:用于释放资源，在IO流操作和数据库操作中会见到
     */
    @Test
    public void FinallyDemo1() {
        String s = "2014-11-20";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
//            System.exit(0);           // 如果加上这段代码, finally里面就不执行了
        }finally {
            System.out.println("这里的代码是执行的..........");
        }
        System.out.println(date);
    }


    /*
     * 面试题：
     * 1:final,finally和finalize的区别
     * final：可以修饰类，成员变量，成员方法
     * 		修饰类，不能被继承
     * 		修饰变量，是常量
     * 		修饰方法，方法不能被重写
     * finally：是异常处理的一部分，用于释放资源。
     * 		代码肯定会执行，特殊情况：在执行到finally之前jvm退出了
     * finalize：是Object类的一个方法，用于垃圾回收
     *
     * 2:如果catch内有return语句，请问finally里面的代码还会执行吗?
     *   如果会，请问是在return前，还是return后。
     *
     *
     *
     * 3:try...catch...finally的格式变形
     * 		A:try...catch...finally
     * 		B:try...catch
     * 		C:try...catch...catch...
     * 		D:try...catch...catch...finally
     * 		E:try...finally
     * 			这种做法的目前是为了释放资源。
     */
    @Test
    public void FinallyDemo2() {
        System.out.println(getInt());
    }
    public static int getInt() {
        int a = 10;
        try {
            System.out.println(a / 0);
            a = 20;
        }catch (ArithmeticException e) {
            a = 30;
            return a;
            /*
             * return a在程序执行到这一步时，不是return a而是return 30;返回路径形成
             * 但是后面还有finally，所以继续执行finally的内容，a=40
             * 再次回到以前的返回路径，继续走return 30;
             */
        }finally {
            a = 40;
            return a;
        }
    }
}
