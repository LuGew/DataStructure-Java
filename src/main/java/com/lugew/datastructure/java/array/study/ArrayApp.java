package com.lugew.datastructure.java.array.study;

/**
 * 面向过程的数组应用，接下来会将这段程序划分成类。
 *
 * @see LowArray
 */
public class ArrayApp {
    public static void main(String[] args) {
        long[] array;
        array = new long[100];
        int currentElements;
        int i;
        long searchKey;
        array[0] = 77;
        array[1] = 99;
        array[2] = 44;
        array[3] = 55;
        array[4] = 22;
        array[5] = 88;
        array[6] = 11;
        array[7] = 00;
        array[8] = 66;
        array[9] = 33;
        currentElements = 10;
        for (i = 0; i < currentElements; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println(" ");
        searchKey = 66;
        int j;
        for (j = 0; j < currentElements; j++) {
            if (array[j] == searchKey) {
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
            if (array[j] == searchKey) {
                break;
            }
        }

        for (int k = j; k < currentElements; k++) {
            array[k] = array[k + 1];
        }
        currentElements--;
        for (int k = 0; k < currentElements; k++) {
            System.out.print(array[k] + " ");
        }
        System.out.println(" ");


    }
}
