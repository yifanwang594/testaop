package com.van.proxy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: Van
 * @create: 2020-04-10 14:36
 * @description: 动态代理测试类
 * @program: testaop
 * @version: 1.0
 **/
public class client {
    public static void main(String[] args) {
        List l = new ArrayList();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(100);
        //创建被代理类
        ITeacherDao teacherDao = new TeacherDao();
        //给目标对象创建代理对象
        ITeacherDao proxyInstance = (ITeacherDao) new ProxyFactory(teacherDao).getProxyInstance();
        //proxyInstance=class com.sun.proxy.$Proxy0内存中动态生成的代理对象
        //System.out.println("proxyInstance=" + proxyInstance.getClass());
        //通过代理对象调用被代理类的方法
        // proxyInstance.teach();
        proxyInstance.sayHello("tom");
    }
}
