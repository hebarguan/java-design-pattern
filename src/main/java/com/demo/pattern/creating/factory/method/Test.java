package com.demo.pattern.creating.factory.method;

/**
 * 工厂方法
 * @author huaihai.guan
 * @since 2021/1/21 20:14
 */
public class Test {

    public static void main(String[] args) {
        AbstractFactory carFactory = new CarFactory();
        carFactory.makeVehicle();
        AbstractFactory motorFactory = new MotorFactory();
        motorFactory.makeVehicle();
    }

}
