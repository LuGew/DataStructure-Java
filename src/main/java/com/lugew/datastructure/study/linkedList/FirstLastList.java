package com.lugew.datastructure.study.linkedList;

public class FirstLastList {
    private Link first;
    private Link last;

    public FirstLastList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(long dd) {
        Link newLink = new Link(dd);
        if (isEmpty()) {
            last = newLink;
        }
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(long dd) {
        Link newLink = new Link(dd);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;

        }
        last = newLink;
    }

    public long deleteFirst() {
        long temp = first.dData;
        if (first.next == null) {
            last = null;
        }
        first = first.next;
        return temp;
    }

    public void displayList() {
        System.out.print("Link (first-->last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }

    class Link {
        public long dData;
        public Link next;

        public Link(long dData) {
            this.dData = dData;
        }

        public void displayLink() {
            System.out.print(dData + " ");
        }
    }


}

class FirstLastApp {
    public static void main(String[] args) {
        FirstLastList firstLastList = new FirstLastList();
        firstLastList.insertFirst(22);
        firstLastList.insertFirst(44);
        firstLastList.insertFirst(66);
        firstLastList.insertLast(11);
        firstLastList.insertLast(33);
        firstLastList.insertLast(55);
        firstLastList.displayList();
        firstLastList.deleteFirst();
        firstLastList.deleteFirst();
        firstLastList.displayList();

    }
}


