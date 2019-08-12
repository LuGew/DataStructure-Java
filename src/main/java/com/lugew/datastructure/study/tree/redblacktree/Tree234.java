package com.lugew.datastructure.study.tree.redblacktree;

import com.lugew.datastructure.util.Display;

/**
 * 234Tree
 * 234树
 *
 * @author LuGew
 */
public class Tree234<T extends Comparable<T>> implements Display {
    private Node<T> root;

    public int find(T data) {
        Node<T> currentNode = root;
        int childNumber;
        while (true) {
            if ((childNumber = currentNode.find(data)) != -1) {
                return childNumber;
            } else if (currentNode.isLeaf()) {
                return -1;
            } else {
                currentNode = getNextChild(currentNode, data);
            }
        }
    }


    public boolean insert(T data) {
        Node<T> currentNode = root;
        while (true) {
            if (currentNode.isFull()) {
                split(currentNode);
                currentNode = currentNode.getParent();
                currentNode = getNextChild(currentNode, data);
            } else if (currentNode.isLeaf()) {
                break;
            } else {
                currentNode = getNextChild(currentNode, data);
            }

        }
        currentNode.insert(data);
        return true;
    }

    private void split(Node<T> currentNode) {
        T b, c;
        Node<T> parent, child2, child3;
        int index;
        c = currentNode.remove();
        b = currentNode.remove();
        child2 = currentNode.disconnect(2);
        child3 = currentNode.disconnect(3);
        Node<T> newRight = new Node<>();
        if (currentNode == root) {
            root = new Node<>();
            parent = root;
            root.connect(0, currentNode);
        } else {
            parent = currentNode.getParent();
        }
        index = parent.insert(b);
        int size = parent.getSize();
        for (int i = size - 1; i > index; i++) {
            Node<T> temp = parent.disconnect(i);
            parent.connect(i + 1, temp);
        }
        parent.connect(index + 1, newRight);
        newRight.insert(c);
        newRight.connect(0, child2);
        newRight.connect(1, child3);
    }

    private Node<T> getNextChild(Node<T> currentNode, T data) {
        int index;
        int size = currentNode.getSize();
        for (index = 0; index < size; index++) {
            if (currentNode.getData(index).compareTo(data) > 0) {
                return currentNode.getChild(index);
            }
        }
        return currentNode.getChild(index);
    }

    @Override
    public void display() {

    }


    class Node<T extends Comparable<T>> implements Display {
        private static final int ORDER = 4;
        private int size;
        private Node<T> parent;
        private Node<T>[] children = new Node[ORDER];
        private T[] data = (T[]) new Object[ORDER - 1];

        public void connect(int childNumber, Node<T> child) {
            children[childNumber] = child;
            if (child != null) {
                child.parent = this;
            }
        }

        public Node<T> disconnect(int childNumber) {
            Node<T> child = children[childNumber];
            children[childNumber] = null;
            return child;
        }

        public Node<T> getChild(int childNumber) {
            return children[childNumber];
        }

        public Node<T> getParent() {
            return parent;
        }

        public boolean isLeaf() {
            return children[0] == null;
        }

        public int getSize() {
            return size;
        }

        public T getData(int index) {
            return data[index];
        }

        public boolean isFull() {
            return size == ORDER - 1;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int find(T data) {
            for (int i = 0; i < size; i++) {
                if (this.data[i].equals(data)) {
                    return i;
                }
            }
            return -1;
        }

        public int insert(T data) {
            int index = size - 1;

            while (index >= 1 && this.data[index - 1].compareTo(data) > 0) {
                this.data[index] = this.data[index - 1];
                index--;
            }
            if (index < 0) {
                index = 0;
            }
            this.data[index] = data;
            return index;
        }

        public T remove() {
            if (!isEmpty()) {
                T data = this.data[size - 1];
                this.data[--size] = null;
                return data;
            }
            return null;
        }


        @Override
        public void display() {

        }
    }
}
