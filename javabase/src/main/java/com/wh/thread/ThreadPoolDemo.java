package com.wh.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @program: javabase
 * @description:
 * @author: wh
 * @create: 2019-10-31 14:34
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService newCachedThreadPoll = Executors.newCachedThreadPool();
        Future<String> future = newCachedThreadPoll.submit(new MyCallble());
        if (!future.isDone()) {
            System.out.println("task has not finished ,please wait");
        }
        try {
            System.out.println("task return: " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            newCachedThreadPoll.shutdown();
        }
    }

}
