package com.van.video;

import lombok.var;

import javax.xml.crypto.Data;
import java.util.*;

/**
 * @author: Van
 * @create: 2019-11-02 14:03
 * @description: thread测试
 * @program: testaop
 * @version: 1.0
 **/
public class Aa {

    public void changeValue1(int age) {
        age = 30;
    }

    public void changeValue2(int age) {
        age = 30;
    }

    public void changeValue3(int age) {
        age = 30;
    }


    public static void main(String[] args) {
        Set set = new HashSet();
        Map<BB, Object> map = new HashMap<>();
        List list = new ArrayList(1000);
        System.out.println(Runtime.getRuntime().availableProcessors());//CPU核数
        long totalMemory = Runtime.getRuntime().totalMemory();//内存总量
        System.out.println("最小totalMemory：" + totalMemory / (double) 1024 / 1024);
        long maxMemory = Runtime.getRuntime().maxMemory();//最大内存
        System.out.println("最大maxMemory：" + maxMemory / (double) 1024 / 1024);
    }
}

class BB {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private BeautifulGirl beautifulGirl;

    public void setBeautifulGirl(BeautifulGirl beautifulGirl) {
        this.beautifulGirl = beautifulGirl;
    }

    BB(BeautifulGirl beautifulGirl) {
        this.beautifulGirl = beautifulGirl;
    }
}

class BeautifulGirl {

    public static void main(String[] args) {
        test();

    }

    public static int test() {
        int a = 3;
        int b = 3;
        try {
            int d = a + b;
            System.out.println(d);
            int r = 1 / 0;
            return d;
        } catch (IndexOutOfBoundsException e) {

            System.out.println("IndexOutOfBoundsException");
            e.printStackTrace();
        } catch (RuntimeException x) {
            System.out.println("RuntimeException");
            x.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception");
            e.printStackTrace();
        } finally {
            a = 4;
            System.out.println(a + "finally");
        }
        return 1;
    }
}