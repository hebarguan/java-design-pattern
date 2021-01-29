package com.demo.pattern.behavior.observer;

/**
 * @author huaihai.guan
 * @since 2021/1/27 10:38
 */
public class TV105Listener implements Listener {

    private String name;

    public TV105Listener(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void onListen(Event event) {
        if (event instanceof TV105Event) {
            System.out.println(this.name + " 在收听节目 " + event.getSource().toString());
        }
    }
}
