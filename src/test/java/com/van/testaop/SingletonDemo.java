package com.van.testaop;

/**
 * @author: Van
 * @create: 2019-09-02 11:25
 * @description: "单例模式"案例
 * @program: testaop
 * @version: 1.0
 **/
public class SingletonDemo {


    private static volatile SingletonDemo singleton = null;

    private SingletonDemo() {
        System.out.println(Thread.currentThread().getName() + "==" + "我是构造方法");
    }

    /**
     * @Author: Van
     * @Date: 2019/9/2
     * @Description: 多线程下线程安全的单例模式（双端检索机制）
     * @Param: []
     * @return: com.van.testaop.SingletonDemo
     */
    private static SingletonDemo genSingleton() {
        if (singleton == null) {
            synchronized (SingletonDemo.class) {
                if (singleton == null) {
                    singleton = new SingletonDemo();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                SingletonDemo.genSingleton();
            }, String.valueOf(i)).start();
        }
    }

}
