package com.demo.pattern.behavior.command;

/**
 * @author huaihai.guan
 * @since 2021/1/25 10:31
 */
public class Developer {

    private String name;

    Developer(String name) {
        this.name = name;
    }

    public void execute(Requirement requirement) {

        System.out.println(this.name + "开始做" + requirement.getName());
    }

    public void suspend(Requirement requirement) {

        System.out.println(this.name + "终止" + requirement.getName());
    }


}
