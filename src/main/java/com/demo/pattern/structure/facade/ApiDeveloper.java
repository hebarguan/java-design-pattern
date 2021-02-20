package com.demo.pattern.structure.facade;

/**
 * @author huaihai.guan
 * @since 2021/2/20 10:21
 */
public class ApiDeveloper {

    private String name;

    public ApiDeveloper(String name) {
        this.name = name;
    }

    public void work() {

        System.out.println("后台开始开发需求" + name);
    }
}
