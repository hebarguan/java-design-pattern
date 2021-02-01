package com.demo.pattern.behavior.visitor;

/**
 * @author huaihai.guan
 * @since 2021/2/1 20:30
 */
public class Test {

    public static void main(String[] args) {
        ACompany aCompany = new ACompany();
        BCompany bCompany = new BCompany();

        Host host = new Host();
        host.addCompany(aCompany);
        host.addCompany(bCompany);

        CVisitor cVisitor = new CVisitor();
        DVisitor dVisitor = new DVisitor();

        host.acceptVisitor(cVisitor);
        host.acceptVisitor(dVisitor);
    }
}
