package com.northsea.UserLogin.game;

import java.util.Scanner;

public class Game {
    public static void NumberGuessingGame() {
        int rnumber = (int) (Math.random() * 100 + 1);      // 生成1-100之间的随机数
        int i = 1;      // 用来记录猜题次数
        System.out.println("------猜数字游戏------");
        while (true) {
            System.out.println("请输入您猜的数字(1~100之间): ");
            Scanner sc = new Scanner(System.in);
            int number = sc.nextInt();
            if (number == rnumber) {
                System.out.println("恭喜您猜对了, 共猜了"+i+"次");
                break;
            }else if (number > rnumber) {
                System.out.println("很遗憾, 猜大了!!!");
                i++;
            }else if (number < rnumber){
                System.out.println("很遗憾, 猜小了!!!");
                i++;
            }else if (number > 100) {
                System.out.println("请输入1-100之间的数!!!");
            }else {
                System.out.println("请检查输入是否有误!!!");
            }
        }
    }
}