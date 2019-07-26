package com.lugew.datastructure.util;

/**
 * 队列接口
 *
 * @author LuGew
 */
public interface Queue<T> extends Display {

    boolean add(T element);

    T remove();

    boolean isEmpty();

    int size();
}
