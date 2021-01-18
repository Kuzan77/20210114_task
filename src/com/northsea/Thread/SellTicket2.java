package com.northsea.Thread;

public class SellTicket2 implements Runnable{
//    // 定义100张票
//    // private int tickets = 100;
//    // 为了让多个线程对象共享这100张票，应该用静态修饰
//    private static int tickets = 100;
//
//    @Override
//    public void run() {
//        while (true) {
//            if (tickets > 0) {
//                System.out.println(Thread.currentThread().getName() + "正在出售第" + (tickets --) + "张票");
//            }
//        }
//    }

    /*
    * 如何解决线程安全问题
    *
    * 要想解决问题，就要知道哪些原因会导致出问题:
         (而且这些原因也是判断一个程序是否会有线程安全问题的标准)
    * A:是否是多线程环境
    * B:是否有共享数据
    * C:是否有多条语句操作共享数据
    *
    * 程序中是否存在以上问题
    * A:是否是多线程环境	是
    * B:是否有共享数据	    是
    * C:是否有多条语句操作共享数据	是
    *
    * 由此可见程序出现问题是正常的，因为它满足出问题的条件。
    * 接下来是如何解决问题
    * A和B的问题改变不了，只能想办法去把C改变一下
    * 思想：
    * 		把多条语句操作共享数据的代码给包成一个整体，让某个线程在执行的时候，其它不能执行
    * 问题是怎么包?
         Java给我们提供了：同步机制。
    *
    * 同步代码块：
    * 		synchronized(对象){
    * 			需要同步的代码;
    * 		}
    *
    * 		A:对象是什么
    * 			可以随便创建一个对象测试
    * 		B:需要同步的代码
    * 			把多条语句操作共享数据的代码的部分给包起来
    *
    * 		注意：
    * 			同步可以解决安全问题的根本原因就在那个对象上。该对象如同锁的功能。
    * 			多个线程必须是同一把锁。
    */
    // 定义100张票
    private int tickets = 100;
    //创建锁对象
    private Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (tickets > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets -- + "张票");
                }
            }
        }
    }
}
