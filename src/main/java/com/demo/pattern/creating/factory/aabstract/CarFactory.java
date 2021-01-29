package com.demo.pattern.creating.factory.aabstract;

/**
 * @author huaihai.guan
 * @since 2021/1/22 10:52
 */
public class CarFactory implements AbstractFactory {

    @Override
    public void installWheels() {
        new BWMFactory().createWheels();
    }

    @Override
    public void installBody() {
        new BWMFactory().createBody();
    }
}
