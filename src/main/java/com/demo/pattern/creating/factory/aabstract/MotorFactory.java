package com.demo.pattern.creating.factory.aabstract;

/**
 * @author huaihai.guan
 * @since 2021/1/22 10:53
 */
public class MotorFactory implements AbstractFactory {

    @Override
    public void installWheels() {
        new DaYunFactory().createWheels();
    }

    @Override
    public void installBody() {
        new DaYunFactory().createBody();
    }
}
