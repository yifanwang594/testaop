package com.van.testaop;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class ShareResource {

    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print51() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void print5() {
        lock.lock();
        try {
            //判断
            while (number != 1) {
                c1.await();
            }
            //运行
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "=====" + i);
            }
            //通知
            number = 2;
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            //判断
            while (number != 2) {
                c2.await();
            }
            //运行
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "=====" + i);
            }
            //通知
            number = 3;
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try {
            //判断
            while (number != 3) {
                c3.await();
            }
            //运行
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "=====" + i);
            }
            //通知
            number = 1;
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}


/**
 * @author: Van
 * @create: 2019-09-01 23:14
 * @description: Sync和Lock的区别
 * @program: testaop
 * @version: 1.0
 **/
public class SyncAndLockDifference {

    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareResource.print5();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareResource.print10();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareResource.print15();
            }
        }, "C").start();
    }
}


