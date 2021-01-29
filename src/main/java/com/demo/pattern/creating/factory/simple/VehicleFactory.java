package com.demo.pattern.creating.factory.simple;

/**
 * 简单工厂
 * @author huaihai.guan
 * @since 2021/1/21 18:42
 */
public class VehicleFactory {

    public static Garage makeVehicle(String name) {
        if (name.equals("car")) {
            return new Car();
        } else {
            return new Motor();
        }
    }
}
