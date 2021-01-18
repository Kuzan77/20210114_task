package com.northsea.Thread;

import java.util.Date;

public class ThreadSleep extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + ":" + ",日期" + new Date());
            // 睡眠
            // 困了，休息1秒钟
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
