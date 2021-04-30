package com.van.tester;

import java.util.Calendar;
import java.util.Optional;

/**
 * @author: Wang yifan
 * @create: 2021-03-13 20:25
 * @description: 基础问题
 * @program: testaop
 * @version: 1.0
 **/
public class BaseTest {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        System.out.println(calendar.get(Calendar.DATE));
    }
}
