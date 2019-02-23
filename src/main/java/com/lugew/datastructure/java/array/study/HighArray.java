package com.lugew.datastructure.java.array.study;

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

    public static void main(String[] args) {
        HighArray highArray = new HighArray(100);
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

    }
}
