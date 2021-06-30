package com.demo.pattern.structure.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author huaihai.guan
 * @since 2021/6/25 12:19
 */
public class DynamicInvocation implements InvocationHandler {

    private final Object target;

    DynamicInvocation(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("do something before");
        Object result = method.invoke(this.target, args);
        System.out.println("do something after");
        return result;
    }
}
