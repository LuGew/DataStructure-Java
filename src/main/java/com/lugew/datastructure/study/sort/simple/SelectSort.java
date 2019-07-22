package com.lugew.datastructure.study.sort.simple;

/**
 * 时间复杂度O(N^2)
 * 比较次数N*(N-1)/2,交换次数N
 * 相比冒泡排序：在交换次数由N*(N-1)/2->N
 * 不变性：下标小于等于minIndex的数据有序不变
 */
public class SelectSort<T extends Comparable<T>> extends AbstractSort<T> {

    public SelectSort(T[] array) {
        super(array);
    }

    public T[] sort() {
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (isLess(j, minIndex)) {
                    minIndex = j;
                }
            }
            swap(i, minIndex);
        }
        return array;
    }
}
