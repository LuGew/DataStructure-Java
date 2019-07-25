package com.lugew.datastructure.study.linkedList;

/**
 * 双端单向链表
 * 复杂度分析:add:O(1),remove:O(N),get:O(N),contains:O(N)
 *
 * @param <T> 泛型
 * @author LuGew
 */
public class FirstLastLinkedList<T> extends SinglyLinkedList<T> {
    private Node<T> last;

    public FirstLastLinkedList() {
        super();
        last = null;
    }

    @Override
    public boolean add(T element) {
        return addFirst(element);
    }

    public boolean addFirst(T element) {
        Node<T> newNode = new Node<T>(element);
        if (isEmpty()) {
            last = newNode;
        }
        newNode.next = first;
        first = newNode;
        size++;
        return true;
    }

    public boolean addLast(T element) {
        Node<T> newNode = new Node<T>(element);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
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
            previous.next = current.next;
            if (current == first) {
                first = first.next;
            }
            if (current == last) {
                last = null;
            }
            size--;
            return true;
        }
    }

    @Override
    public boolean remove(int index) {
        return false;
    }

}


