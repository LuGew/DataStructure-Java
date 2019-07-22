package com.lugew.datastructure.study.array;

/**
 * 1.无序数组的泛型实现。
 * 2.复杂度分析:insert:O(1),delete:O(N),get:O(N)/O(1)
 *
 * @author LuGew
 */
public class UnorderedArray<T extends Comparable<T>> extends AbstractArray<T> {

    public void insert(T element) {
        array[size++] = element;
    }

    public int get(T element) {
        for (int i = 0; i < size; i++) {
            T currentElement = array[i];
            if (currentElement.compareTo(element) == 0) {
                return i;
            }
        }
        return -1;
    }
}
