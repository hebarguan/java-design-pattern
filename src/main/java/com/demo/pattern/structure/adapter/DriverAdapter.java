package com.demo.pattern.structure.adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huaihai.guan
 * @since 2021/2/1 20:49
 */
public class DriverAdapter implements Target {

    private List<Driver> drivers = new ArrayList<>();

    public void addDriver(Driver driver) {
        this.drivers.add(driver);
    }

    @Override
    public void work() {
        if (this.drivers.size() > 0) {
            System.out.println("适配器开始运行");
            this.drivers.forEach(Driver::run);
        }
    }
}
