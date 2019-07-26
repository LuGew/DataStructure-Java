package com.lugew.datastructure.study.linkedList;

import com.lugew.datastructure.util.Display;
import com.lugew.datastructure.util.List;
import com.sun.org.apache.regexp.internal.RE;

/**
 * 双端双向链表
 *
 * @author LuGew
 */
public class DoublyLinkedList<T> implements List<T> {
    protected Node<T> first;
    protected Node<T> last;
    protected int size;

    @Override
    public boolean add(T element) {
        return addFirst(element);
    }

    public boolean addFirst(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            last = newNode;
        } else {
            first.previous = newNode;
            newNode.next = first;
        }
        first = newNode;
        size++;
        return true;
    }

    public boolean addLast(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
            newNode.previous = newNode;
        }
        last = newNode;
        size++;
        return true;
    }

    @Override
    public boolean remove(T element) {
        Node<T> current = first;
        while (current != null && !current.element.equals(element)) {
            current = current.next;
        }
        if (current == null) {
            return false;
        } else {
            removeElement(current);
            return true;
        }
    }

    private void removeElement(Node<T> current) {
        Node<T> previous = current.previous;
        Node<T> next = current.next;
        if (previous != null) {
            previous.next = next;
        }
        if (next != null) {
            next.previous = previous;
        }
        if (current == first) {
            first = next;
        }
        if (current == last) {
            last = previous;
        }
        size--;
    }

    @Override
    public T remove(int index) {
        Node<T> current = getNode(index);
        if (current != null) {
            removeElement(current);
            return current.element;
        }
        return null;
    }


    private Node<T> getNode(int index) {
        Node<T> current = last;
        int i = 0;
        while (i <= index) {
            if (current == null) {
                return null;
            }
            current = current.previous;
            i++;
        }
        return current;
    }

    @Override
    public T get(int index) {
        Node<T> current = last;
        int i = 0;
        while (i <= index) {
            if (current == null) {
                return null;
            }
            current = current.previous;
            i++;
        }
        return current.element;
    }

    @Override
    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int indexOf(T element) {
        Node<T> current = last;
        int i = -1;
        while (current != null && !current.element.equals(element)) {
            current = current.previous;
            i++;
        }
        if (current == null) {
            return -1;
        } else {
            return i;
        }
    }

    @Override
    public int lastIndexOf(T element) {
        Node<T> current = first;
        int i = -1;
        while (current != null && !current.element.equals(element)) {
            current = current.previous;
            i++;
        }
        if (current == null) {
            return -1;
        } else {
            return i;
        }
    }

    @Override
    public int size() {
        return size;
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
        Node<T> previous;

        Node(T element) {
            this.element = element;
        }

        @Override
        public void display() {
            System.out.println(element.toString());
        }
    }
}
