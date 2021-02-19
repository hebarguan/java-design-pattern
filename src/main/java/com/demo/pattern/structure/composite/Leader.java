package com.demo.pattern.structure.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huaihai.guan
 * @since 2021/2/19 18:30
 */
public class Leader extends Employee {

    private List<Employee> employees = new ArrayList<>();

    public Leader(String name) {
        super.setName(name);
    }

    public void add(Employee employee) {
        this.employees.add(employee);
    }

    public void remove(Employee employee) {
        this.employees.remove(employee);
    }

    @Override
    void display(int level) {
        String line = this.levelLine(level);
        System.out.println(line + this.getName());
        for (Employee employee : this.employees) {
            employee.display(level + 1);
        }
    }
}
