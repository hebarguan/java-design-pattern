package com.demo.pattern.creating.factory.method;

import com.demo.pattern.creating.factory.simple.Car;

/**
 * @author huaihai.guan
 * @since 2021/1/21 19:56
 */
public class CarFactory extends AbstractFactory {

    @Override
    public void makeVehicle() {
        new Car().installWheels();
    }
}
