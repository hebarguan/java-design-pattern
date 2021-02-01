package com.demo.pattern.structure.adapter;

import com.demo.pattern.behavior.visitor.BCompany;

/**
 * @author huaihai.guan
 * @since 2021/2/1 20:48
 */
public class BaseDriver implements Target {

    private DriverAdapter driverAdapter;

    public BaseDriver() {
    }

    public BaseDriver(DriverAdapter adapter) {
        this.driverAdapter = adapter;
    }

    @Override
    public void work() {
        System.out.println("BaseDriver Work!");
        if (this.driverAdapter != null) {
            this.driverAdapter.work();
        }
    }
}
