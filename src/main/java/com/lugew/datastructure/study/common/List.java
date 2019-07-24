package com.lugew.datastructure.study.common;

/**
 * 链表接口
 */
public interface List<T> {
    void add(T element);

    T remove(T element);

    T get(int index);

    boolean contains(T element);

    T remove(int index);

    boolean isEmpty();


    int size();
}
