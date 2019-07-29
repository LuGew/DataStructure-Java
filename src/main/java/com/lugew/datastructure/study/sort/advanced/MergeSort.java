package com.lugew.datastructure.study.sort.advanced;

import com.lugew.datastructure.study.sort.simple.AbstractSort;

/**
 * 归并排序
 * 复杂度分析:N*log(N)
 *
 * @author LuGew
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSort<T> {
    @Override
    public T[] sort() {
        T[] workSpace = (T[]) new Object[array.length];
        mergeSort(workSpace, 0, array.length - 1);
        return null;
    }

    private void mergeSort(T[] workSpace, int lowerBound, int upperBound) {
        if (lowerBound == upperBound) {
            return;
        } else {
            int middle = (lowerBound + upperBound) / 2;
            mergeSort(workSpace, lowerBound, middle);
            mergeSort(workSpace, middle + 1, upperBound);
            merge(workSpace, lowerBound, middle + 1, upperBound);
        }
    }

    private void merge(T[] workSpace, int lowerBound, int middle, int upperBound) {
        int j = 0;
        int lower = lowerBound;
        int mid = middle - 1;
        int n = upperBound - lowerBound + 1;
        while (lower <= mid && middle <= upperBound) {
            if (array[lower].compareTo(array[middle]) < 0) {
                workSpace[j++] = array[lower++];
            } else {
                workSpace[j++] = array[middle++];
            }
        }

        while (lower <= mid) {
            workSpace[j++] = array[lower++];
        }

        while (middle <= upperBound) {
            workSpace[j++] = array[middle++];
        }

        for (int i = 0; i < n; i++) {
            array[lowerBound + i] = workSpace[i];
        }

    }
}
