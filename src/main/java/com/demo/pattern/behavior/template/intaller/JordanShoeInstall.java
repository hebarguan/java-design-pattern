package com.demo.pattern.behavior.template.intaller;

import com.demo.pattern.behavior.template.ShoeInstallTemplate;

/**
 * @author huaihai.guan
 * @since 2021/1/22 20:02
 */
public class JordanShoeInstall extends ShoeInstallTemplate {
    @Override
    public void installSole() {

        System.out.println("组装 Jordan 鞋底");
    }

    @Override
    public void installInsole() {

        System.out.println("组装 Jordan 鞋面");
    }

    @Override
    public void installVamp() {

        System.out.println("组装 Jordan 鞋底");
    }

    @Override
    public void installShoelace() {

        System.out.println("组装 Jordan 鞋带");
    }
}
