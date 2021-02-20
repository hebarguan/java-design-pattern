package com.demo.pattern.structure.facade;

/**
 * @author huaihai.guan
 * @since 2021/2/20 10:24
 */
public class Leader {

    public void develop(String name) {
        ApiDeveloper apiDeveloper = new ApiDeveloper(name);
        WebDeveloper webDeveloper = new WebDeveloper(name);
        Tester tester = new Tester(name);
        apiDeveloper.work();
        webDeveloper.work();
        tester.startTest();
    }
}
