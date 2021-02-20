package com.demo.pattern.structure.facade;

/**
 * @author huaihai.guan
 * @since 2021/2/20 10:27
 */
public class Tester {

    private String name;

    public Tester(String name) {
        this.name = name;
    }

    public void startTest() {

        System.out.println("测试需求" + this.name);
    }
}
