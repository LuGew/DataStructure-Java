package com.lugew.datastructure.study.linkedList;

import com.lugew.datastructure.util.List;

public class LinkQueue implements List<T> {
    private FirstLastList firstLastList;

    public LinkQueue() {
        firstLastList = new FirstLastList();
    }

    public boolean isEmpty() {
        return firstLastList.isEmpty();
    }

    public void insert(long value) {
        firstLastList.insertLast(value);
    }

    public long remove() {
        return firstLastList.deleteFirst();
    }

    public void displayQueue() {
        System.out.print("Queue (front-->rear): ");
        firstLastList.displayList();
    }

}

