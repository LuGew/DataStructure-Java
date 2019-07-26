package com.lugew.datastructure.study.linkedList;

/**
 * 单端单向链表
 * 复杂度分析:add:O(1),remove:O(N),get:O(N),contains:O(N)
 *
 * @param <T> 泛型
 */
public class FirstLinkedList<T> extends SinglyLinkedList<T> {
    public FirstLinkedList() {
        super();
    }

    @Override
    public boolean add(T element) {
        Node<T> newNode = new Node<T>(element);
        if (isEmpty()) {
            first = newNode;
        } else {
            newNode.next = first.next;
            first = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(T element) {
        Node<T> previous = first;
        Node<T> current = first;
        while (current != null && !current.element.equals(element)) {
            previous = current;
            current = current.next;
        }
        if (current == null) {
            return false;
        } else {
            if (current == first) {
                first = first.next;
            } else {
                previous.next = current.next;
            }
            size--;
            return true;
        }

    }
}