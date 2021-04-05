package com.van.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Van
 * @create: 2021-04-05 15:59
 * @description: 测试数据的集合
 * @program: testaop
 * @version: 1.0
 **/
public class TestData {

    public static List<Emp> getEmp() {
        List<Emp> list = new ArrayList<>();
        list.add(new Emp(1001, "一号1", 10));
        list.add(new Emp(1002, "二号1", 20));
        list.add(new Emp(1003, "三号1", 30));
        list.add(new Emp(1004, "四号", 40));
        list.add(new Emp(1005, "五号", 50));

        return list;
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
class Emp {
    private Integer id;
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}