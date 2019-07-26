package com.lugew.datastructure.study.linkedList;

import com.lugew.datastructure.util.Display;
import com.lugew.datastructure.util.List;

/**
 * 单端单向链表
 *
 * @author LuGew
 */
public abstract class SinglyLinkedList<T> implements List<T>, Display {
    Node<T> first;
    int size;

    SinglyLinkedList() {
        first = null;
    }


    @Override
    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    @Override
    public T get(int index) {
        if (size - 1 >= index) {
            int tempIndex = size - 1 - index;
            Node<T> current = first;
            while (tempIndex > 0) {
                current = current.next;
                tempIndex--;
            }
            return current.element;
        }
        return null;
    }

    @Override
    public int indexOf(T element) {
        int index = lastIndexOf(element);
        if (index == -1) {
            return -1;
        } else {
            return size - 1 - index;
        }
    }

    @Override
    public int lastIndexOf(T element) {
        Node<T> current = first;
        int index = 0;
        while (current != null) {
            if (current.element.equals(element)) {
                return index;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T remove(int index) {
        return null;
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

    protected class Node<T> implements Display {
        T element;
        Node<T> next;

        Node(T element) {
            this.element = element;
        }

        @Override
        public void display() {
            System.out.println(element.toString());
        }
    }
}
