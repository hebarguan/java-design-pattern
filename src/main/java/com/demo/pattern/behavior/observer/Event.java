package com.demo.pattern.behavior.observer;

/**
 * @author huaihai.guan
 * @since 2021/1/27 10:40
 */
public abstract class Event {

    protected Object source;

    public abstract void addSource(Object source);

    public abstract Object getSource();
}
