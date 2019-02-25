package com.lugew.datastructure.java.simplesort.study;

/**
 * 稳定性：当根据多个关键字进行排序时，只对需要排序的数据进行排序，让不需要排序的数据保持原来的顺序
 *
 * @param <T>
 */
public class ObjectSort<T extends Comparable<T>> {
    private T[] array;
    private int elements;

    public ObjectSort(int size) {
        this.array = (T[]) new Comparable[size];
        this.elements = 0;
    }

    public void insert(T value) {
        array[elements++] = value;
    }

    public void display() {
        for (int i = 0; i < elements; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void sort() {
        for (int i = 1; i < elements; i++) {
            T currentValue = array[i];
            int currentIndex = i;
            while (currentIndex - 1 >= 0 && array[currentIndex - 1].compareTo(currentValue) > 0) {
                array[currentIndex] = array[currentIndex - 1];
                currentIndex--;
            }
            array[currentIndex] = currentValue;
        }
    }

    public static void main(String[] args) {
        ObjectSort<Integer> objectSort = new ObjectSort<Integer>(20);
        objectSort.insert(77);
        objectSort.insert(99);
        objectSort.insert(44);
        objectSort.insert(55);
        objectSort.insert(22);
        objectSort.insert(88);
        objectSort.insert(11);
        objectSort.insert(00);
        objectSort.insert(66);
        objectSort.insert(33);
        objectSort.display();
        objectSort.sort();
        objectSort.display();
    }
}
