package com.lugew.datastructure.study.stack;

public class StackX {
    private int maxSize;
    private char[] stackArray;
    private int top;

    public StackX(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char value) {
        stackArray[++top] = value;
    }

    public char pop() {
        return stackArray[top--];
    }

    public char peek() {
        return stackArray[top];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public char peekN(int index) {
        return stackArray[index];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public void displayStack(String s) {
        System.out.print(s);
        System.out.print("Stack (bottom-->top): ");
        for (int i = 0; i <size(); i++) {
            System.out.print(peekN(i));
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
      /*  StackX theStack = new StackX(10);
        theStack.push(20);
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);
        while (!theStack.isEmpty()) {
            long value = theStack.pop();
            System.out.print(value);
            System.out.print(" ");
        }
        System.out.println();*/

    }
}
