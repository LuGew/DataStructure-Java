package com.lugew.datastructure.java.array.study;

/**
 * 有序数组的实现
 * 对象数组见
 *
 * @see ClassDataArray
 */
public class OrderedArray {
    private long[] array;
    private int elements;

    public OrderedArray(int maxElements) {
        this.array = new long[maxElements];
        this.elements = 0;
    }

    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = elements - 1;
        int currentIndex = 0;

        while (lowerBound <= upperBound) {
            currentIndex = (lowerBound + upperBound) / 2;
            if (array[currentIndex] == searchKey) {
                return currentIndex;
            } else {
                if (array[currentIndex] > searchKey) {
                    upperBound = currentIndex - 1;
                } else {
                    lowerBound = currentIndex + 1;
                }
            }
        }
        return elements;
    }

    public void insert(long value) {
        int j;
        for (j = 0; j < elements; j++) {
            if (array[j] > value) {
                break;
            }
        }
        if (elements - j >= 0) System.arraycopy(array, j, array, j + 1, elements - j);
        array[j] = value;
        elements++;
    }

    public boolean delete(long value) {
        int index = find(value);
        if (index == elements) {
            return false;
        } else {
            for (int i = index; i < elements; i++) {
                array[index] = array[index + 1];
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

    public int size() {
        return elements;
    }

    public static void main(String[] args) {
        OrderedArray orderedArray = new OrderedArray(100);
        orderedArray.insert(77);
        orderedArray.insert(99);
        orderedArray.insert(44);
        orderedArray.insert(55);
        orderedArray.insert(22);
        orderedArray.insert(88);
        orderedArray.insert(11);
        orderedArray.insert(00);
        orderedArray.insert(66);
        orderedArray.insert(33);

        orderedArray.display();

        int searchKey = 55;
        if (orderedArray.find(searchKey) != orderedArray.size()) {
            System.out.println("Found " + searchKey);
        } else {
            System.out.println("Cant't find " + searchKey);
        }

        orderedArray.delete(00);
        orderedArray.delete(55);
        orderedArray.delete(99);

        orderedArray.display();
    }
}
