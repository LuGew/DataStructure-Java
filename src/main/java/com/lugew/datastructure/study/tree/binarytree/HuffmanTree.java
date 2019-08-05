package com.lugew.datastructure.study.tree.binarytree;

import com.lugew.datastructure.util.Node;

/**
 * huffman树
 * 文本压缩
 *
 * @author LuGew
 * @since 2019/8/5
 */
public class HuffmanTree<T extends Comparable<T>> extends AbstractTree<T> {
    private HuffmanNode<T> root;

    public HuffmanTree() {
    }

    public HuffmanTree(String text) {
        /*Map<Character, HuffmanNode<Character>> map = new HashMap<>();
        PriorityQueue<HuffmanNode<Character>> priorityQueue = new PriorityQueue<>(256);
        for (int i = 0, length = text.length(); i < length; i++) {
            Character c = text.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new HuffmanNode<>(c, 1));
            }
            HuffmanNode<Character> node = map.get(c);
            node.setFrequency(node.getFrequency() + 1);
        }
        */

    }

    public HuffmanTree<T> combine(HuffmanTree<T> ht1, HuffmanTree<T> ht2) {
        if (ht1.root.getFrequency() > ht2.root.getFrequency()) {
            HuffmanTree<T> temp = ht1;
            ht1 = ht2;
            ht2 = temp;
        }
        HuffmanTree<T> huffmanTree = new HuffmanTree<>();
        HuffmanNode<T> root = new HuffmanNode<>();
        root.setLeftChild(ht1.root);
        root.setRightChild(ht2.root);
        root.setFrequency(ht1.root.getFrequency() + ht2.root.getFrequency());
        huffmanTree.root = root;
        return huffmanTree;
    }

    @Override
    public Node<T> find(T element) {
        return null;
    }

    @Override
    public boolean add(T element) {
        return false;
    }

    @Override
    public boolean delete(T element) {
        return false;
    }

    @Override
    public void inorderTraversal(Node<T> node) {

    }

    @Override
    public void postorderTraversal(Node<T> node) {

    }

    @Override
    public void preorderTraversal(Node<T> node) {

    }

    @Override
    public void display() {

    }

    private class HuffmanNode<T extends Comparable<T>> implements Node<T>, Comparable<HuffmanNode<T>> {
        private T data;
        private int frequency;
        private Node<T> leftChild;
        private Node<T> rightChild;

        @Override
        public T getData() {
            return data;
        }

        public HuffmanNode() {
        }

        public HuffmanNode(T data, int frequency) {
            this.data = data;
            this.frequency = frequency;
        }

        public void setData(T data) {
            this.data = data;
        }

        public int getFrequency() {
            return frequency;
        }

        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }

        @Override
        public Node<T> getLeftChild() {
            return leftChild;
        }

        @Override
        public Node<T> getRightChild() {
            return rightChild;
        }

        @Override
        public Node<T> setLeftChild(Node<T> node) {
            return leftChild = node;
        }

        @Override
        public Node<T> setRightChild(Node<T> node) {
            return rightChild = node;
        }

        @Override
        public void display() {

        }

        @Override
        public int compareTo(HuffmanNode<T> o) {
            return this.data.compareTo(o.getData());
        }
    }

}
