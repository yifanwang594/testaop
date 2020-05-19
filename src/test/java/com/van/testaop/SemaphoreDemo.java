package com.van.testaop;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author: Van
 * @create: 2019-09-01 22:24
 * @description: SemaphoreDemo练习  有减就有增 有增就有减  伸缩值
 * @program: testaop
 * @version: 1.0
 **/
public class SemaphoreDemo {


    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);//模拟五个车位

        for (int i = 1; i <= 9; i++) {//九辆车
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "抢到了");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + "三秒离开");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
