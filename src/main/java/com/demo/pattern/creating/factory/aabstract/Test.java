package com.demo.pattern.creating.factory.aabstract;

/**
 * @author huaihai.guan
 * @since 2021/1/22 11:26
 */
public class Test {

    public static void main(String[] args) {
        AbstractFactory carFactory = new CarFactory();
        carFactory.installWheels();
        carFactory.installBody();

        AbstractFactory motorFactory = new MotorFactory();
        motorFactory.installWheels();
        motorFactory.installBody();
    }
}
