package com.van.java8;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.Optional;

/**
 * @author: Van
 * @create: 2021-04-07 22:34
 * @description: Optional测试类
 * @program: testaop
 * @version: 1.0
 **/
public class OptionalTest {

    /*
     * Optional.of(T t)  创建一个Optional实例t必须非空
     * Optional.empty() 创建一个空的Optional实例
     * Optional.ofNullable(T t) t可以为null
     *
     */

    @Test
    public void test1() {
        WoMan woMan = new WoMan();
        woMan = null;//就会报错空指针
        //Optional.of(T t) 保证t是非空的
        Optional<WoMan> optionalWoMan = Optional.of(woMan);
    }

    @Test
    public void test2() {
        WoMan woMan = new WoMan();
//        woMan = null;
        //ofNullable(T value) t可以为null
        Optional<WoMan> optionalWoMan = Optional.ofNullable(woMan);
        //orElse(T t)如果当前Optional内部封装的t非空则返回内部的t，
        // 如果内部的t是空的则返回orElse()方法中的参数
        WoMan zs = optionalWoMan.orElse(new WoMan("张三"));
        System.out.println(optionalWoMan);
        System.out.println(zs);
    }

    public String getWoManName(Man man) {
        return man.getWoMan().getName();
    }

    @Test
    public void test3() {
        Man man = new Man();
        man = null;
        String woManName = getWoManName(man);
        System.out.println(woManName);
    }

    //优化NullPointerException空指针问题
    public String getWoManName1(Man man) {
        if (man != null) {
            WoMan woMan = man.getWoMan();
            if (woMan != null)
                return woMan.getName();
        }
        return null;
    }

    @Test
    public void test4() {
        Man man = new Man();
        man = null;
        String woManName = getWoManName1(man);
        System.out.println(woManName);
    }

    //使用Optional优化NullPointerException空指针问题
    public String getWoManName2(Man man) {
        Optional<Man> optionalMan = Optional.ofNullable(man);
        Man man1 = optionalMan.orElse(new Man(new WoMan("lisi")));
        WoMan woMan = man1.getWoMan();
        Optional<WoMan> optionalWoMan = Optional.ofNullable(woMan);
        WoMan woMan1 = optionalWoMan.orElse(new WoMan("可爱酱"));
        return woMan1.getName();
    }

    @Test
    public void test5() {
        Man man = new Man();
        man = null;
        man = new Man(new WoMan("潇洒君"));
        String woManName2 = getWoManName2(man);
        System.out.println(woManName2);
    }
}
