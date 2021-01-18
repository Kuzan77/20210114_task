package com.northsea.Thread;
/*
 * 自定义线程类，该类要重写run()方法
 *
 */
public class MyThread extends Thread{
    
    public MyThread() {

    }
    
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + ":" + i);
        }
    }
}
