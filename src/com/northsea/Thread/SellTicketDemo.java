package com.northsea.Thread;

public class SellTicketDemo {
    public static void main(String[] args) {
        /*
         *  继承Thread类
         */
        // 创建三个线程对象
//        SellTicket st1 = new SellTicket();
//        SellTicket st2 = new SellTicket();
//        SellTicket st3 = new SellTicket();
//
//        // 给线程对象起名字
//        st1.setName("窗口1");
//        st2.setName("窗口2");
//        st3.setName("窗口3");
//
//        // 启动线程
//        st1.start();
//        st2.start();
//        st3.start();

        /*
         * 实现Runnable接口的方式实现
         */
        // 创建资源对象
        SellTicket2 st2 = new SellTicket2();
        // 创建三个线程对象
        Thread th1 = new Thread(st2, "窗口1");
        Thread th2 = new Thread(st2, "窗口2");
        Thread th3 = new Thread(st2, "窗口3");

        // 启动线程
        th1.start();
        th2.start();
        th3.start();

    }
}
