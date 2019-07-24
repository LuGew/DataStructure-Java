package com.lugew.datastructure.study.linkedList;

import com.lugew.datastructure.study.common.Display;
import com.lugew.datastructure.study.common.List;


public class LinkedList<T> implements List<T>, Display {
    private Node<T> first;
    private int size;

    public LinkedList() {
        first = null;
    }

    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.next = first;
        first = newNode;
        size++;
    }

    @Override
    public T remove(T element) {
        Node<T> previous = first;
        Node<T> current = first;
        while (current.element.equals(element)) {
            if (current.next == null) {
                return null;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
        size--;
        return current.element;
    }

    @Override
    public T get(int index) {
        Node<T> current = first;
        int i = 0;
        while (i < index) {
            if (current.next == null) {
                return null;
            } else {
                current = current.next;
            }
            i++;
        }
        return current.element;
    }

    @Override
    public boolean contains(T element) {
        Node<T> current = first;
        if (!isEmpty()) {
            while (current != null && !element.equals(current.element)) {
                current = current.next;
            }
            return current != null;
        }
        return false;
    }

    @Override
    public T remove(int index) {
        Node<T> temp = first;
        first = first.next;
        return temp.element;
    }

    public boolean isEmpty() {
        return (first == null);
    }


    @Override
    public int size() {
        return 0;
    }


    @Override
    public void display() {
        System.out.print("List (first-->last):");
        Node<T> current = first;
        while (current != null) {
            current.display();
            current = current.next;
        }
        System.out.println();
    }

    private class Node<T> implements Display {
        private T element;
        private Node<T> next;

        public Node(T element) {
            this.element = element;
        }

        @Override
        public void display() {

        }
    }
}