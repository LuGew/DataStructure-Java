package com.lugew.datastructure.practice.queue;

public class PriorityQueue {
    private long[] array;
    private int index;
    private int maxIndex;

    public PriorityQueue(int size) {
        array = new long[size];
        maxIndex = 0;
    }

    public PriorityQueue() {
        this(10);
    }

    public void insert(long value) {
        if (!isFull()) {
            if (value >= array[maxIndex]) {
                maxIndex = index;
            }
            array[index++] = value;
        }
    }

    public boolean isFull() {
        return index == array.length;
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public long remove() {
        long max = array[maxIndex];
        for (int i = maxIndex; i < index && i + 1 < array.length; i++) {
            array[i] = array[i + 1];
        }
        return max;
    }
}
