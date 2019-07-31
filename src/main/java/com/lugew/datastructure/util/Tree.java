package com.lugew.datastructure.util;


/**
 * 树接口
 *
 * @author LuGew
 * @since 2019/7/31
 */
public interface Tree<T> extends Display {
    Node find(T element);

    boolean add(T element);

    boolean delete(T element);

    int size();

    boolean isEmpty();

}
