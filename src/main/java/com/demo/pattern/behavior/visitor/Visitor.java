package com.demo.pattern.behavior.visitor;

/**
 * @author huaihai.guan
 * @date 2021/2/1 20:03
 */
public interface Visitor {

    void visit(ACompany aCompany);

    void visit(BCompany bCompany);
}
