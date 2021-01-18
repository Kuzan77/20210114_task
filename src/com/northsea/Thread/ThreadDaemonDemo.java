package com.northsea.Thread;

import org.junit.Test;

/*
 * public final void setDaemon(boolean on):将该线程标记为守护线程或用户线程。
 * 当正在运行的线程都是守护线程时，Java 虚拟机退出。 该方法必须在启动线程前调用。
 * 只要当前JVM实例中尚存在任何一个非守护线程没有结束，守护线程就全部工作；只有当最后一个非守护线程结束时，守护线程随着JVM一同结束工作
 */
public class ThreadDaemonDemo {
    public static void main(String[] args) {
        // 创建线程对象
        ThreadDaemon td1 = new ThreadDaemon();
        ThreadDaemon td2 = new ThreadDaemon();

        td1.setName("关羽");
        td2.setName("张飞");

        // 设置守护线程
        td1.setDaemon(true);
        td2.setDaemon(true);

        // 启动线程
        td1.start();
        td2.start();

        Thread.currentThread().setName("刘备");
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
