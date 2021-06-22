package com.van.stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: Van
 * @create: 2021-04-05 23:02
 * @description: StreamAPITest终止的操作
 * @program: testaop
 * @version: 1.0
 **/
public class StreamAPITest2 {

    //匹配与查找
    @Test
    public void test1() {
        //allMatch(Predicate<? super T> predicate); 检查是否匹配所有元素
        List<Emp> emp = TestData.getEmp();
        boolean allMatch = emp.stream().allMatch(e -> e.getAge() > 1);
//        System.out.println(allMatch);

        //检查是否至少匹配一个元素
        boolean anyMatch = emp.stream().anyMatch(e -> e.getId() > 10);
//        System.out.println(anyMatch);
        //检查是否没有匹配的元素
        boolean noneMatch = emp.stream().noneMatch(e -> e.getName().startsWith("哦哦"));
        //findFirst()返回第一个元素
        Optional<Emp> first = emp.stream().findFirst();
        //findAny()返回当前流总任意元素
        Optional<Emp> any = emp.stream().findAny();
        //count返回流中元素的总个数
        long count = emp.stream().count();
        long count1 = emp.stream().filter(e -> e.getId() > 1).count();
        //max(Comparator<? super T> comparator);返回流中的最大值
        Optional<Integer> max = emp.stream().map(e -> e.getId()).max((e1, e2) ->
                Integer.compare(e1, e2)
        );
        System.out.println("lambdaλ" + max);
        Stream<Integer> integerStream = emp.stream().map(e -> e.getId());
        Optional<Integer> max1 = integerStream.max(Integer::compareTo);
        System.out.println("方法引用" + max1);
//        Optional<Emp> max1 = emp.stream().filter(e -> e.getId() > 1).max((o1, o2) -> {
//            return 1;
//        });

        //min返回流中的最小值
        Optional<Emp> minAge = emp.stream().min((a1, a2) -> Integer.compare(a1.getAge(), a2.getAge()));
        System.out.println("minAge" + minAge);
        //forEach 内部迭代
        emp.stream().forEach(System.out::println);
    }


    //规约
    @Test
    public void test2() {
        /*reduce(T identity, BinaryOperator<T> accumulator);
        可以将流中的元素反复结合起来 得到一个值 返回 T*/
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().reduce(0, Integer::compareTo);
        System.out.println(reduce);

        /*reduce(BinaryOperator<T> accumulator);
         * 可以将流中的元素反复结合起来得到一个值 返回Optional
         * */
        List<Emp> emp = TestData.getEmp();
        Stream<Integer> ageStream = emp.stream().map(Emp::getAge);
        Optional<Integer> sunAge = ageStream.reduce(Integer::sum);//方法引用
        Optional<Integer> sunAge1 = ageStream.reduce((a1, a2) -> a1 + a2);//lambda写法
        System.out.println(sunAge);
    }

    //收集
    @Test
    public void test3() {
        //collect(Collector c) 将流转换成为其他形式 接收一个collector接口实现 用于给stream中元素做汇总的方法
        List<Emp> emp = TestData.getEmp();
        List<Emp> collect = emp.stream().filter(e -> e.getAge() > 5).collect(Collectors.toList());
        collect.forEach(System.out::println);

        Set<Emp> empSet = emp.stream().filter(e -> e.getAge() > 5).collect(Collectors.toSet());
        empSet.forEach(System.out::println);


    }
}
