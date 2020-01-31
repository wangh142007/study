package com.wh.thread;

import java.util.concurrent.Callable;

/**
 * @program: javabase
 * @description:
 * @author: wh
 * @create: 2019-10-31 14:21
 */
public class MyCallble implements Callable<String> {

    public String call() throws Exception {
        String value = "test";
        System.out.println("Ready to work");
        Thread.currentThread().sleep(5000);
        System.out.println("take done");
        return value;
    }
}
