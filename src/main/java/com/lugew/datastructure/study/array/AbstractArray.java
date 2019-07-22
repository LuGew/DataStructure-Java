package com.lugew.datastructure.study.array;

/**
 * @author LuGew
 */
public abstract class AbstractArray<T extends Comparable<T>> implements Array<T> {
    private static final int CAPACITY = 10;
    protected T[] array;
    protected int size;

    public AbstractArray() {
        array = (T[]) new Object[CAPACITY];
    }

    public AbstractArray(int length) {
        if (length <= 0) {
            length = CAPACITY;
        }
        array = (T[]) new Object[length];

    }

    public AbstractArray(T[] array) {
        this.array = array;
        this.size = array.length;
    }

    public T delete(int index) {
        T element = null;
        if (index >= 0 && index < size) {
            element = array[index];
            for (int i = index; i < size - 1; i++) {
                array[index] = array[index + 1];
            }
            size--;
        }
        return element;
    }

    public int delete(T element) {
        int index = get(element);
        delete(index);
        return index;
    }

    public T get(int index) {
        if (index >= 0 && index < size) {
            return array[index];
        }
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isFull() {
        return array.length == size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
