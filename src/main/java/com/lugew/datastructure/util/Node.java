package com.lugew.datastructure.util;

/**
 * 树节点接口
 *
 * @author LuGew
 * @since 2019/7/31
 */
public interface Node<T extends Comparable<T>> extends Display {
    T getData();

    Node<T> getLeftChild();

    Node<T> getRightChild();

    Node<T> setLeftChild(Node<T> node);

    Node<T> setRightChild(Node<T> node);

}
