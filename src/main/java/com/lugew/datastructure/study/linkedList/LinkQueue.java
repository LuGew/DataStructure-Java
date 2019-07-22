package com.lugew.datastructure.study.linkedList;

public class LinkQueue {
    private FirstLastList firstLastList;

    public LinkQueue() {
        firstLastList = new FirstLastList();
    }

    public boolean isEmpty() {
        return firstLastList.isEmpty();
    }

    public void insert(long value) {
        firstLastList.insertLast(value);
    }

    public long remove() {
        return firstLastList.deleteFirst();
    }

    public void displayQueue() {
        System.out.print("Queue (front-->rear): ");
        firstLastList.displayList();
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

    class FirstLastList {
        private Link first;
        private Link last;

        public FirstLastList() {
            first = null;
            last = null;
        }

        public boolean isEmpty() {
            return first == null;
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
    }
}

class LinkQueueApp {
    public static void main(String[] args) {
        LinkQueue linkQueue = new LinkQueue();
        linkQueue.insert(20);
        linkQueue.insert(40);
        linkQueue.displayQueue();

        linkQueue.insert(60);
        linkQueue.insert(80);
        linkQueue.displayQueue();

        linkQueue.remove();
        linkQueue.remove();

        linkQueue.displayQueue();
    }

}
