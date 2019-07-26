package com.lugew.datastructure.util;

/**
 * 链表接口
 */
public interface List<T> extends Display {
    boolean add(T element);

    boolean remove(T element);

    T remove(int index);

    T get(int index);

    boolean contains(T element);

    boolean isEmpty();

    int indexOf(T element);

    int lastIndexOf(T element);

    int size();
}
