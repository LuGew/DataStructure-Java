package com.lugew.datastructure.study.sort.advanced;

import com.lugew.datastructure.util.Display;

/**
 * 划分是快速排序的基础
 *
 * @author LuGew
 */
public class Partition<T extends Comparable<T>> implements Display {
    private T[] array;

    public int partition(int left, int right, T pivot) {
        int leftCursor = left - 1;
        int rightCursor = right + 1;
        while (true) {
            while (leftCursor < right && array[++leftCursor].compareTo(pivot) < 0) {

            }
            while (rightCursor > left && array[--rightCursor].compareTo(pivot) > 0) {

            }
            if (leftCursor > rightCursor) {
                break;
            } else {
                swap(leftCursor, rightCursor);
            }
        }
        return leftCursor;
    }

    private void swap(int leftCursor, int rightCursor) {
        T temp = array[leftCursor];
        array[leftCursor] = array[rightCursor];
        array[rightCursor] = temp;
    }

    @Override
    public void display() {

    }
}
