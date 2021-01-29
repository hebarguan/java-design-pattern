package com.demo.pattern.behavior.observer;

/**
 * @author huaihai.guan
 * @date 2021/1/26 20:38
 */
public interface Publisher {

    void addListener(Listener listener);

    void removeListener(Listener listener);

    void publishEvent(Event event);

}
