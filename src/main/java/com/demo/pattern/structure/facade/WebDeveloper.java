package com.demo.pattern.structure.facade;

/**
 * @author huaihai.guan
 * @since 2021/2/20 10:23
 */
public class WebDeveloper {

    private String name;

    public WebDeveloper(String name) {
        this.name = name;
    }

    public void work() {

        System.out.println("前端开发需求" + this.name);
    }
}
