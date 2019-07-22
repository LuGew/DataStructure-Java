package com.lugew.datastructure.study.array;

/**
 * 1.有序数组
 * 2.复杂度分析:insert:O(N),delete:O(N),get:O(logN)/O(1)
 *
 * @author LuGew
 */
public class OrderedArray<T extends Comparable<T>> extends AbstractArray<T> {
    public void insert(T element) {
        int index = get(element);
        if (index != -1) {
            int i = size - 1;
            for (; i >= index; i--) {
                array[i] = array[i - 1];
            }
            array[i] = element;
        }
    }

    /**
     * 二分法查找
     *
     * @param element 元素
     * @return index
     */
    public int get(T element) {
        int left = 0;
        int right = size - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            T middleElement = array[middle];
            if (middleElement.compareTo(element) > 0) {
                right = middle - 1;
            } else if (middleElement.compareTo(element) < 0) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}

