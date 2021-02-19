package com.demo.pattern.structure.composite;

/**
 * @author huaihai.guan
 * @since 2021/2/19 18:28
 */
public abstract class Employee {

    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected String levelLine(int level) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < level; i++) {
            line.append("----");
        }
        return line.toString();
    }

    abstract void display(int level);
}
