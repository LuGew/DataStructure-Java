package com.lugew.datastructure.study.sort.simple;

/**
 * 时间复杂度O(N^2)
 * 比较次数N*(N-1)/2,交换次数N*(N-1)/2
 * <p>
 * 不变性：下标大于等于elements-i-1的数据有序不变
 */
public class BubbleSort {
    private long[] array;
    private int elements;

    public BubbleSort(int size) {
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
            for (int j = 0; j < elements - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(j, j + 1);
                }
            }
        }
    }

    public int oddEvenSort() {
        int cycleCount = 0;
        boolean flag = false;
        while (!flag) {
            flag = true;
            for (int i = 1; i + 1 < elements; i += 2) {
                if (array[i] > array[i + 1]) {
                    flag = false;
                    swap(i, i + 1);
                }
            }
            for (int i = 0; i + 1 < elements; i += 2) {
                if (array[i] > array[i + 1]) {
                    flag = false;
                    swap(i, i + 1);
                }
            }
            cycleCount++;
        }
        return cycleCount;
    }

    public void sortTwo() {
        int left = 0;
        int right = elements - 1;
        int i = 0;
        while (left < right) {
            if (i++ % 2 == 0) {
                for (int j = 0; j < right; j++) {
                    if (array[j] > array[j + 1]) {
                        swap(j, j + 1);
                    }
                }
                right--;
            } else {
                for (int j = right; j > left; j--) {
                    if (array[j] < array[j - 1]) {
                        swap(j, j - 1);
                    }
                }
                left++;
            }
        }
    }

    private void swap(int j, int i) {
        long temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static void main(String[] args) {
        //int max = 100000;
        int max = 10;
        BubbleSort bubbleSort = new BubbleSort(max);
       /*  SelectSort selectSort = new SelectSort(max);
        InsertSort insertSort = new InsertSort(max);
        for (int i = 0; i < max; i++) {
//            long n = (long) (Math.random() * (max - 1));
//            long n = i;
            long n = max - i - 1;
            bubbleSort.insert(n);
            selectSort.insert(n);
            insertSort.insert(n);
        }*/

        bubbleSort.insert(77);
        bubbleSort.insert(99);
        bubbleSort.insert(44);
        bubbleSort.insert(55);
        bubbleSort.insert(22);
        bubbleSort.insert(88);
        bubbleSort.insert(11);
        bubbleSort.insert(00);
        bubbleSort.insert(66);
        bubbleSort.insert(33);
        bubbleSort.display();
//        bubbleSort.sortTwo();
        System.out.println(bubbleSort.oddEvenSort());

        bubbleSort.display();
        /*long start = System.currentTimeMillis();
        bubbleSort.sort();
        long end = System.currentTimeMillis();
        System.out.println("Bubble Sort: " + (end - start) + "ms");


        start = System.currentTimeMillis();
        selectSort.sort();
        end = System.currentTimeMillis();
        System.out.println("Select Sort: " + (end - start) + "ms");


        start = System.currentTimeMillis();
        insertSort.sort();
        end = System.currentTimeMillis();
        System.out.println("Insert Sort: " + (end - start) + "ms");
*/

    }
}
