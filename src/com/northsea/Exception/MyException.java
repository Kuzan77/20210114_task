package com.northsea.Exception;

/*
 * java不可能对所有的情况都考虑到，所以，在实际的开发中，需要定义异常。
 * 类是一个异常类，就必须继承自Exception或者RuntimeException
 *
 * 两种方式：
 * A:继承Exception
 * B:继承RuntimeException
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