package com.demo.pattern.structure.adapter;

/**
 * 直接实现目标方法的类
 * @author huaihai.guan
 * @since 2021/2/1 20:48
 */
public class BaseDriver implements Target {

    @Override
    public void work() {
        System.out.println("BaseDriver Work!");
    }
}
