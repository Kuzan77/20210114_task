package com.northsea.Thread;

public class ThreadYieldDemo {
    public static void main(String[] args) {
        ThreadYield ty1 = new ThreadYield();
        ThreadYield ty2 = new ThreadYield();
        ThreadYield ty3 = new ThreadYield();

        ty1.setName("李一");
        ty2.setName("李二");
        ty3.setName("李三");

        ty1.start();
        ty2.start();
        ty3.start();


    }
}
