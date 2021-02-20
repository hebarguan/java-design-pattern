package com.demo.pattern.structure.facade;

/**
 * @author huaihai.guan
 * @since 2021/2/20 10:26
 */
public class Facade {

    private Leader leader;

    public void develop(String name) {
        Leader leader = new Leader();
        leader.develop(name);
    }
}
