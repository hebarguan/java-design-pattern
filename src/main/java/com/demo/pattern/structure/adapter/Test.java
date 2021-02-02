package com.demo.pattern.structure.adapter;

/**
 * @author huaihai.guan
 * @since 2021/2/1 21:11
 */
public class Test {

    public static void main(String[] args) {
        // 直接实现目标方法类
        BaseDriver baseDriver = new BaseDriver();
        baseDriver.work();

        // 添加适配器
        DriverAdapter adapter = new DriverAdapter();
        adapter.addDriver(new MysqlDriver());
        adapter.addDriver(new OracleDriver());

        adapter.work();
    }
}
