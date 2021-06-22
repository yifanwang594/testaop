package com.van.java8;

import lombok.*;

/**
 * @author: Van
 * @create: 2021-04-07 22:39
 * @description: 女人
 * @program: testaop
 * @version: 1.0
 **/
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WoMan {
    private String name;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "WoMan{" +
                "name='" + name + '\'' +
                '}';
    }
}
