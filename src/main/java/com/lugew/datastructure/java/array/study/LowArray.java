package com.lugew.datastructure.java.array.study;

/**
 * 提供了数组应用较低级封装，在HighArray中还会看到较高级的封装
 *
 * @see HighArray
 */
public class LowArray {
    private long[] array;

    public LowArray() {
    }

    public LowArray(int size) {
        this.array = new long[size];
    }

    public void setElement(int index, long value) {
        array[index] = value;
    }

    public long getElement(int index) {
        return array[index];
    }

    public static void main(String[] args) {
        LowArray lowArray = new LowArray(100);
        int currentElements = 0;
        int j = 0;
        lowArray.setElement(0, 77);
        lowArray.setElement(1, 99);
        lowArray.setElement(2, 44);
        lowArray.setElement(3, 55);
        lowArray.setElement(4, 22);
        lowArray.setElement(5, 88);
        lowArray.setElement(6, 11);
        lowArray.setElement(7, 00);
        lowArray.setElement(8, 66);
        lowArray.setElement(9, 33);
        currentElements = 10;
        for (int i = 0; i < currentElements; i++) {
            System.out.print(lowArray.getElement(i) + " ");
        }
        System.out.println();
        int searchKey = 26;
        for (j = 0; j < currentElements; j++) {
            if (lowArray.getElement(j) == searchKey) {
                break;
            }
        }
        if (j == currentElements) {
            System.out.println("Can't find " + searchKey);
        } else {
            System.out.println("Found " + searchKey);
        }
        searchKey = 55;
        for (j = 0; j < currentElements; j++) {
            if (lowArray.getElement(j) == searchKey) {
                break;
            }
        }
        for (int i = j; i < currentElements; i++) {
            lowArray.setElement(i, lowArray.getElement(i + 1));
        }
        currentElements--;
        for (int i = 0; i < currentElements; i++) {
            System.out.print(lowArray.getElement(i) + " ");
        }
        System.out.println(" ");
    }
}
