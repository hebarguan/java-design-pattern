package com.demo.pattern.behavior.observer;

import java.io.Serializable;

/**
 * @author huaihai.guan
 * @since 2021/1/27 11:04
 */
public class SpiderManShow implements Serializable {

    private String name;

    private String time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return this.name + " 节目开始时间 " + this.time;
    }
}
