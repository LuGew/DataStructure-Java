package com.lugew.datastructure.java.stackqueue;

public class Queue {
    private int maxSize;
    private long[] queueArray;
    private int front;
    private int rear;

    public Queue(int maxSize) {
        this.maxSize = maxSize + 1;
        queueArray = new long[this.maxSize];
        front = 0;
        rear = -1;

    }

    public void insert(long value) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queueArray[++rear] = value;
    }

    public long remove() {
        long temp = queueArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        return temp;
    }

    public long peekFront() {
        return queueArray[front];
    }

    public boolean isEmpty() {
        return (rear + 1 == front) || (front + maxSize - 1 == rear);
    }

    public boolean isFull() {
        return (rear + 2 == front) || (front + maxSize - 2 == rear);
    }

    public int size() {
        if (rear >= front) {
            return rear - front + 1;
        } else {
            return (maxSize - front + rear + 1);
        }
    }

    public void display() {
        if (!isEmpty()) {
            if (rear >= front) {
                for (int i = front; i <= rear; i++) {
                    System.out.print(queueArray[i] + " ");
                }
            } else {
                for (int i = front; i < maxSize; i++) {
                    System.out.print(queueArray[i] + " ");
                }
                for (int i = 0; i <= rear; i++) {
                    System.out.print(queueArray[i] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
       /* Queue queue = new Queue(5);
        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);

        queue.remove();
        queue.remove();
        queue.remove();
        queue.insert(50);
        queue.insert(60);
        queue.insert(70);
        queue.insert(80);

        while (!queue.isEmpty()) {
            long n = queue.remove();
            System.out.print(n);
            System.out.print(" ");

        }
        System.out.println();*/

        Queue queue = new Queue(10);
        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);

       /* queue.remove();
        queue.remove();
        queue.remove();*/
        queue.insert(50);
        queue.insert(60);
        queue.insert(70);
        queue.insert(80);
        queue.display();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.display();

    }
}
