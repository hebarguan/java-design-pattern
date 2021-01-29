package com.demo.pattern.creating.factory.simple;

/**
 * @author huaihai.guan
 * @since 2021/1/21 18:46
 */
public class Car implements Garage {

    public void installWheels() {
        System.out.println("Car 安装轮子");
    }
}
