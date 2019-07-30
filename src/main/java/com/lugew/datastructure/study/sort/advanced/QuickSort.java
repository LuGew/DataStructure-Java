package com.lugew.datastructure.study.sort.advanced;

import com.lugew.datastructure.study.sort.simple.AbstractSort;

/**
 * 快速排序
 * 复杂度分析：N*log(N)
 *
 * @author LuGew
 * @since 2019/7/30
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSort<T> {
    public T[] sort() {
        recursionSort(0, array.length - 1);
        return array;
    }

    private void recursionSort(int left, int right) {
        int size = right - left + 1;
        if (size < 10) {
            insertSort(left, right);
        } else {
            T median = medianOf3(left, right);
            int partition = partition(left, right, median);
            recursionSort(left, partition - 1);
            recursionSort(partition + 1, right);
        }
    }

    private int partition(int left, int right, T pivot) {
        int leftCursor = left;
        int rightCursor = right - 1;
        while (true) {
            while (array[++leftCursor].compareTo(pivot) < 0) {
                ;
            }
            while (array[--rightCursor].compareTo(pivot) > 0) {
                ;
            }
            if (leftCursor >= rightCursor) {
                break;
            } else {
                swap(leftCursor, rightCursor);
            }
        }
        swap(leftCursor, right - 1);
        return leftCursor;
    }

    private T medianOf3(int left, int right) {
        int media = (left + right) / 2;
        if (array[left].compareTo(array[media]) > 0) {
            swap(left, media);
        }
        if (array[left].compareTo(array[right]) > 0) {
            swap(left, right);
        }
        if (array[media].compareTo(array[right]) > 0) {
            swap(media, right);
        }

        swap(media, right - 1);
        return array[right - 1];
    }


    private void insertSort(int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            T temp = array[i];
            int index = i;
            while (index - left > 0 && array[index - 1].compareTo(temp) < 0) {
                array[index] = array[index - 1];
                index--;
            }
            array[index] = temp;
        }
    }
}
