package com.lugew.datastructure.practice.queue;

public class Deque {
    private long[] array;
    private int size;
    private int front;
    private int rear;

    public Deque() {
        this(10);
    }

    public Deque(int size) {
        this.size = size + 1;
        array = new long[this.size];
        front = 0;
        rear = -1;
    }

    public boolean isEmpty() {
        return (rear + 1 == front) || (front + size - 1 == rear);
    }

    public boolean isFull() {
        return (rear + 2 == front) || (front + size - 2 == rear);
    }

    public void insertLeft(long value) {
        if (!isFull()) {
            if (front == 0) {
                front = size;
            }
            array[front--] = value;
        }
    }

    public void insertRight(long value) {
        if (!isFull()) {
            if (rear == size - 1) {
                rear = -1;
            }
            array[rear++] = value;
        }
    }

    public long removeLeft() {
        if (!isEmpty()) {
            if (front == size) {
                front = -1;
            }
            return array[front++];
        }
        return -1;
    }

    public long removeRight() {
        if (!isEmpty()) {
            if (rear == 0) {
                rear = size;
            }
            return array[size--];
        }
        return -1;
    }

    public int size() {
        if (!isEmpty()) {
            if (rear >= front) {
                return rear - front + 1;
            } else {
                return rear + 1 + size - front;
            }
        }
        return 0;
    }

    public void push(long value) {
        insertRight(value);
    }

    public long pop() {
        return removeLeft();
    }

    public long peek() {
        if (!isEmpty()) {
            return array[rear];
        }
        return -1;
    }




}
