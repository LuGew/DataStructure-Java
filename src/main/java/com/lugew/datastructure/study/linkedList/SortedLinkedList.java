package com.lugew.datastructure.study.linkedList;

/**
 * 有序单端单向链表
 * 复杂度分析:add:O(N),remove:O(N),get:O(N),contains:O(N)
 *
 * @param <T> 泛型
 * @author LuGew
 */
public class SortedLinkedList<T extends Comparable<T>> extends SinglyLinkedList<T> {

    public SortedLinkedList() {
        super();
    }

    /**
     * 插入排序比数组要快，只有比较，没有复制
     *
     * @param element 元素
     * @return 插入成功标志
     */
    @Override
    public boolean add(T element) {
        Node<T> newLink = new Node<T>(element);
        Node<T> previous = null;
        Node<T> current = first;
        while (current != null && element.compareTo(current.element) > 0) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            first = newLink;
        } else {
            previous.next = newLink;
        }

        newLink.next = current;
        return true;
    }

    @Override
    public boolean remove(T element) {
        Node<T> previous = first;
        Node<T> current = first;
        while (current != null && current.element.compareTo(element) != 0) {
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

