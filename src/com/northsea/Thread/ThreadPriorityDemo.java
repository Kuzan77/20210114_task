package com.northsea.Thread;

import org.junit.Test;
/*
 * 线程没有设置优先级,肯定有默认优先级。
 * 那么，默认优先级是多少呢?
 * 如何获取线程对象的优先级?
 * 		public final int getPriority():返回线程对象的优先级
 * 如何设置线程对象的优先级呢?
 * 		public final void setPriority(int newPriority)：更改线程的优先级。
 *
 * 注意：
 * 		线程默认优先级是5。
 * 		线程优先级的范围是：1-10
 *
 * IllegalArgumentException:非法参数异常。
 * 抛出的异常表明向方法传递了一个不合法或不正确的参数。
 *
 * 高优先级的线程总是大部分先执行完，并不是高优先级的完全先执行完。
 * 线程的优先级和执行顺序无关。出现这样的结果证明mythread2的优先级是最高的，
 * 说明线程的优先级具有一定的规则性，cpu尽量将执行资源让给优先级比较高的线程
 * 优先级高的线程执行快
 *
 */
public class ThreadPriorityDemo {
    public static void main(String[] args) {
        ThreadPriority tp1 = new ThreadPriority();
        ThreadPriority tp2 = new ThreadPriority();
        ThreadPriority tp3 = new ThreadPriority();

        tp1.setName("东方不败");
        tp2.setName("岳不群");
        tp3.setName("林平之");

        // 获取默认优先级
//        System.out.println(tp1.getPriority());
//        System.out.println(tp2.getPriority());
//        System.out.println(tp3.getPriority());

        //设置线程优先级
        tp1.setPriority(1);
        tp3.setPriority(10);

        System.out.println(tp1.getPriority());
        System.out.println(tp2.getPriority());
        System.out.println(tp3.getPriority());

        tp1.start();
        tp2.start();
        tp3.start();

    }
}
