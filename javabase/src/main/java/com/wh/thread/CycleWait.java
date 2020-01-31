package com.wh.thread;

/**
 * @program: javabase
 * @description:
 * @author: wh
 * @create: 2019-10-31 14:09
 */
public class CycleWait implements Runnable {

    private String value;

    public void run() {

        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value = "we have data now";
    }

    public static void main(String[] args) throws InterruptedException {
        CycleWait cw = new CycleWait();
        Thread t = new Thread(cw);
        t.start();
        t.join();
        System.out.println("value :" + cw.value);
    }
}
