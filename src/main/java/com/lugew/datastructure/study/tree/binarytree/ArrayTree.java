package com.lugew.datastructure.study.tree.binarytree;


import com.lugew.datastructure.util.Node;

/**
 * 数组实现的二叉树
 * find:log(N);add:log(N);delete:(N);
 *
 * @author LuGew
 * @since 2019/8/5
 */
public class ArrayTree<T extends Comparable<T>> extends AbstractTree<T> {
    private Node<T>[] nodes;
    private int length = nodes.length;

    @Override
    public Node<T> find(T element) {
        int index = 0;
        Node<T> current = nodes[0];

        while (current != null) {
            int flag = current.getData().compareTo(element);
            if (flag > 0) {
                index = 2 * index + 2;
                if (index >= length) {
                    break;
                } else {
                    current = nodes[index];
                }
            } else if (flag < 0) {
                index = 2 * index + 1;
                if (index >= length) {
                    return null;
                } else {
                    current = nodes[index];
                }
            } else {
                return null;
            }
        }
        return current;
    }

    @Override
    public boolean add(T element) {
        int index = 0;
        Node<T> current = nodes[index];
        while (current != null) {
            int flag = current.getData().compareTo(element);
            if (flag > 0) {
                index = index * 2 + 2;
                if (index >= length) {
                    return false;
                }
                current = nodes[index];
            } else {
                index = index * 2 + 1;
                if (index >= length) {
                    return false;
                }
                current = nodes[index];
            }
        }
        nodes[index] = new ArrayNode<>(element);
        size++;
        return true;
    }

    @Override
    public boolean delete(T element) {
        return false;
    }

    @Override
    public void inorderTraversal(com.lugew.datastructure.util.Node<T> node) {

    }

    @Override
    public void postorderTraversal(com.lugew.datastructure.util.Node<T> node) {

    }

    @Override
    public void preorderTraversal(com.lugew.datastructure.util.Node<T> node) {

    }


    @Override
    public void display() {

    }

    private class ArrayNode<T extends Comparable<T>> implements Node<T> {
        private T data;

        public ArrayNode() {
        }

        public ArrayNode(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        @Override
        public Node<T> getLeftChild() {
            return null;
        }

        @Override
        public Node<T> getRightChild() {
            return null;
        }

        @Override
        public Node<T> setLeftChild(Node<T> node) {
            return null;
        }

        @Override
        public Node<T> setRightChild(Node<T> node) {
            return null;
        }

        public void setData(T data) {
            this.data = data;
        }

        @Override
        public void display() {

        }
    }

}
