package com.demo.pattern.behavior.state.state;

import com.demo.pattern.behavior.state.State;
import com.demo.pattern.behavior.state.User;

/**
 * @author huaihai.guan
 * @since 2021/2/1 11:45
 */
public class DrawState implements State {

    @Override
    public void apply(User user) {
        System.out.println("借钱2毛完成");
    }
}
