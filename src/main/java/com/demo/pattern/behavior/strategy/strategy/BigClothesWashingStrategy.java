package com.demo.pattern.behavior.strategy.strategy;

import com.demo.pattern.behavior.strategy.WashingStrategy;

/**
 * @author huaihai.guan
 * @since 2021/1/26 17:25
 */
public class BigClothesWashingStrategy implements WashingStrategy {

    @Override
    public void washing() {

        System.out.println("大衣洗涤策略");
    }
}
