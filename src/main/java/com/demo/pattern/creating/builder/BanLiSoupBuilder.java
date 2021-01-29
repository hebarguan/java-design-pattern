package com.demo.pattern.creating.builder;

/**
 * @author huaihai.guan
 * @since 2021/1/22 18:05
 */
public class BanLiSoupBuilder implements SoupBuilder {

    private Soup soup;

    @Override
    public void buildSoup() {
        soup = new BanLiPaiGuSoup();
        soup.addMeet();
        soup.addVegetables();
        soup.waitMinute(50);
        soup.addSalt();
    }

    @Override
    public Soup getResult() {
        return soup;
    }
}
