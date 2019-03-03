package com.lugew.datastructure.java.linktable.study;

public class ListInsertionSort {
    static class Link {
        public long dData;
        public Link next;

        public Link(long dData) {
            this.dData = dData;
        }
    }

    static class SortedList {
        private Link first;

        public SortedList() {
            first = null;
        }

        public SortedList(Link[] links) {
            this.first = null;
            for (int i = 0; i < links.length; i++) {
                insert(links[i]);
            }
        }

        public boolean isEmpty() {
            return first == null;
        }

        public void insert(Link key) {

            Link previous = null;
            Link current = first;
            while (current != null && key.dData > current.dData) {
                previous = current;
                current = current.next;
            }
            if (previous == null) {
                first = key;
            } else {
                previous.next = key;
            }

            key.next = current;
        }

        public Link remove() {
            Link temp = first;
            first = first.next;
            return temp;
        }
    }

    public static void main(String[] args) {
        int size = 10;
        Link[] linkArray = new Link[size];
        for (int i = 0; i < size; i++) {
            int n = (int) (Math.random() * 99);
            Link newLink = new Link(n);
            linkArray[i] = newLink;
        }
        System.out.print("Unsorted array：");
        for (int i = 0; i < size; i++) {
            System.out.print(linkArray[i].dData + " ");
        }
        System.out.println();

        SortedList sortedList = new SortedList(linkArray);

        for (int i = 0; i < size; i++) {
            linkArray[i] = sortedList.remove();
        }
        System.out.print("Sorted Array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(linkArray[i].dData + " ");
        }
        System.out.println();
    }
}


