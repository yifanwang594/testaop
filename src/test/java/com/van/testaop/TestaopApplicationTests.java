package com.van.testaop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestaopApplicationTests {

    @Test
    public void contextLoads() {
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
/**
 * @Author: Van
 * @Date: 2019/8/30
 * @Description: 资源类
 * @Param:
 * @return:
 */
class User {
    String username;
    int age;

    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);


    /**
     * @Author: Van
     * @Date: 2019/8/29
     * @Description:ABA问题
     * @Param: []
     * @return: void
     */
    private static void AtomicStampedReferenceABA() {
    /*//ABA 源自引用
    AtomicReference atomicReference = new AtomicReference();


    User z3 = new User("z3", 100);
    User l4 = new User("l4", 111);

    atomicReference.set(z3);
    System.out.println(atomicReference.compareAndSet(z3, l4) + "=====" + atomicReference.get().toString());
    System.out.println(atomicReference.compareAndSet(l4, z3) + "====" + atomicReference.get());
    System.out.println(atomicReference.compareAndSet(l4, z3) + "====" + atomicReference.get());*/


        new Thread(() -> {
            System.out.println("/*ABA问题产生*/");
//            int stamp = atomicStampedReference.getStamp();
//            System.out.println(Thread.currentThread().getName() + "版本号" + stamp);
//            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
//            atomicStampedReference.compareAndSet(100,101,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println(atomicReference.compareAndSet(100, 101) + "==t1==" + atomicReference.get());
            System.out.println(atomicReference.compareAndSet(101, 100) + "==t1==" + atomicReference.get());
        }, "t1").start();

        new Thread(() -> {
//            int stamp = atomicStampedReference.getStamp();
//            System.out.println(Thread.currentThread().getName() + "版本号" + stamp);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet(100, 2019) + "==t2==" + atomicReference.get());
        }, "t2").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("/*ABA问题解决*/");

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "==第一版本号" + stamp);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(100, 101, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "2==版本号" + atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "3==版本号" + atomicStampedReference.getStamp());
        }, "t3").start();
////
        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "==第一版本号" + stamp);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean b = atomicStampedReference.compareAndSet(100, 2019, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
//            boolean b = atomicStampedReference.compareAndSet(100, 2019, stamp, atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "==修改成功否 " + b + "==当前版本号" + atomicStampedReference.getStamp());
            System.out.println(Thread.currentThread().getName() + "==最新值" + atomicStampedReference.getReference());
        }, "t4").start();
    }

    /**
     * @Author: Van
     * @Date: 2019/8/29
     * @Description:集合不安全并发修改异常
     * @Param: []
     * @return: void
     */
    private static void ContainerNotSafeDemo() {
//        List<String> list = Arrays.asList("a", "b", "c");
//        list.forEach(System.out::println);

//        List<String> list = new ArrayList<>();
//        List<String> list = new Vector<>();
        List<String> list = new CopyOnWriteArrayList<>();
        Set set = new HashSet();
//        list.add("a");
//        list.add("b");
//        list.add("c");
        for (int i = 1; i < 10; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }

    AtomicReference<Thread> atomicReferenceThread = new AtomicReference<>();

    /**
     * @Author: Van
     * @Date: 2019/8/30
     * @Description: 自旋锁
     * @Param: []
     * @return: void
     */
    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "进来");
        while (!atomicReferenceThread.compareAndSet(null, thread)) {

        }
    }

    /**
     * @Author: Van
     * @Date: 2019/8/30
     * @Description: 自旋锁
     * @Param: []
     * @return: void
     */
    public void myUnlock() {
        Thread thread = Thread.currentThread();
        atomicReferenceThread.compareAndSet(thread, null);
        System.out.println(Thread.currentThread().getName() + "走myUnlock");
    }

    /**
     * @Author: Van
     * @Date: 2019/8/30
     * @Description: 自旋锁验证
     * @Param: []
     * @return: void
     */
    private static void Spin() {
        User user = new User();
        new Thread(() -> {
            user.myLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            user.myUnlock();
        }, "AA").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            user.myLock();
            user.myUnlock();
        }, "BB").start();
    }

    public static void main(String[] args) {
    }


}