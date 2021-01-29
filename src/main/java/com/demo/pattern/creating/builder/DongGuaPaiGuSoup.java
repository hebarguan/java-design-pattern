package com.demo.pattern.creating.builder;

/**
 * @author huaihai.guan
 * @since 2021/1/22 17:58
 */
public class DongGuaPaiGuSoup implements Soup {
    @Override
    public void addMeet() {

        System.out.println("加排骨");
    }

    @Override
    public void addVegetables() {


        System.out.println("加冬瓜");
    }

    @Override
    public void waitMinute(Integer time) {


        System.out.println("煮" + time + "分钟");
    }

    @Override
    public void addSalt() {


        System.out.println("加盐");
    }
}
