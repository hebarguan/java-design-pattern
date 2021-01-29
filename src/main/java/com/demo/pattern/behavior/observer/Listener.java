package com.demo.pattern.behavior.observer;

/**
 * @author huaihai.guan
 * @date 2021/1/27 10:39
 */
public interface Listener {

    String getName();

    void onListen(Event event);
}
