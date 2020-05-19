package com.van.testaop;

import ch.qos.logback.core.util.TimeUtil;

import java.util.concurrent.*;

/**
 * @author: Van
 * @create: 2019-09-02 18:21
 * @description: 线程池练习：
 * 线程池的几种实现方式：
 * ①继承Thread类
 * ②实现runnable接口 重写run方法
 * ③实现callable接口 重写call接口
 * ④使用Java多线程的方式，线程池
 * 4.1线程池三种实现方式
 * ExecutorService threadpool = Executors.newFixedThreadPool(0);==定长线程池
 * ExecutorService threadpool2 = Executors.newSingleThreadExecutor(new Thread());==一个线程池
 * ExecutorService threadpool3 = Executors.newCachedThreadPool();==缓存线程池
 * @program: testaop
 * @version: 1.0
 **/
public class MyThreadPoolDemo {

    public static void main(String[] args) {
        //①2:核心数 ②5:最大数 ③1L:生存时间  ④new LinkedBlockingQueue<Runnable>(3)阻塞队列 ⑤Executors.defaultThreadFactory()线程工厂类 拒绝策列
        ExecutorService threadpool3 = Executors.newScheduledThreadPool(7);
        ExecutorService thread = new ThreadPoolExecutor(
                2,//核心数
                5,//最大数
                1L, //生存时间
                TimeUnit.SECONDS,//时间单位
                new LinkedBlockingQueue<Runnable>(3),//阻塞队列数量
                Executors.defaultThreadFactory(),//线程工厂类
//                new ThreadPoolExecutor.AbortPolicy());//默认拒绝策略
//                new ThreadPoolExecutor.CallerRunsPolicy());//调运这运行策略
//                new ThreadPoolExecutor.DiscardOldestPolicy());//排除等待最久策略
                new ThreadPoolExecutor.DiscardPolicy());//丢弃任务策略
        try {
            //模拟i个客户办理业务
            for (int i = 1; i <= 10; i++) {
                thread.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "办理业务");
                });
//                TimeUnit.MILLISECONDS.sleep(300);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            thread.shutdown();
        }

    }

    private static void threadPoolInit() {
        //        查看CPU核数
//        System.out.println(Runtime.getRuntime().availableProcessors());

//        ExecutorService threadpool = Executors.newScheduledThreadPool(1);
//        ExecutorService threadpool = Executors.newWorkStealingPool();

//        ExecutorService threadpool = Executors.newFixedThreadPool(8);//定长线程池
//        ExecutorService threadpool = Executors.newSingleThreadExecutor();//一个线程池一个线程
        ExecutorService threadpool = Executors.newCachedThreadPool();//缓存线程池 一个线程池N个线程

        try {
            for (int i = 1; i <= 9; i++) {
                threadpool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "办理业务");
                });
                TimeUnit.MILLISECONDS.sleep(300);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadpool.shutdown();
        }
    }
}
