package com.demo.pattern.behavior.visitor;

/**
 * @author huaihai.guan
 * @date 2021/2/1 20:06
 */
public interface Company {

    void accept(Visitor visitor);
}

