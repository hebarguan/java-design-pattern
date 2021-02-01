package com.demo.pattern.behavior.state;


import com.demo.pattern.behavior.state.state.NoneState;

/**
 * @author huaihai.guan
 * @since 2021/2/1 11:49
 */
public class Test {
    public static void main(String[] args) {
        User user = new User();
        user.setState(new NoneState());
        user.request();
    }
}
