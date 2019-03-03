package com.lugew.datastructure.java.linktable.study;

public class LinkStack {

    private LinkList linkList;

    public LinkStack() {
        this.linkList = new LinkList();
    }

    public void push(long dd) {
        linkList.insertFirst(dd);

    }

    public long pop() {
        return linkList.deleteFirst();
    }

    public boolean isEmpty() {
        return linkList.isEmpty();
    }

    public void displayStack() {
        System.out.print("Stack (top-->bottom): ");
        linkList.displayList();
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

    class LinkList {
        private Link first;

        public LinkList() {
            this.first = null;
        }

        public boolean isEmpty() {
            return first == null;
        }

        public void insertFirst(long dd) {
            Link newLink = new Link(dd);
            newLink.next = first;
            first = newLink;
        }

        public long deleteFirst() {
            Link temp = first;
            first = first.next;
            return temp.dData;
        }

        public void displayList() {
            Link current = first;
            while (current != null) {
                current.displayLink();
                current = current.next;
            }
            System.out.println();
        }
    }
}

class LinkStackApp {
    public static void main(String[] args) {
        LinkStack linkStack = new LinkStack();
        linkStack.push(20);
        linkStack.push(40);

        linkStack.displayStack();

        linkStack.push(60);
        linkStack.push(80);

        linkStack.displayStack();

        linkStack.pop();
        linkStack.pop();

        linkStack.displayStack();


    }
}
