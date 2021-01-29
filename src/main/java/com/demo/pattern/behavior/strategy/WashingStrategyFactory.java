package com.demo.pattern.behavior.strategy;

import com.demo.pattern.behavior.strategy.strategy.BigClothesWashingStrategy;
import com.demo.pattern.behavior.strategy.strategy.QuickWashingStrategy;
import com.demo.pattern.behavior.strategy.strategy.StandardWashingStrategy;

/**
 * @author huaihai.guan
 * @since 2021/1/26 17:29
 */
public class WashingStrategyFactory {

    public static WashingStrategy getWashingStrategy(String strategy) {
        WashingStrategy washingStrategy;
        switch (strategy) {
            case "bigClothes":
                washingStrategy = new BigClothesWashingStrategy();
                break;

            case "quick":
                washingStrategy = new QuickWashingStrategy();
                break;
            default:
                washingStrategy = new StandardWashingStrategy();
        }
        return washingStrategy;
    }
}
