package com.demo.pattern.structure.adapter;

/**
 * @author huaihai.guan
 * @since 2021/2/1 21:11
 */
public class Test {

    public static void main(String[] args) {
        BaseDriver driver = new BaseDriver();
        driver.work();

        DriverAdapter adapter = new DriverAdapter(new ADriver());
        BaseDriver driver1 = new BaseDriver(adapter);
        driver1.work();

        DriverAdapter adapter2 = new DriverAdapter(new BDriver());
        BaseDriver driver2 = new BaseDriver(adapter2);
        driver2.work();
    }
}
