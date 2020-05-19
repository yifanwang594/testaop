package com.van.testaop;

/**
 * @author: Van
 * @create: 2020-04-02 12:27
 * @description: 单例模式测试
 * @program: testaop
 * @version: 1.0
 **/
public class Singleton {
    private volatile static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
