package com.northsea.Exception;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 异常：不正常
 *
 * 程序的异常：Throwable
 * 		严重问题：Error 不处理。这种问题一般都是很严重的，比如说内存溢出。
 * 		问题：Exception
 * 			编译期问题:不是RuntimeException的异常 必须进行处理的，因为不处理，编译不能通过。
 * 			运行期问题:RuntimeException	这种问题也不处理，因为是开发者的问题，
                       而且这个问题出现肯定是代码不够严谨，需要修正代码。
 *
 * 程序出现问题，没有做任何处理，最终jvm会做出默认的处理。
 * 把异常的名称，原因及出现的问题等信息输出在控制台。
 * 同时会结束程序。
 */
public class ExceptionDemo {
    /*
     * 如何处理异常
     *   A:try...
            catch...
               finally
     *   B:throws 抛出
     *
     * try...catch...finally的处理格式：
     * 		try {
     * 			可能出现问题的代码;
     * 		}catch(异常名 变量) {
     * 			针对问题的处理;
     * 		}finally {
     * 			释放资源; * 		}
     *
     * 变形格式：
     * 		try {
     * 			可能出现问题的代码;
     * 		}catch(异常名 变量) {
     * 			针对问题的处理;
     * 		}
     *
     * 注意：
     * 		A:try体内代码越少越好
     * 		B:catch内必须有内容，比如给出一个简单的提示也可
     */
    @Test
    public void ExceptionDemo() {
        // 第一阶段
        int a = 10;
        int b = 0;
        try {
            System.out.println(a / b);
        } catch (ArithmeticException ae) {
            System.out.println("除数不能为0!!!");
        }
        //第二阶段 如果上面出现异常不处理的话, 该阶段代码不执行
        System.out.println("over");
    }


    @Test
    public void ExceptionDemo2() {
        // method1();
        // method2();
        // method3();
        method4();
    }

    // 一个异常
    public static void method1() {
        // 第一阶段
        int a = 10;
        int b = 0;
        try {
            System.out.println(a / b);
        } catch (ArithmeticException ae) {
            System.out.println("除数不能为0!!!");
        }
        //第二阶段 如果上面出现异常不处理的话, 该阶段代码不执行
        System.out.println("over");
    }

    // 两个异常
    public static void method2() {
        int a = 10;
        int b = 0;
        try {
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            System.out.println("除数不能为0");
        }

        int[] arr = {1, 2, 3};
        try {
            System.out.println(arr[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("访问了不该的访问的索引");
        }

        System.out.println("over");
    }

    // 两个异常的处理
    public static void method3() {
        int a = 10;
        int b = 0;
        int[] arr = {1, 2, 3};

        try {
            System.out.println(arr[3]);
            System.out.println(a / b);
            // System.out.println(arr[3]);
        } catch (ArithmeticException e) {
            System.out.println("除数不能为0");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("访问了不该的访问的索引");
        }
        System.out.println("over");
    }

    public static void method4() {
        int a = 10;
        int b = 0;
        int[] arr = {1, 2, 3};

        try {
            System.out.println(a / b);
            System.out.println(arr[3]);
            System.out.println("这里出现了一个异常");
        } catch (ArithmeticException e) {
            System.out.println("除数不能为0");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("访问了不该的访问的索引");
        } catch (Exception e) {
            System.out.println("出问题了");
        }

        System.out.println("over");
    }


    /*
     * 有时是可以对异常进行处理的，但是又有些时候，根本就没有权限去处理某个异常。
     * 为了解决出错问题，Java针对这种情况，就提供了另一种处理方案：抛出
     *
     * 格式：
     * 		throws 异常类名
     * 		注意：这个格式必须跟在方法的括号后
     *
     * 注意：
     * 		开发过程中尽量不要在main方法上抛出异常
     *
     */
    @Test
    public void ExceptionDemo3() {
        System.out.println("今天天气很好");
        try {
            mod();
        }catch (ParseException e){
            e.printStackTrace();
        }
        System.out.println("但是不该有雾霾");
        mod2();
    }

    // 编译期异常的抛出
    // 在方法声明上抛出，是为了告诉调用者，此处有问题。
    public static void mod() throws ParseException {
        String s = "2014-11-20";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = sdf.parse(s);
        System.out.println(d);
    }

    // 运行期异常的抛出
    public static void mod2() throws ArithmeticException {
        int a = 10;
        int b = 0;
        System.out.println(a / b);
    }
}

