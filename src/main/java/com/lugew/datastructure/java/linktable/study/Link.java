package com.lugew.datastructure.java.linktable.study;

public class Link {
    public int iData;
    public double dData;
    public Link next;

    public Link(int iData, double dData) {
        this.iData = iData;
        this.dData = dData;
    }

    public void displayLink() {
        System.out.print("{" + iData + "," + dData + "}");
    }

}

class LinkList {
    private Link first;

    public LinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(int d, double dd) {
        Link newLink = new Link(d, dd);
        newLink.next = first;
        first = newLink;
    }

    public Link deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void displayList() {
        System.out.print("List (first-->last):");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }

    public Link find(int key) {
        Link current = first;
        while (current.iData != key) {
            if (current.next == null) {
                return null;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    public Link delete(int key) {
        Link previous = first;
        Link current = first;
        while (current.iData != key) {
            if (current.next == null) {
                return null;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
        return current;
    }
}

class LinkListApp {
    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.insertFirst(22, 2.99);
        linkList.insertFirst(44, 4.99);
        linkList.insertFirst(66, 6.99);
        linkList.insertFirst(88, 8.99);
        linkList.displayList();
        while (!linkList.isEmpty()) {
            Link link = linkList.deleteFirst();
            link.displayLink();
            System.out.println();
        }
        linkList.displayList();
    }
}

class LinkListApp2 {
    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.insertFirst(22, 2.99);
        linkList.insertFirst(44, 4.99);
        linkList.insertFirst(66, 6.99);
        linkList.insertFirst(88, 8.99);
        linkList.displayList();
        Link f = linkList.find(44);
        if (f != null) {
            System.out.println("Found link with key " + f.iData);
        } else {
            System.out.println("Can't find link");
        }
        Link d = linkList.delete(66);
        if (d != null) {
            System.out.println("Delete link with key " + d.iData);
        } else {
            System.out.println("Can't delete link");
        }

        linkList.displayList();
    }
}
