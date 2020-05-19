package com.van.testaop;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThread implements Runnable {
    @Override
    public void run() {

    }
}

class MyThread2 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("============Callable============");
        return 1111;
    }
}

/**
 * @author: Van
 * @create: 2019-09-02 10:30
 * @description: CallableDemo测试
 * @program: testaop
 * @version: 1.0
 **/
public class CallableDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread2());
        new Thread(futureTask, "AA").start();
        System.out.println(Thread.currentThread().getName() + "-------");

        int futureTask1 = 100;

        Integer futureTask2 = futureTask.get();
        System.out.println("****返回" + (futureTask1 + futureTask2));
    }
}
