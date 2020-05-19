package com.van.testaop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author: Van
 * @create: 2019-08-31 19:53
 * @description: CountDownLatchDemo练习 减法 减到固定值再触发  线程安全集合
 * @program: testaop
 * @version: 1.0
 **/
public class CountDownLatchDemo {


    public static void main(String[] args) throws Exception {

        CountDownLatch countDownLatch = new CountDownLatch(6);
        List<String> collections = Collections.synchronizedList(new ArrayList<>());
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "=====先撤退");
                //解决方法
                countDownLatch.countDown();
            }, CountEnum.forEach_CountryEnum(i).getRetMessage()).start();
        }
        //解决方法
        countDownLatch.await();
//        countDownLatch.await(3000, TimeUnit.MILLISECONDS);
        System.out.println(Thread.currentThread().getName() + "=====最后撤退");
    }
}
