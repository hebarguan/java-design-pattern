package com.demo.pattern.structure.bridge;

/**
 * @author huaihai.guan
 * @since 2021/2/8 18:24
 */
public class Chrome implements Software {

    @Override
    public void open(Phone phone) {
        System.out.println("在" + phone.getSystem() + "中打开Chrome浏览器");
    }
}
