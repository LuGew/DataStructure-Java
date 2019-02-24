package com.lugew.datastructure.java.array.study;

import java.util.HashSet;
import java.util.Set;

/**
 * 更高级的封装
 */
public class HighArray {
    private long[] array;
    private int elements;

    public HighArray(int maxElements) {
        this.array = new long[maxElements];
        this.elements = 0;
    }

    public boolean find(long searchKey) {
        int j;
        for (j = 0; j < elements; j++) {
            if (array[j] == searchKey) {
                break;
            }
        }
        if (j == elements) {
            return false;
        }
        return true;
    }

    public void insert(long value) {
        array[elements++] = value;
    }

    public boolean delete(long value) {
        int j;
        for (j = 0; j < elements; j++) {
            if (value == array[j]) {
                break;
            }
        }
        if (j == elements) {
            return false;
        } else {
            for (int i = j; i < elements; i++) {
                array[i] = array[i + 1];
            }
            elements--;
            return true;
        }
    }

    public void display() {
        for (int i = 0; i < elements; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

    }

    public long getMax() {
        if (elements == 0) {
            return -1;
        }
        long max = array[0];
        for (int i = 1; i < elements; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public int getMaxIndex() {
        if (elements == 0) {
            return -1;
        }
        int max = 0;
        for (int i = 1; i < elements; i++) {
            if (array[i] > array[max]) {
                max = i;
            }
        }
        return max;
    }

    public long removeMax() {
        int maxIndex = getMaxIndex();
        return deleteByIndex(maxIndex);
    }

    public long deleteByIndex(int index) {
        if (index >= 0 && index < elements) {
            long value = array[index];
            for (int i = index; i < elements - 1; i++) {
                array[i] = array[i + 1];
            }
            elements--;
            return value;
        } else {
            return -1;
        }
    }

    public void noDup() {
        Set<Long> set = new HashSet<Long>();
        for (int i = 0; i < elements; i++) {
            if (set.contains(array[i])) {
                deleteByIndex(i);
                i--;
            } else {
                set.add(array[i]);
            }
        }
    }

    public static void main(String[] args) {
        HighArray highArray = new HighArray(100);
        highArray.insert(77);
        highArray.insert(77);
        highArray.insert(77);
        highArray.insert(99);
        highArray.insert(44);
        highArray.insert(55);
        highArray.insert(22);
        highArray.insert(88);
        highArray.insert(11);
        highArray.insert(00);
        highArray.insert(66);
        highArray.insert(33);
        highArray.insert(33);
        highArray.insert(33);

        highArray.display();
        highArray.noDup();
        highArray.display();

        int searchKey = 55;
        if (highArray.find(searchKey)) {
            System.out.println("Found " + searchKey);
        } else {
            System.out.println("Cant't find " + searchKey);
        }

        highArray.delete(00);
        highArray.delete(55);
        highArray.delete(99);

        highArray.display();

        HighArray otherArray = new HighArray(highArray.elements);
        int length = highArray.elements;
        for (int i = 0; i < length; i++) {
            otherArray.insert(highArray.removeMax());
        }

        otherArray.display();
    }
}
