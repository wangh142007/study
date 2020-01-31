package com.wh.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @program: javabase
 * @description:
 * @author: wh
 * @create: 2019-10-31 14:24
 */
public class FutureTaskDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask ft = new FutureTask(new MyCallble());
        new Thread(ft).start();
        if (!ft.isDone()){
            System.out.println("task has not finished ,please wait");
        }
        System.out.println("task return: "+ft.get());
    }
}
