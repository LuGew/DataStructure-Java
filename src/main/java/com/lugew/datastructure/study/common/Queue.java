package com.lugew.datastructure.study.common;

/**
 * 队列接口
 *
 * @author LuGew
 */
public interface Queue<T> {

    void insert(T value);

    T remove();


    boolean isEmpty();

    boolean isFull();

    int size();
}
