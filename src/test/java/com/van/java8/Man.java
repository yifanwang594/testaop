package com.van.java8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author: Van
 * @create: 2021-04-07 22:39
 * @description: 男人
 * @program: testaop
 * @version: 1.0
 **/
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Man {
    private WoMan woMan;

    public WoMan getWoMan() {
        return woMan;
    }

    public void setWoMan(WoMan woMan) {
        this.woMan = woMan;
    }
}
