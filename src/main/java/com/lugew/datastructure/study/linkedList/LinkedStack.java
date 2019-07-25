package com.lugew.datastructure.study.linkedList;

import com.lugew.datastructure.util.List;
import com.lugew.datastructure.util.Stack;

public class LinkedStack<T> implements Stack<T> {

    private List<T> list;

    public LinkedStack() {
        this.list = new FirstLinkedList<>();
    }

    @Override
    public T pop() {
        T element = peek();
        list.remove(element);
        return element;
    }

    @Override
    public T peek() {
        return list.get(list.size() - 1);
    }

    @Override
    public boolean push(T value) {
        return list.add(value);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }


    @Override
    public void display() {
        list.display();
    }
}
