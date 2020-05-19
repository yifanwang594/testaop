package com.van.testaop;

import java.math.BigDecimal;

/**
 * @author: Van
 * @create: 2019-10-09 19:51
 * @description: 添加
 * @program: testaop
 * @version: 1.0
 **/
public class Add {


    public static void main(String[] args) {
        Add add = new Add();
        add.AAdd();
    }


    private void AAdd() {
        BigDecimal zero = BigDecimal.ZERO;

        BigDecimal bigDecimal = new BigDecimal(900);
        zero = zero.add(bigDecimal);
        System.out.println(zero);

    }
}
