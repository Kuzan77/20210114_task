package com.northsea.Thread;

import java.util.Date;

public class ThreadStop extends Thread{
    @Override
    public void run() {
        System.out.println("开始执行：" + new Date());
        // 休息10秒钟, 不要打扰
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
