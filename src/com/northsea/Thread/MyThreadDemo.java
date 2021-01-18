package com.northsea.Thread;

import org.junit.Test;

/*
 *	进程：
 *		程序的运行过程，是系统进行资源分配和调用的独立单位。
 *		每一个进程都有它自己的内存空间和系统资源。
 *	线程：
 *		是进程中的单个顺序控制流，是一条执行路径
 *		一个进程如果只有一条执行路径，则称为单线程程序。
 *		一个进程如果有多条执行路径，则称为多线程程序。
 *
 *  并行和并发
 *		前者是逻辑上同时发生，指在某一个时间内同时运行多个程序。
 *		后者是物理上同时发生，指在某一个时间点同时运行多个程序。
 *
 * Java程序的运行原理：
 * 		由java命令启动JVM，JVM启动就相当于启动了一个进程。
 * 		接着有该进程创建了一个主线程去调用main方法。
 *
 * 思考题：
 * 		jvm虚拟机的启动是单线程的还是多线程的?
 *          多线程的。
            原因是垃圾回收线程也要先启动,否则很容易会出现内存溢出。
            现在的垃圾回收线程加上前面的主线程,最少启动了两个线程,所以,jvm的启动是多线程的
 */
public class MyThreadDemo {
    /*
     * 需求：实现多线程的程序。
     * 如何实现
     * Java提供的类
     * 		Thread
     * 		有两种方式实现多线程
     *
     * 方式1：继承Thread类。
     * 步骤
     * 		A:自定义类MyThread继承Thread类。
     * 		B:MyThread类里面重写run()?
     * 			为什么是run()方法呢?  // go
     * 		C:创建对象
     * 		D:启动线程
     */
    @Test
    public void MyThreadDemo() {
        // 创建两个线程对象
        MyThread m1 = new MyThread();
        MyThread m2 = new MyThread();

        // 启动线程
        m1.start();
        m2.start();
    }

    /*
     * 获取线程对象的名称
     *    public final String getName():获取线程的名称。
     * 设置线程对象的名称
     *    public final void setName(String name):设置线程的名称
     *
     * 针对不是Thread类的子类中如何获取线程对象名称呢?
     * public static Thread currentThread():返回当前正在执行的线程对象
     * Thread.currentThread().getName()
     */
    public static void main(String[] args) {
        //        // 创建线程对象
//        //无参构造+setXxx()
//        MyThread m1 = new MyThread();
//        MyThread m2 = new MyThread();
//        // 调用方法设置名称
//        m1.setName("张三");
//        m2.setName("李四");
//        // 启动进程
//        m1.start();
//        m2.start();

        //带参构造方法为线程命名
        MyThread m1 = new MyThread("张三");
        MyThread m2 = new MyThread("李四");
        // 启动进程
        m1.start();
        m2.start();

        //获取main方法所在的线程对象的名称
        //遇到这种情况,Thread类提供了一个方法:
        //public static Thread currentThread():返回当前正在执行的线程对象
        System.out.println(Thread.currentThread().getName());
    }
}
