package com.demo.pattern.structure.adapter;

/**
 * @author huaihai.guan
 * @since 2021/2/1 20:49
 */
public class DriverAdapter {

    private Driver driver;

    public DriverAdapter(Driver driver) {
        this.driver = driver;
    }

    public void work() {
        if (this.driver != null) {
            System.out.println("适配器开始运行");
            this.driver.run();
        }
    }
}
