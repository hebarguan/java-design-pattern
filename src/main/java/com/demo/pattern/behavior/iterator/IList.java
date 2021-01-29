package com.demo.pattern.behavior.iterator;

/**
 * @author huaihai.guan
 * @since 2021/1/26 18:38
 */
public interface IList<T> {

    int size();

    void add(T object);

    T get(int index);

    Iterator iterator();
}
