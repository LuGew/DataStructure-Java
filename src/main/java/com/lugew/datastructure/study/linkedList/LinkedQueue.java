package com.lugew.datastructure.study.linkedList;

import com.lugew.datastructure.util.List;
import com.lugew.datastructure.util.Queue;

/**
 * 单向链表实现的队列
 * 复杂度分析:add:O(1),remove:O(N)
 *
 * @param <T> 泛型
 * @author LuGew
 */
public class LinkedQueue<T> implements Queue<T> {
    private List<T> list;

    public LinkedQueue() {
        list = new FirstLinkedList<>();
    }

    @Override
    public int size() {
        return list.size();
    }


    @Override
    public boolean add(T value) {
        return list.add(value);
    }

    @Override
    public T remove() {
        return list.remove(0);
    }


    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }


    @Override
    public void display() {
        list.display();
    }
}

