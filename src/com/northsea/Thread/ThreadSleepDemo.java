package com.northsea.Thread;

import org.junit.Test;

/*
 * 线程休眠
 *		public static void sleep(long millis)
 */
public class ThreadSleepDemo {
    public static void main(String[] args) {
        // 创建线程对象
        ThreadSleep ts1 = new ThreadSleep();
        ThreadSleep ts2 = new ThreadSleep();
        ThreadSleep ts3 = new ThreadSleep();

        // 为线程命名
        ts1.setName("林青霞");
        ts2.setName("林志玲");
        ts3.setName("林志颖");

        // 启动线程
        ts1.start();
        ts2.start();
        ts3.start();
    }
}
