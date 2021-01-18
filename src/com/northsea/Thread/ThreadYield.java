package com.northsea.Thread;

public class ThreadYield extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + ":" +i);
            if (i%10 == 0) {
                yield();//暂停当前正在执行的对象，并执行其他线程
            }
        }
    }
}
