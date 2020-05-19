package com.van.testaop;

import java.util.*;

/**
 * @author: Van
 * @create: 2020-03-29 20:44
 * @description: 反射练习
 * @program: testaop
 * @version: 1.0
 **/
public class Reflex {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        Map map = new HashMap();

        HashSet set = new HashSet();
        set.add("adadad");
        /*Class<Re> reClass = Re.class;
        System.out.println("壹Re.class;" + reClass);*/

        /*Re re = new Re();
        re.getClass();
        System.out.println("贰re.getClass();" + re.getClass());*/

        /*try {
            Class cf = Class.forName("com.van.testaop.Re");
            System.out.println("叁Class.forName" + cf);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/

        String s1 = new String("abc");
        String s2 = new String("abc");
        Re re = new Re();
        re.setName("qwe");
        Re re2 = new Re();
        re2.setName("qwe");
        if (re.equals(re2)) {
            System.out.println("re==re2");
        } else {
            System.out.println("re!=re2");
        }
    }
}

class Re {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

/*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Re re = (Re) o;
        return Objects.equals(name, re.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }*/

//    public static void imstatic() {
//        System.out.println("我是静态方法");
//    }
//
//    public void imnotstatic() {
//        System.out.println("我是普通方法");
//    }
//
//    static {
//        System.out.println("静态代码快");
//    }
//
//    {
//        System.out.println("普通方法");
//    }
}
