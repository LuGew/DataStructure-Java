package com.lugew.datastructure.study.sort.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * 时间复杂度O(N^2)
 * 比较次数N*(N-1)/4,复制次数N*(N-1)/4
 * <p>
 * 不变性：下标小于i的数据有序不变
 * 对于有序数组有巨大的优势，可由O(N^2)->O(N)
 */
public class InsertSort {
    private long[] array;
    private int elements;

    public InsertSort(long[] array) {
        this.array = array;
        elements = array.length;
    }

    public InsertSort(int size) {
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
        int countOne = 0;
        int countTwo = 0;
        for (int i = 1; i < elements; i++) {
            long currentValue = array[i];
            int currentIndex = i;
            while (currentIndex - 1 >= 0) {
                if (array[currentIndex - 1] > currentValue) {
                    array[currentIndex] = array[currentIndex - 1];
                    currentIndex--;
                    countTwo++;
                    countOne++;
                } else {
                    countOne++;
                    break;
                }
            }
            array[currentIndex] = currentValue;
        }
        System.out.println("比较：" + countOne + " 复制：" + countTwo);
    }

    public void noDups() {
        Set<Long> set = new HashSet<Long>(elements);
        int length = 0;
        for (int i = 0; i < elements; i++) {
            if (!set.contains(array[i])) {
                set.add(array[i]);
                array[length++] = array[i];
            }
        }
        elements = length;
    }

    public long median() {
        long[] tempArray = array.clone();
        int length = tempArray.length;
        for (int i = 1; i < length; i++) {
            long currentValue = tempArray[i];
            int currentIndex = i;
            while (currentIndex - 1 >= 0 && tempArray[currentIndex - 1] > currentValue) {
                tempArray[currentIndex] = tempArray[currentIndex - 1];
                currentIndex--;
            }
            tempArray[currentIndex] = currentValue;
        }
        return tempArray[tempArray.length / 2];
    }

    public static void main(String[] args) {
        /*InsertSort insertSort = new InsertSort(12);
        insertSort.insert(77);
        insertSort.insert(99);
        insertSort.insert(99);
        insertSort.insert(44);
        insertSort.insert(55);
        insertSort.insert(22);
        insertSort.insert(88);
        insertSort.insert(11);
        insertSort.insert(00);
        insertSort.insert(66);
        insertSort.insert(33);
        insertSort.insert(33);

        insertSort.display();
        insertSort.sort();
        insertSort.display();
        System.out.println(insertSort.median());

        insertSort.noDups();
        insertSort.display();*/
        int max = 10000;
        InsertSort insertSort = new InsertSort(max);
        for (int i = 0; i < max; i++) {
//            long n = (long) (Math.random() * (max - 1));
            long n = max - i - 1;
            insertSort.insert(n);
        }

        insertSort.sort();


    }
}
