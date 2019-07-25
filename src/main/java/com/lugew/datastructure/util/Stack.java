package com.lugew.datastructure.util;

/**
 * 栈接口
 *
 * @author LuGew
 */
public interface Stack<T> extends Display {
    T pop();

    T peek();

    boolean push(T value);

    boolean isEmpty();


    int size();
}
