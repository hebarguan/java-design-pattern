package com.demo.pattern.behavior.state.state;

import com.demo.pattern.behavior.state.State;
import com.demo.pattern.behavior.state.User;

/**
 * @author huaihai.guan
 * @since 2021/2/1 11:09
 */
public class RegisterState implements State {

    @Override
    public void apply(User user) {

        System.out.println("跳转授权");
        user.setState(new CreditState());
        user.request();
    }
}
