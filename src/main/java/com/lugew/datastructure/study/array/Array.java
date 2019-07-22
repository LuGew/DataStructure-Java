package com.lugew.datastructure.study.array;

/**
 * 数组接口
 *
 * @param <T> 可比较类
 */
public interface Array<T extends Comparable<T>> {
    void insert(T element);

    T delete(int index);

    int delete(T element);

    T get(int index);

    int get(T element);

    boolean isFull();

    boolean isEmpty();

    int size();
}
