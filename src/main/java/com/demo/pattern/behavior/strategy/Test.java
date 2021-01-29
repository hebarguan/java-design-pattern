package com.demo.pattern.behavior.strategy;

import com.demo.pattern.behavior.strategy.strategy.BigClothesWashingStrategy;

/**
 * @author huaihai.guan
 * @since 2021/1/26 17:26
 */
public class Test {

    public static void main(String[] args) {
        BigClothesWashingStrategy bigClothesWashingStrategy = new BigClothesWashingStrategy();
        WashingMachine washingMachine = new WashingMachine(bigClothesWashingStrategy);
        washingMachine.startWashingClothes();

        WashingStrategy washingStrategy = WashingStrategyFactory.getWashingStrategy("quick");
        washingMachine = new WashingMachine(washingStrategy);
        washingMachine.startWashingClothes();
    }
}
