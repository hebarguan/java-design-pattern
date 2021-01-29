package com.demo.pattern.behavior.iterator;

/**
 * @author huaihai.guan
 * @date 2021/1/26 18:46
 */
public interface Iterator<E> {

    E next();

    boolean hasNext();

}
