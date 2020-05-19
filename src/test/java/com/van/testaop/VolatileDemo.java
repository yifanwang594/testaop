package com.van.testaop;


import java.util.concurrent.atomic.AtomicInteger;

class MyDate {
    volatile int number = 0;

    public void addT060() {
        this.number = 60;
    }

    public void addPlusPlus() {
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();

    public void atomicIntegerPlusPlus() {
        atomicInteger.getAndIncrement();
    }
}

/**
 * @author: Van
 * @create: 2020-04-09 13:32
 * @description: volatile案例
 * @program: testaop
 * @version: 1.0
 **/
public class VolatileDemo {
    public static void main(String[] args) {
        MyDate myDate = new MyDate();
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    myDate.addPlusPlus();
                    myDate.atomicIntegerPlusPlus();
                }
            }, String.valueOf(i)).start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\tnumber\t" + myDate.number);
        System.out.println(Thread.currentThread().getName() + "\tatomicInteger\t" + myDate.atomicInteger);
    }
}
