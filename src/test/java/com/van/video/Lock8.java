package com.van.video;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Phone {


    /*List list = new ArrayList(20);


    public static void main(String[] args) {
        ExecutorService threadpool = Executors.newFixedThreadPool(2);
        threadpool.execute(() -> {

        });
    }*/
    private int id;
    private String name;
    private int age;


    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(o.getClass().getClassLoader());
        Phone phone = new Phone();
        System.out.println(phone.getClass().getClassLoader().getParent().getParent());
    }


}

/**
 * @author: Van
 * @create: 2019-10-28 21:07
 * @description: 八种锁的测试
 * @program: testaop
 * @version: 1.0
 **/
public class Lock8 {

    public static void main(String[] args) {
        Phone p1 = new Phone(1, "a", 12);
        Phone p2 = new Phone(2, "a", 34);
        Phone p3 = new Phone(3, "a", 61);
        Phone p4 = new Phone(4, "a", 67);
        Phone p5 = new Phone(5, "a", 96);

        List<Phone> list = Arrays.asList(p1, p2, p3, p4, p5);
//        System.out.println(list);
        list.stream().filter(phone -> {
            return phone.getId() % 2 == 0;
        }).filter(phone -> {
            return phone.getAge() > 1;
        }).forEach(System.out::println);

        /*list.stream()
                .filter(phone -> phone.getId() % 2 == 0)
                .filter(phone -> phone.getAge() > 1)
                .forEach(System.out::println);*/
    }


    public Phone aa() {
        Phone phone = new Phone();

        return phone;

    }



}
