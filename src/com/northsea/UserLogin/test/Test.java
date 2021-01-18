package com.northsea.UserLogin.test;

import com.northsea.UserLogin.dao.Impl.UserDaoImpl;
import com.northsea.UserLogin.dao.UserDao;
import com.northsea.UserLogin.game.Game;
import com.northsea.UserLogin.pojo.User;

import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        UserDao userDao = new UserDaoImpl();
        while (true) {
            System.out.println("-------------------------------------");
            System.out.println("------------欢迎进入系统---------------");
            System.out.println("-------------------------------------");
            System.out.println("------------请选择使用功能--------------");
            System.out.println("【1】登录       【2】注册        【3】退出");
            System.out.println("请输入您的选择: ");
            Scanner sc = new Scanner(System.in);
            String n = sc.nextLine();
            switch (n) {
                case "1":
                    System.out.println("请输入用户名: ");
                    String userName = sc.nextLine();
                    System.out.println("请输入密码: ");
                    String passWord = sc.nextLine();
                    boolean state = userDao.userLogin(userName, passWord);
                    if (state) {
                        System.out.println("----------恭喜您登录成功----------");
                        System.out.println("是否进行猜数字游戏 【1】是   【2】否 ");
                        System.out.println("请输入您的选择: ");
                        while (true) {
                            int choice = sc.nextInt();
                            if (choice == 1) {
                                Game.NumberGuessingGame();
                                System.out.println("++++++++++是否继续 【1】是   【2】否++++++++++");
                                System.out.println("-------------------------------");
                            }else if (choice == 2) {
                                System.out.println("退出系统成功!");
                                System.exit(0);
                            }else {
                                System.out.println("输入有误");
                            }
                        }
                    }else {
                        System.out.println("登录失败!!!");
                        break;
                    }
                case "2":
                    System.out.println("请输入用户名: ");
                    String username = sc.nextLine();
                    System.out.println("请输入密码: ");
                    String password = sc.nextLine();
                    User user = new User(username, password);
                    userDao.userRegister(user);
                    break;
                case "3":
                    System.out.println("退出系统成功!");
                    System.exit(0);
                default:
                    System.out.println("输入有误");
            }
        }
    }
}
