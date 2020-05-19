package com.van.testaop;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author: Van
 * @create: 2019-09-01 09:36
 * @description: CyclicBarrierDemo 加法 加到固定值再触发
 * @program: testaop
 * @version: 1.0
 **/
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("GoGoGoGoGoGoGoGoGoGo");
        });

        for (int i = 1; i <= 7; i++) {
            final int tempInt = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "=====收集到第：" + tempInt);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("走这里了");
                }
            }, String.valueOf(i)).start();

        }
    }
}
