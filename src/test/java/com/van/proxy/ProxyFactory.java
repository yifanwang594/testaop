package com.van.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: Van
 * @create: 2020-04-10 14:17
 * @description: 代理对象
 * @program: testaop
 * @version: 1.0
 **/
public class ProxyFactory {
    //维护一个目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    //

    /**
     * @Author: Van
     * @Date: 2020/4/10
     * @Description: ClassLoader loader,指定当前被代理类使用的加载器
     * Class<?>[] interfaces,目标对象实现的接口类型使用泛型方法确认
     * InvocationHandler h,真正执行生生代理对象的方法；
     * 事情处理，执行目标对象的方法时，会触发事情处理器方法，会把当前执行的目标对象方法作为参数传入给目标对象生成代理对象
     * @Param: []
     * @return: java.lang.Object
     */
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("JDK代理开始了~~~");
                //反射机制调用目标对象的方法
                Object invoke = method.invoke(target, args);
                System.out.println("JDK代理提交了~~~");
                return invoke;
            }
        });
    }
}
