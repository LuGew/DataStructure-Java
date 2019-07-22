package com.lugew.datastructure.study.sort.simple;

/**
 * 时间复杂度O(N^2)
 * 比较次数N*(N-1)/2,交换次数N
 * 相比冒泡排序：在交换次数由N*(N-1)/2->N
 * 不变性：下标小于等于minIndex的数据有序不变
 */
public class SelectSort {
    private long[] array;
    private int elements;

    public SelectSort(int size) {
        this.array = new long[size];
        this.elements = 0;
    }

    public void insert(long value) {
        array[elements++] = value;
    }

    public void display() {
        for (int i = 0; i < elements; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void sort() {
        for (int i = 0; i < elements - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < elements; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(i, minIndex);

        }
    }

    private void swap(int j, int i) {
        long temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort(20);
        selectSort.insert(77);
        selectSort.insert(99);
        selectSort.insert(44);
        selectSort.insert(55);
        selectSort.insert(22);
        selectSort.insert(88);
        selectSort.insert(11);
        selectSort.insert(00);
        selectSort.insert(66);
        selectSort.insert(33);
        selectSort.display();
        selectSort.sort();
        selectSort.display();
    }

}
