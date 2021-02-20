package com.demo.pattern.structure.facade;

/**
 * 提供一个统一对外的接口，隐藏内部的实现细节
 * @author huaihai.guan
 * @since 2021/2/20 10:29
 */
public class Test {

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.develop("【新增列表功能】");
    }
}
