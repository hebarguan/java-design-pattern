package com.demo.pattern.structure.adapter;

/**
 * @author huaihai.guan
 * @since 2021/2/1 20:58
 */
public class MysqlDriver implements Driver {

    @Override
    public void run() {

        System.out.println("MysqlDriver Work");
    }
}
