package com.demo.pattern.behavior.strategy.strategy;

import com.demo.pattern.behavior.strategy.WashingStrategy;

/**
 * @author huaihai.guan
 * @since 2021/1/26 17:23
 */
public class StandardWashingStrategy implements WashingStrategy {

    @Override
    public void washing() {

        System.out.println("标准洗衣策略");
    }
}
