package com.lugew.datastructure.study.sort.simple;

/**
 * 时间复杂度O(N^2)
 * 比较次数N*(N-1)/4,复制次数N*(N-1)/4
 * <p>
 * 不变性：下标小于i的数据有序不变
 * 对于有序数组有巨大的优势，可由O(N^2)->O(N)
 */
public class InsertSort<T extends Comparable<T>> extends AbstractSort<T> {

    public InsertSort(T[] array) {
        super(array);
    }

    public T[] sort() {
        for (int i = 1; i < size; i++) {
            T currentValue = array[i];
            int currentIndex = i;
            while (currentIndex - 1 >= 0) {
                if (array[currentIndex - 1].compareTo(currentValue) > 0) {
                    array[currentIndex] = array[currentIndex - 1];
                    currentIndex--;
                } else {
                    break;
                }
            }
            array[currentIndex] = currentValue;
        }
        return array;
    }
}
