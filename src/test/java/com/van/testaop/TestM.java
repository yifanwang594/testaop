package com.van.testaop;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author: Van
 * @create: 2019-09-05 07:56
 * @description:
 * @program: testaop
 * @version: 1.0
 **/
public class TestM implements Runnable {

    public final static ThreadLocal<String> RESOURCE = new ThreadLocal<String>();

    public static void main(String[] args) throws InterruptedException {
//        new Thread(new TestM()).start();
//        for (int i = 1; i < 10; i++) {
//            new Thread(() -> {
                RESOURCE.set("aaa");
//                System.out.println("===");
//            }).start();
//        }
//        for (int i = 0; i < 10; i++) {
        Thread.sleep(1);
//        new Thread(() -> {
            System.out.println(RESOURCE.get());
//        }).start();

//        }
        System.getProperty("sun.arch.data.model");


//        String s1 = "llopp";
//        String s2 = "llo";
//        s2.isEmpty()
//        String s3 = s2 + "pp";
//        String s4 = new String("llopp");
//        System.out.println(s1 == s4.intern());

//        String s1 = "abc";
//        String s2 = new String("abc");
//        s1 = "hello";

//        StringBuffer

//        String s3 = "abc";
//        s3 += "def";
//        System.out.println(s3);
//        System.out.println(s3.equals(s2));
//        System.out.println(s3 == s2);


//        System.out.println(++i);
//        System.out.println(i++);
//        System.out.println(i);


//        Array a = new Array();
//        Runtime


//        new A().protectedMethod();


    }

    public void run(String name) {
        System.out.println(Thread.currentThread().getName() + "bbbbbb>>>>>>>>>>>>>");
    }


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "aaaaaaaaaaaaaa>>>>>>>>>>>>>");
    }


}


abstract class A {

    public void publicMethod() {
    }

    protected void protectedMethod() {
    }

    public void privateMethod() {
    }

}