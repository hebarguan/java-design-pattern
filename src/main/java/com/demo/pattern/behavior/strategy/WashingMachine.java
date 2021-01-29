package com.demo.pattern.behavior.strategy;

/**
 * @author huaihai.guan
 * @since 2021/1/26 17:21
 */
public class WashingMachine {

    public WashingStrategy washingStrategy;

    public WashingMachine(WashingStrategy washingStrategy) {
        this.washingStrategy = washingStrategy;
    }

    public void startWashingClothes() {
        this.washingStrategy.washing();
    }

}
