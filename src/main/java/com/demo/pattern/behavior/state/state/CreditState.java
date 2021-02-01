package com.demo.pattern.behavior.state.state;

import com.demo.pattern.behavior.state.State;
import com.demo.pattern.behavior.state.User;

/**
 * @author huaihai.guan
 * @since 2021/2/1 11:45
 */
public class CreditState implements State {

    @Override
    public void apply(User user) {

        System.out.println("跳转借款");
        user.setState(new DrawState());
        user.request();
    }
}
