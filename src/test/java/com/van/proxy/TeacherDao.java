package com.van.proxy;

/**
 * @author: Van
 * @create: 2020-04-10 14:15
 * @description: 被代理类
 * @program: testaop
 * @version: 1.0
 **/
public final class TeacherDao implements ITeacherDao {
    @Override
    public void teach() {
        System.out.println("老师教课~~~(代理类调用被代理类)");
    }

    @Override
    public void sayHello(String name) {
        System.out.println("nihao~~     " + name);
    }
}
