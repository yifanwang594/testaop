package com.van.video;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author: Van
 * @create: 2019-10-29 09:29
 * @description: 集合类不安全
 * @program: testaop
 * @version: 1.0
 **/
public class SafeList {

    private static Object String;

    public static void main(String[] args) {
        //List<String> list = new CopyOnWriteArrayList();//Arrays.asList("a", "b");

        Set<String> list = new CopyOnWriteArraySet<String>();
        list.add("");

        list.forEach(System.out::println);
    }
}


class aa implements Callable{
    @Override
    public Object call() throws Exception {
        return null;
    }
}
