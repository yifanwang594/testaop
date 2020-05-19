package com.van.testaop;

import javax.sound.midi.Soundbank;

/**
 * @author: Van
 * @create: 2019-08-31 16:46
 * @description: Reference测试
 * @program: testaop
 * @version: 1.0
 **/
public class TestReference {

    public void changeValue1(int age) {
        age = 30;
    }

    public void changeValue2(Person person) {
        person.setPersonName("xxx");
    }

    public void changeValue3(String str) {
        str = "xxx";
    }

    public static void main(String[] args) {
        TestReference testReference = new TestReference();
        int age = 20;
        testReference.changeValue1(age);
        System.out.println("age=====" + age);

        Person person = new Person("abc");
        testReference.changeValue2(person);
        System.out.println("persoName=====" + person.getPersonName());

        String str = "abc";
        testReference.changeValue3(str);
        System.out.println("String=====" + str);
//        new A().
    }
}
