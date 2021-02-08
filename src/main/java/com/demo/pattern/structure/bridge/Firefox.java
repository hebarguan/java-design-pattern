package com.demo.pattern.structure.bridge;

/**
 * @author huaihai.guan
 * @since 2021/2/8 18:22
 */
public class Firefox implements Software {

    @Override
    public void open(Phone phone) {

        System.out.println("在" + phone.getSystem() + "中打开Firefox浏览器");
    }
}
