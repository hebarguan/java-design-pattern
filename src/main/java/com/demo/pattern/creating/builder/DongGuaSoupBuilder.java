package com.demo.pattern.creating.builder;

/**
 * @author huaihai.guan
 * @since 2021/1/22 18:05
 */
public class DongGuaSoupBuilder implements SoupBuilder {
    private Soup soup;
    @Override
    public void buildSoup() {
        soup = new DongGuaPaiGuSoup();
        soup.addMeet();
        soup.waitMinute(30);
        soup.addVegetables();
        soup.waitMinute(20);
        soup.addSalt();
    }

    @Override
    public Soup getResult() {
        return soup;
    }
}
