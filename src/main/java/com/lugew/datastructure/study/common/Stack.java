package com.lugew.datastructure.study.common;

/**
 * 栈接口
 *
 * @author LuGew
 */
public interface Stack<T> extends Display {
    T pop();

    T peek();

    void push(T value);

    boolean isEmpty();

    boolean isFull();

    int size();
}
