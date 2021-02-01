package com.demo.pattern.behavior.visitor;

/**
 * @author huaihai.guan
 * @since 2021/2/1 20:07
 */
public class BCompany implements Company {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void bCompanyAction() {

        System.out.println("B公司方案");
    }
}
