package com.demo.pattern.behavior.state;

/**
 * @author huaihai.guan
 * @since 2021/2/1 11:32
 */
public class User {

    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void request() {
        this.state.apply(this);
    }
}
