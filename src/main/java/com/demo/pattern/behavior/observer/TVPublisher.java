package com.demo.pattern.behavior.observer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huaihai.guan
 * @since 2021/1/27 10:44
 */
public class TVPublisher implements Publisher {

    private Map<String, Listener> listenerMap = new HashMap<>();

    @Override
    public void addListener(Listener listener) {
        this.listenerMap.put(listener.getName(), listener);
    }

    @Override
    public void removeListener(Listener listener) {
        this.listenerMap.remove(listener.getName());
    }

    @Override
    public void publishEvent(Event event) {
        this.listenerMap.forEach((name, listener) -> {
            listener.onListen(event);
        });
    }
}
