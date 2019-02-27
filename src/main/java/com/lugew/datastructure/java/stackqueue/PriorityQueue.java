package com.lugew.datastructure.java.stackqueue;

public class PriorityQueue {
    private int maxSize;
    private long[] queueArray;
    private int elements;

    public PriorityQueue(int maxSize) {
        this.maxSize = maxSize;
        queueArray = new long[maxSize];
        elements = 0;
    }

    public void insert(long item) {
        int j = elements;
        while (j - 1 >= 0 && queueArray[j - 1] < item) {
            queueArray[j] = queueArray[j - 1];
            j--;
        }
        queueArray[j] = item;
        elements++;
    }

    public long remove() {
        return queueArray[--elements];
    }

    public long peekMin() {
        return queueArray[elements - 1];
    }

    public boolean isEmpty() {
        return elements == 0;
    }

    public boolean isFull() {
        return elements == maxSize;
    }

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(5);
        priorityQueue.insert(30);
        priorityQueue.insert(50);
        priorityQueue.insert(10);
        priorityQueue.insert(40);
        priorityQueue.insert(20);

        while (!priorityQueue.isEmpty()) {
            long item = priorityQueue.remove();
            System.out.print(item + "　");
        }
        System.out.println();

    }
}
