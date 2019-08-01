package com.lugew.datastructure.util;


/**
 * 树接口
 *
 * @author LuGew
 * @since 2019/7/31
 */
public interface Tree<T extends Comparable<T>> extends Display {
    Node<T> find(T element);

    boolean add(T element);

    boolean delete(T element);

    int size();

    boolean isEmpty();

    void inorderTraversal(Node<T> node);

    void postorderTraversal(Node<T> node);

    void preorderTraversal(Node<T> node);


}
