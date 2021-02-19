package com.demo.pattern.structure.decorator;

/**
 * @author huaihai.guan
 * @since 2021/2/19 19:48
 */
public class BaseRoom extends BookRoom {

    @Override
    void book() {
        System.out.println("标准房299元/晚");
    }
}
