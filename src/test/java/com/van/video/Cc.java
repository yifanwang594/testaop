package com.van.video;


import java.util.Date;
import java.util.concurrent.TimeUnit;

class Number {

    volatile int number = 10;

    public void add() {
        this.number = 5000;
    }
}


/**
 * @author: Van
 * @create: 2019-11-06 09:56
 * @description:
 * @program: testaop
 * @version: 1.0
 **/
public class Cc {


    public static void main(String[] args) {
        /*Number number = new Number();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "进来了");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            number.add();
            System.out.println("已经修改" + number.number);
        }, "AAA").start();

        while (number.number == 10) {
//            System.out.println("main修改");
        }

        System.out.println("修改完毕");*/


        Date date = new Date();
        Date date1 = new Date();
        System.out.println(date==date1);
        int a = 666;
        int b = 666;
        Integer q = 222;
        Integer w = 222;
        String z = new String("abc");
        String x = new String("abc");

        System.out.println(a == b);
        System.out.println(q.equals(w) && q == w);
        System.out.println(q == w);
        System.out.println(z == x);


    }
}
