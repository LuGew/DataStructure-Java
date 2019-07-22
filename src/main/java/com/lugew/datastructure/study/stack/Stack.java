package com.lugew.datastructure.study.stack;

public class Stack<T> {
    public static final int CAPACITY = 50;
    private int maxSize;
    private T[] array;
    private int index;

    public Stack() {
        this(CAPACITY);
    }

    public Stack(int maxSize) {
        if (maxSize > 0) {
            this.maxSize = maxSize;
            array = (T[]) new Object[maxSize];
            index = -1;
        }
    }

    public T pop() {
        if (!isEmpty()) {
            return array[index--];
        }
        return null;
    }

    public T peek() {
        if (!isEmpty()) {
            return array[index];
        }
        return null;
    }

    public void push(T value) {
        if (!isFull()) {
            array[++index] = value;
        }
    }

    public boolean isEmpty() {
        return index == -1;
    }

    public int size() {
        return index + 1;
    }

    public boolean isFull() {
        return index == maxSize - 1;
    }
}
