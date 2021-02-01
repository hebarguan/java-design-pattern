package com.demo.pattern.behavior.state.state;

import com.demo.pattern.behavior.state.State;
import com.demo.pattern.behavior.state.User;

/**
 * @author huaihai.guan
 * @since 2021/2/1 11:14
 */
public class NoneState implements State {

    @Override
    public void apply(User user) {

        System.out.println("跳转注册");
        user.setState(new RegisterState());
        user.request();
    }
}
