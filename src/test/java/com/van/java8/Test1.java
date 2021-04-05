package com.van.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

/**
 * @author: Van
 * @create: 2021-04-03 22:50
 * @description: lambda测试
 * @program: testaop
 * @version: 1.0
 **/

public class Test1 {

    //lambda格式一
    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable运行一波");
            }
        };
        runnable.run();
        System.out.println("lambda写法 ↓");
        Runnable runnable1 = () -> {
            System.out.println("runnable运行一波λ");
        };
        runnable1.run();
        System.out.println(runnable1);
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int compare1 = comparator.compare(1, 2);
        System.out.println(compare1);
        System.out.println("lambda写法 ↓");
        Comparator<Integer> comparator1 = (o1, o2) -> Integer.compare(o1, o2);
        int compare = comparator1.compare(1, 2);
        System.out.println(compare);

    }

    /**
     * @Author: Van
     * @Date: 2021/4/4
     * @Description: lamdba 第二种格式 需要一个参数，但是没有返回值
     * @Param: []
     * @return: void
     */
    @Test
    public void test2() {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("lambda第二种写法");

        Consumer<String> consumer1 = (String s) -> {
            System.out.println(s);
        };
        consumer1.accept("lambda第二种写法λ");
    }

    //格式三 数据类型可以省略 可由编译器推断得出 称为类型推断
    @Test
    public void test3() {

        Consumer<String> consumer1 = (String s) -> {
            System.out.println(s);
        };
        consumer1.accept("lambda第二种写法λ");
        Consumer<String> consumer2 = (s) -> {
            System.out.println(s);
        };
        consumer2.accept("lambda第二种写法λ");
    }

    //格式四 lambda若只需要一个参数时 参数的小括号可以省略
    @Test
    public void test4() {
        Consumer<String> consumer2 = (s) -> {
            System.out.println(s);
        };
        consumer2.accept("lambda第二种写法λ");
        Consumer<String> consumer3 = s -> {
            System.out.println(s);
        };
        consumer3.accept("lambda第二种写法λ");

    }

    //格式五 lambda需要两个或以上的参数 多条执行语句 有返回值
    @Test
    public void test5() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println("==============");
        Comparator<Integer> comparator1 = (o1, o2) -> {
            return o1.compareTo(o2);
        };
    }

    //格式六 lambda只有一条语句时 return与大括号若有都可以省略
    @Test
    public void test6() {

        Comparator<Integer> comparator1 = (o1, o2) -> {
            return o1.compareTo(o2);
        };
        System.out.println(comparator1.compare(100, 10));
        System.out.println("==============");

        Comparator<Integer> comparator2 = (o1, o2) -> o1.compareTo(o2);

        System.out.println(comparator2.compare(100, 10));
    }

}

class Test2 {
    //方法引用
    @Test
    public void test() {
        Comparator<Integer> comparator = (t1, t2) -> Integer.compare(t1, t2);
        System.out.println(comparator.compare(11, 1));

        System.out.println("分割线——————————");
        Comparator<Integer> comparator1 = Integer::compare;


    }

    @Test
    public void test1() {
        Comparator<String> comparator = (s1, s2) -> s1.compareTo(s2);
        System.out.println(comparator.compare("abc", "bcd"));

        System.out.println("分割线——————————");
        Comparator<String> comparator1 = String::compareTo;
    }

    @Test
    public void test2() {
        BiPredicate<String, String> predicate = (s1, s2) -> s1.equals(s2);
        System.out.println(predicate.test("aaa", "acx"));
    }
}