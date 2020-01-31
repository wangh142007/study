package com.wh.thread;

/**
 * @program: javabase
 * @description:
 * @author: wh
 * @create: 2019-10-31 10:28
 */
public class ThreadTest {

    private static void attack() {
        System.out.println("Fight");
        System.out.println("Current Thread is " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {

        Thread t = new Thread(){
            @Override
            public void run() {
                attack();
            }
        };
        System.out.println("Current Thread is " + Thread.currentThread().getName());
        t.run();
        t.start();

    }
}
