package com.lugew.datastructure.study.sort.simple;

/**
 * 时间复杂度O(N^2)
 * 比较次数N*(N-1)/2,交换次数N*(N-1)/2
 * <p>
 * 不变性：下标大于等于elements-i-1的数据有序不变
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSort<T> {

    public BubbleSort(T[] array) {
        super(array);
    }

    public int oddEvenSort() {
        int cycleCount = 0;
        boolean flag = false;
        while (!flag) {
            flag = true;
            for (int i = 1; i + 1 < size; i += 2) {
                if (isBigger(i, i + 1)) {
                    flag = false;
                    swap(i, i + 1);
                }
            }
            for (int i = 0; i + 1 < size; i += 2) {
                if (isBigger(i, i + 1)) {
                    flag = false;
                    swap(i, i + 1);
                }
            }
            cycleCount++;
        }
        return cycleCount;
    }

    public void sortTwo() {
        int left = 0;
        int right = size - 1;
        int i = 0;
        while (left < right) {
            if (i++ % 2 == 0) {
                for (int j = 0; j < right; j++) {
                    if (isBigger(j, j + 1)) {
                        swap(j, j + 1);
                    }
                }
                right--;
            } else {
                for (int j = right; j > left; j--) {
                    if (isBigger(j, j + 1)) {
                        swap(j, j - 1);
                    }
                }
                left++;
            }
        }
    }

    public T[] sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (isBigger(j, j + 1)) {
                    swap(j, j + 1);
                }
            }
        }
        return array;
    }
}
