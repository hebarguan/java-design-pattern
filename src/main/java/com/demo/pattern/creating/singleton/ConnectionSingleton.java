package com.demo.pattern.creating.singleton;

/**
 * 单例模式 - 对象只能被实例一次，而只能通过自身创建
 * @author huaihai.guan
 * @since 2021/1/21 17:29
 */
public class ConnectionSingleton {

    private static ConnectionSingleton connectionSingleton;

    private ConnectionSingleton() {}

    public static ConnectionSingleton getInstance() {
        if (connectionSingleton == null) {
            synchronized (ConnectionSingleton.class) {
                connectionSingleton = new ConnectionSingleton();
            }
        }
        return connectionSingleton;
    }

    public void apply() {
        System.out.println(this.getClass().getName());
    }
}
