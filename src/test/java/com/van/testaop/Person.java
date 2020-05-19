package com.van.testaop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

/**
 * @author: Van
 * @create: 2019-08-31 16:48
 * @description: 实体类
 * @program: testaop
 * @version: 1.0
 **/
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Person {
    private Integer id;
    private String personName;


    public Person(String personName) {
        this.personName = personName;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Person)) return false;
//
//        Person person = (Person) o;
//
//        if (!getId().equals(person.getId())) return false;
//        return getPersonName().equals(person.getPersonName());
//
//    }
//
//    @Override
//    public int hashCode() {
//        int result = getId().hashCode();
//        result = 31 * result + getPersonName().hashCode();
//        return result;
//    }

    public static void main(String[] args) throws InterruptedException {
//        Person person1 = new Person(1, "zs");
//        Person person2 = new Person(1, "zs");
//
//        User2 user2 = new User2();
//
//        Person p = new Person();
//        Person p2 = new Person();
//
//        p.setPersonName("aa");
//        p.setId(1);
//
//        p2.setPersonName("aa");
//        p2.setId(1);
//
//        System.out.println(p == p2);
//
//        System.out.println(person1.hashCode());
//        System.out.println(person2.hashCode());
//        System.out.println(person2.hashCode() == person1.hashCode());//t
//        System.out.println(person2 == person1);//f
//        System.out.println(person2.equals(person1));//t


        String A = "qqq";
        String B = "bbb";

        switch (A) {
            case "qqq":
                System.out.println("qqq");
                break;
            case "bbb":
                System.out.println("bbb");
                break;
        }


//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            String item = iterator.next();
//            if ("删除元素的条件") {
//                iterator.remove();
//            }
//        }


        Thread thread = new Thread();
        thread.join();

//        completablefuture
//        CompletableFuture

//        CompletableFuture
    }

}

@Data
class User2 {

    private int age;
    private String name;


}