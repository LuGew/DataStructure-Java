package com.lugew.datastructure.util;

/**
 * 迭代器
 *
 * @param <T> 泛型
 */
public interface Iterator<T> {

    boolean hasNext();

    T next();
}
