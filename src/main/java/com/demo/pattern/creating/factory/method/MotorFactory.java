package com.demo.pattern.creating.factory.method;

import com.demo.pattern.creating.factory.simple.Motor;

/**
 * @author huaihai.guan
 * @since 2021/1/21 19:57
 */
public class MotorFactory extends AbstractFactory {

    @Override
    public void makeVehicle() {
        new Motor().installWheels();
    }
}
