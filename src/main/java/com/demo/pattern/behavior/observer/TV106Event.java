package com.demo.pattern.behavior.observer;

/**
 * @author huaihai.guan
 * @since 2021/1/27 11:29
 */
public class TV106Event extends Event {

    @Override
    public void addSource(Object source) {
        this.source = source;
    }

    @Override
    public Object getSource() {
        return this.source;
    }
}
