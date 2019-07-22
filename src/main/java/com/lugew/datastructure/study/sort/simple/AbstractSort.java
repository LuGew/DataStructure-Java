package com.lugew.datastructure.study.sort.simple;

/**
 * 排序抽象类
 *
 * @author LuGew
 */
public abstract class AbstractSort<T extends Comparable<T>> implements Sort<T> {
    protected T[] array;
    protected int size;

    public AbstractSort() {
    }

    public AbstractSort(T[] array) {
        this.array = array;
        this.size = array.length;
    }

    protected void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    protected void swap(int j, int i) {
        T temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    protected boolean isBigger(int i, int j) {
        return array[i].compareTo(array[j]) > 0;
    }

    protected boolean isLess(int i, int j) {
        return array[i].compareTo(array[j]) < 0;
    }
}
