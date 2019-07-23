package com.lugew.datastructure.study.queue;

/**
 * 数组实现的优先队列
 *
 * @param <T> 泛型
 */
public class PriorityQueue<T extends Comparable<T>> {
    private int maxSize;
    private T[] queueArray;
    private int elements;

    public PriorityQueue(int maxSize) {
        this.maxSize = maxSize;
        queueArray = (T[]) new Object[maxSize];
        elements = 0;
    }

    public void insert(T item) {
        int j = elements;
        while (j - 1 >= 0 && queueArray[j - 1].compareTo(item) < 0) {
            queueArray[j] = queueArray[j - 1];
            j--;
        }
        queueArray[j] = item;
        elements++;
    }

    public T remove() {
        return queueArray[--elements];
    }

    public T peekMin() {
        return queueArray[elements - 1];
    }

    public boolean isEmpty() {
        return elements == 0;
    }

    public boolean isFull() {
        return elements == maxSize;
    }
}
