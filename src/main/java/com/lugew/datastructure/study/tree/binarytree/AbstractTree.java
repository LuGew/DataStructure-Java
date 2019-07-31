package com.lugew.datastructure.study.tree.binarytree;

import com.lugew.datastructure.util.Tree;

/**
 * 抽象树
 *
 * @author LuGew
 * @since 2019/7/31
 */
public abstract class AbstractTree<T extends Comparable<T>> implements Tree<T> {

    protected int size;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }


}
