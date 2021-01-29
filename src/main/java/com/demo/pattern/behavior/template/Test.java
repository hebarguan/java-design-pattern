package com.demo.pattern.behavior.template;

import com.demo.pattern.behavior.template.intaller.AdidasShoeInstall;
import com.demo.pattern.behavior.template.intaller.JordanShoeInstall;

/**
 *
 * 模板模式，抽象类某个方法决定整理的调用逻辑，具体细节留给子类去实现
 * @author huaihai.guan
 * @since 2021/1/22 20:03
 */
public class Test {
    public static void main(String[] args) {
        AdidasShoeInstall adidasShoeInstall = new AdidasShoeInstall();
        adidasShoeInstall.installShot();

        JordanShoeInstall jordanShoeInstall = new JordanShoeInstall();
        jordanShoeInstall.installShot();
    }
}
