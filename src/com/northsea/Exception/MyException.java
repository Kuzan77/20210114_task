package com.northsea.Exception;

/*
 * java不可能对所有的情况都考虑到，所以，在实际的开发中，需要定义异常。
 * 类是一个异常类，就必须继承自Exception或者RuntimeException
 *
 * 两种方式：
 * A:继承Exception
 * B:继承RuntimeException
 *
 * RunTimeException和其他Exception区分：
        其他Exception，受检查异常。可以理解为错误，必须要开发者解决以后才能编译通过，解决的方法有两种，
        1：throw到上层，
        2，try-catch处理。
    RunTimeException：
        运行时异常，又称不受检查异常，不受检查！不受检查！！不受检查！！！重要的事情说三遍，
        因为不受检查，所以在代码中可能会有RunTimeException时Java编译检查时不会告诉你有这个异常，
        但是在实际运行代码时则会暴露出来，比如经典的1/0，空指针等。
        如果不处理也会被Java自己处理。

    异常的分类
 */
public class MyException extends Exception{
    public MyException() {

    }

    public MyException(String message) {
        super(message);
    }
}

// RuntimeException: 会进行回滚(rollback)
// 如果出现异常, 会回滚到初始状态
// public class MyException extends RuntimeException {
//
// }