package com.van.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author: Van
 * @create: 2021-04-05 18:25
 * @description: StreamAPITest测试
 * @program: testaop
 * @version: 1.0
 **/
public class StreamAPITest1 {

    //1 筛选与切片
    @Test
    public void test1() {
        List<Emp> list = TestData.getEmp();
        //filter(Predicate p)接口lambda  从流中排除过滤的元素
        Stream<Emp> stream = list.stream();
        stream.filter((e) -> e.getAge() >= 10).forEach(System.out::println);

        //limit(n) 截断流 使元素不超过给定数量
        list.stream().limit(2).forEach(System.out::println);
        //skip(n) 跳过元素 返回一个扔掉前n个元素的流 若流中元素不足n个则返回一个空流与limit互补
        list.stream().skip(2).forEach(System.out::println);
        //distinct()筛选 通过流所生成元素的hashcode和equals去除重复元素
        list.add(new Emp(1, "张三", 20));
        list.add(new Emp(1, "张三", 20));
        list.add(new Emp(1, "张三", 20));
        list.add(new Emp(1, "张三", 20));

        list.stream().distinct().forEach(System.out::println);
    }

    //2 映射
    @Test
    public void test2() {
        /*
         * map(Function f)   接收一个函数作为参数 将元素转换成其他形式或提取信息 该函数会被应用到每个元素上 并将其映射成一个新的元素
         * faltMap(Function f)  接收一个函数作为参数 将流中的每个值都换成另一个 然后把所有流连成一个流
         * */
        List<String> list = Arrays.asList("aa", "zz", "qq");
        list.stream().map(s -> s.toUpperCase()).forEach(System.out::println);

        //练习1 获取姓名长度大于3得名字
        List<Emp> emp = TestData.getEmp();
        emp.stream().map(e -> e.getName());
        Stream<String> stringStream = emp.stream().map(Emp::getName);
        stringStream.filter(name -> name.length() > 2).forEach(System.out::println);

        //练习2
        list.stream().map(StreamAPITest1::formSringToStrem);
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest1::formSringToStrem);
        streamStream.forEach(s -> {
            s.forEach(System.out::println);
        });
        Stream<Character> characterStream = list.stream().flatMap(StreamAPITest1::formSringToStrem);
        characterStream.forEach(System.out::println);
    }

    //2 将字符串中的多个字符构成的集合转换成为对应的stream实例
    public static Stream<Character> formSringToStrem(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (Character character : str.toCharArray()) {
            list.add(character);
        }
        return list.stream();
    }


    //2 映射
    @Test
    public void test3() {
        /*
         * map(Function f)   接收一个函数作为参数 将元素转换成其他形式或提取信息 该函数会被应用到每个元素上 并将其映射成一个新的元素
         * faltMap(Function f)  接收一个函数作为参数 将流中的每个值都换成另一个 然后把所有流连成一个流
         * */
        ArrayList list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);


        ArrayList list2 = new ArrayList();
        list2.add(4);
        list2.add(5);
        list2.add(6);
//        list1.add(list2);
        list1.addAll(list2);
        System.out.println(list1);

    }


    //3 排序
    @Test
    public void test4() {
        //sorted 自然排序
        List<Integer> list = Arrays.asList(12, 43, 54, 123, 65, 0, 56, -11);
        list.stream().sorted().forEach(System.out::println);
        //sorted(Comparator com) 定制排序

        List<Emp> emp = TestData.getEmp();
        emp.stream().sorted((e1, e2) -> {
            int compare = Integer.compare(e1.getAge(), e2.getAge());
            if (compare != 0) {
                return compare;
            } else {
                //逻辑
                return 1;
            }
        }).forEach(System.out::println);

    }
}
