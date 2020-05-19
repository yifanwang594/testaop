package com.van.testaop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;


public enum CountEnum {
    ONE(1, "齐"),

    TWO(2, "楚"),

    THREE(3, "燕"),

    FOUR(4, "赵"),

    FIVE(5, "魏"),

    SIX(6, "韩");


    @Getter
    private Integer retCode;
    @Getter
    private String retMessage;

    CountEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    public static CountEnum forEach_CountryEnum(int index) {
        CountEnum[] values = CountEnum.values();
        for (CountEnum value : values) {
            if (index == value.getRetCode()) {
                return value;
            }
        }
        return null;
    }
}
