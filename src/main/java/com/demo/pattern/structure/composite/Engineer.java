package com.demo.pattern.structure.composite;

/**
 * @author huaihai.guan
 * @since 2021/2/19 18:33
 */
public class Engineer extends Employee {

    public Engineer(String name) {
        super.setName(name);
    }

    @Override
    void display(int level) {
        String line = this.levelLine(level);
        System.out.println(line + super.getName());
    }
}
