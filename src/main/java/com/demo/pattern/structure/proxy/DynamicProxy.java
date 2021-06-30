package com.demo.pattern.structure.proxy;

import java.lang.reflect.Proxy;

/**
 * @author huaihai.guan
 * @since 2021/6/25 12:27
 */
public class DynamicProxy {

    public static void main(String[] args) {
        WorldInternet worldInternet = new WorldInternet();
        Internet internetProxy = (Internet) Proxy.newProxyInstance(worldInternet.getClass().getClassLoader(),
                worldInternet.getClass().getInterfaces(),
                new DynamicInvocation(worldInternet));

        internetProxy.access("google.com");
    }


}
