package com.lugew.datastructure.study.sort.advanced;

import com.lugew.datastructure.study.sort.simple.AbstractSort;

/**
 * 希尔排序
 * 复杂度分析:上界N7/6,下界N*log(N)2
 *
 * @author LuGew
 */
public class ShellSort<T extends Comparable<T>> extends AbstractSort<T> {
    @Override
    public T[] sort() {

        int index = getKnuthSequence(size);
        while (index > 0) {
            for (int i = index; i < size; i++) {
                T temp = array[i];
                int j = i;
                while (j > index - 1 && array[j - index].compareTo(temp) > 0) {
                    array[j] = array[j - index];
                    j -= index;
                }
                array[j] = temp;
            }
            index = (index - 1) / 3;
        }
        return array;
    }

    private int getKnuthSequence(int size) {
        int index = 1;
        while (index <= size / 3) {
            index = index * 3 + 1;
        }
        return index;
    }
}
