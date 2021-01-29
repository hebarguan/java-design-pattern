package com.demo.pattern.behavior.mediator;

/**
 * @author huaihai.guan
 * @since 2021/1/21 18:04
 */
public class Test {

    public static void main(String[] args) {
        LandlordMediator mediator = new LandlordMediator("name");
        mediator.lookHouse();
    }
}
