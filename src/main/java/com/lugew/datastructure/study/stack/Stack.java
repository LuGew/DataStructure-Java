package com.lugew.datastructure.study.stack;

import com.lugew.datastructure.study.common.Display;

/**
 * 栈
 *
 * @param <T> 泛型
 */
public class Stack<T> implements Display {
    private static final int CAPACITY = 50;
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

    public T peek(int index) {
        if (index >= 0 && index <= this.index) {
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

    public void display() {
        System.out.print("Stack (bottom-->top): ");
        for (int i = 0; i < size(); i++) {
            System.out.print(peek(i));
            System.out.print(" ");
        }
        System.out.println();
    }
}
