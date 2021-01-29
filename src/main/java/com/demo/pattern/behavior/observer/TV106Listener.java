package com.demo.pattern.behavior.observer;

/**
 * @author huaihai.guan
 * @since 2021/1/27 11:32
 */
public class TV106Listener implements Listener {


    private String name;

    public TV106Listener(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void onListen(Event event) {
        if (event instanceof TV106Event) {
            System.out.println(this.name + " 在收听节目 " + event.getSource().toString());
        }
    }

}
