package com.demo.pattern.behavior.visitor;

/**
 * @author huaihai.guan
 * @since 2021/2/1 20:13
 */
public class DVisitor implements Visitor {

    @Override
    public void visit(ACompany aCompany) {
        System.out.println("DV 访问A");
        aCompany.aCompanyAction();
    }

    @Override
    public void visit(BCompany bCompany) {
        System.out.println("DV 访问B");
        bCompany.bCompanyAction();
    }
}
