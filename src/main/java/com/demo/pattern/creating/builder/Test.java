package com.demo.pattern.creating.builder;

/**
 * 创建者模式，把类的创建过程抽象为一个单独的创建类，并在该创建类中取回最终实例结果
 * @author huaihai.guan
 * @since 2021/1/22 18:10
 */
public class Test {

    public static void main(String[] args) {
        SoupBuilder builder = new DongGuaSoupBuilder();
        builder.buildSoup();
        builder.getResult();

        builder = new BanLiSoupBuilder();
        builder.buildSoup();
        builder.getResult();
    }
}
