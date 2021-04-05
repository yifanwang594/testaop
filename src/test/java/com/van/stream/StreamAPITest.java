package com.van.stream;

import com.van.proxy.T;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author: Van
 * @create: 2021-04-05 16:05
 * @description: StreamAPI测试
 * @program: testaop
 * @version: 1.0
 **/
public class StreamAPITest {

    //创建Stream方式一 通过集合
    @Test
    public void test1() {
        List<Emp> emp = TestData.getEmp();

        //default Stream<E> stream() : 返回一个顺序流
        Stream<Emp> stream = emp.stream();

        //default Stream<E> parallelStream() : 返回一个并行流
        Stream<Emp> empStream = emp.parallelStream();
    }

    //创建Stream方式二 通过数组
    @Test
    public void test2() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        //调用Arrays类的static <T> Stream<T> stream(T[] array) : 返回一个流
        IntStream stream = Arrays.stream(arr);

        //通过Stream的泛型来控制
        Emp emp1 = new Emp(1, "哈哈", 10);
        Emp emp2 = new Emp(2, "嘻嘻", 20);
        Emp emp[] = new Emp[]{emp1, emp2};
        Stream<Emp> stream1 = Arrays.stream(emp);
    }

    //创建Stream方式三 通过Stream的of()
    @Test
    public void test3() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);
    }

    //创建Stream方式四 通过无限流
    @Test
    public void test4() {
    /*迭代
    public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
    */
        //遍历前几个偶数
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);//方法引用的写法
        //匿名方法写法
        Stream.iterate(0, t -> t + 2).limit(10).forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("匿名方法写法" + integer);
            }
        });
        Stream.iterate(0, t -> t + 2).limit(10).forEach(s -> System.out.println("lambda写法λ" + s));//lambda写法λ


    /*生成
    public static<T> Stream<T> generate(Supplier<T> s)
    */
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

}
