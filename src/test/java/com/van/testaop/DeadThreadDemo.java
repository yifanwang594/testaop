package com.van.testaop;


import java.util.concurrent.TimeUnit;

class HoldLock implements Runnable {

    private String lockA;
    private String lockB;

    public HoldLock(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "=====自己持有" + lockA + "=====尝试获得" + lockB);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "=====自己持有" + lockB + "=====尝试获得" + lockA);
            }
        }


    }
}

/**
 * @author: Van
 * @create: 2019-09-03 16:04
 * @description: 死锁练习
 * @program: testaop
 * @version: 1.0
 **/
public class DeadThreadDemo {


    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new HoldLock(lockA, lockB), "ThreadA").start();
        new Thread(new HoldLock(lockB, lockA), "ThreadB").start();
        /*
         * 查看死锁命令
         * jps -l 定位进程号
         *jstack (线程号) 找到死锁并查看
         * */

    }
}
