package com.van.testaop;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author: Van
 * @create: 2019-11-13 12:58
 * @description: JUC线程安全集合类
 * @program: testaop
 * @version: 1.0
 **/
public class NoSafeArrayList {


    public static void main(String[] args) {

        /*java.util.ConcurrentModificationException*/

        List<String> list = new CopyOnWriteArrayList<>();
//        List<String> list = new Vector<>();
        Set set = new CopyOnWriteArraySet();

//        List<String> list = new ArrayList<>();

//        List<String> list = Collections.synchronizedList(new ArrayList<>());

        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));

                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
