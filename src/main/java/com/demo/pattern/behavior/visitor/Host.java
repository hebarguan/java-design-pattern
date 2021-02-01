package com.demo.pattern.behavior.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huaihai.guan
 * @since 2021/2/1 20:08
 */
public class Host {

    private List<Company> companies = new ArrayList<>();

    public void addCompany(Company company) {
        this.companies.add(company);
    }

    public void acceptVisitor(Visitor visitor) {
        this.companies.forEach(company -> {
            company.accept(visitor);
        });
    }
}
