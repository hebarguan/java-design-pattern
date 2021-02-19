package com.demo.pattern.structure.composite;

/**
 * @author huaihai.guan
 * @since 2021/2/19 18:51
 */
public class Test {

    public static void main(String[] args) {
        Leader leader1 = new Leader("刘总");
        Leader leader2 = new Leader("李总监");
        Engineer engineer = new Engineer("张工");
        Engineer engineer1 = new Engineer("赵工");


        leader1.add(leader2);
        leader2.add(engineer);
        leader2.add(engineer1);

        Leader leader3 = new Leader("何总监");
        Engineer engineer2 = new Engineer("许工");
        Engineer engineer3 = new Engineer("谢工");

        leader1.add(leader3);
        leader3.add(engineer2);
        leader3.add(engineer3);

        leader1.display(0);

    }
}
