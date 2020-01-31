package com.wh.thread;

/**
 * @program: javabase
 * @description:
 * @author: wh
 * @create: 2019-10-31 14:57
 */
public class WaitSleepDemo {

    public static void main(String[] args) {
        final Object lock = new Object();
        new Thread(new Runnable() {
            public void run() {
                System.out.println("thread A is waiting to get lock");
                synchronized (lock){
                    try {
                        System.out.println("thread A get lock");
                        Thread.sleep(20);
                        System.out.println("thread A do wait method");
                        lock.wait();
                        System.out.println("thread A is done");
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        try {
            Thread.sleep(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            public void run() {
                System.out.println("thread B is waiting to get lock");
                synchronized (lock){
                    try {
                        System.out.println("thread B get lock");
                        System.out.println("thread B is sleeping 10ms");
                        Thread.sleep(20);
                        System.out.println("thread B is done");
                        lock.notify();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
