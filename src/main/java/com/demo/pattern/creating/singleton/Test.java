package com.demo.pattern.creating.singleton;

/**
 * @author huaihai.guan
 * @since 2021/1/21 17:36
 */
public class Test {

    public static void main(String[] args) {
        ConnectionSingleton connectionSingleton = ConnectionSingleton.getInstance();
        connectionSingleton.apply();
    }
}
