package com.demo.pattern.behavior.visitor;

/**
 * @author huaihai.guan
 * @since 2021/2/1 20:06
 */
public class ACompany implements Company {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void aCompanyAction() {
        System.out.println("A公司方案");
    }
}
