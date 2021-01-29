package com.demo.pattern.creating.factory.simple;

/**
 * @author huaihai.guan
 * @since 2021/1/21 19:02
 */
public class Test {

    public static void main(String[] args) {
        Garage vehicle = VehicleFactory.makeVehicle("car");
        vehicle.installWheels();
    }
}
