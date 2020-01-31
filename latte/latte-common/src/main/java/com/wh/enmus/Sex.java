package com.wh.enmus;

/**
 * @program: latte
 * @description:
 * @author: wh
 * @create: 2020-01-14 19:29
 */
public enum Sex {
    /**
     *
     */
    woman(0,"女"),
    /**
     *
     */
    man(1,"男"),
    /**
     *
     */
    secret(2,"保密");

    public final Integer type;
    public final String value;

    Sex(Integer type, String value) {
        this.type = type;
        this.value = value;
    }


}