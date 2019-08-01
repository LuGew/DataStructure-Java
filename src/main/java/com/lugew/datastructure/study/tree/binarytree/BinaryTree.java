package com.lugew.datastructure.study.tree.binarytree;

import com.lugew.datastructure.util.Node;

/**
 * 二叉树
 * 复杂度分析:find:N*log(N);add:N*log(N);delete:N*log(N)
 *
 * @author LuGew
 * @since 2019/7/31
 */
public class BinaryTree<T extends Comparable<T>> extends AbstractTree<T> {
    private Node<T> root;

    @Override
    public Node<T> find(T element) {
        Node<T> current = root;
        while (current != null) {
            int flag = current.getData().compareTo(element);
            if (flag > 0) {
                current = current.getRightChild();
            } else if (flag < 0) {
                current = current.getLeftChild();
            } else {
                break;
            }
        }
        return current;
    }

    @Override
    public boolean add(T element) {
        Node<T> newNode = new TreeNode<>(element);
        if (isEmpty()) {
            root = newNode;
        } else {
            Node<T> current = root;
            Node<T> parent;
            while (true) {
                parent = current;
                int flag = current.getData().compareTo(element);
                if (flag < 0) {
                    current = current.getLeftChild();
                    if (current == null) {
                        parent.setLeftChild(newNode);
                    }
                } else {
                    current = current.getRightChild();
                    if (current == null) {
                        parent.setRightChild(newNode);
                    }
                }
            }
        }
        size++;
        return true;
    }

    @Override
    public boolean delete(T element) {
        Node<T> current = root;
        Node<T> parent = root;
        boolean isLeftChild = true;
        if (!isEmpty()) {
            int flag = current.getData().compareTo(element);
            while (flag != 0) {
                if (flag < 0) {
                    isLeftChild = true;
                    current = current.getLeftChild();
                } else {
                    isLeftChild = false;
                    current = current.getRightChild();
                }
                if (current == null) {
                    return false;
                }
            }
            if (current.getLeftChild() == null && current.getRightChild() == null) {
                if (current == root) {
                    root = null;
                } else if (isLeftChild) {
                    parent.setLeftChild(null);
                } else {
                    parent.setRightChild(null);
                }
            } else if (current.getRightChild() == null) {
                if (current == root) {
                    root = current.getLeftChild();
                } else if (isLeftChild) {
                    parent.setLeftChild(current.getLeftChild());
                } else {
                    parent.setRightChild(current.getLeftChild());
                }
            } else if (current.getLeftChild() == null) {
                if (current == root) {
                    root = current.getRightChild();
                } else if (isLeftChild) {
                    parent.setLeftChild(current.getRightChild());
                } else {
                    parent.setRightChild(current.getRightChild());
                }
            } else {
                Node<T> successor = getSuccessor(current);
                if (current == root) {
                    root = successor;
                } else if (isLeftChild) {
                    parent.setLeftChild(successor);
                } else {
                    parent.setRightChild(successor);
                }
                successor.setLeftChild(current.getLeftChild());
            }
        } else {
            return false;
        }
        return true;
    }

    private Node<T> getSuccessor(Node<T> deletedNode) {
        Node<T> successorParent = deletedNode;
        Node<T> successor = deletedNode;
        Node<T> current = deletedNode.getRightChild();
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }
        if (successorParent != deletedNode.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(deletedNode.getRightChild());
        }
        return successor;
    }

    @Override
    public void inorderTraversal(Node<T> root) {
        if (root != null) {
            inorderTraversal(root.getLeftChild());
            System.out.println(root.getData().toString() + " ");
            inorderTraversal(root.getRightChild());
        }
    }

    @Override
    public void postorderTraversal(Node<T> root) {
        if (root != null) {
            postorderTraversal(root.getLeftChild());
            postorderTraversal(root.getRightChild());
            System.out.println(root.getData().toString() + " ");
        }
    }

    @Override
    public void preorderTraversal(Node<T> root) {
        System.out.println(root.getData().toString() + " ");
        preorderTraversal(root.getLeftChild());
        preorderTraversal(root.getRightChild());
    }

    public Node<T> mininum() {
        Node<T> current = root, minium = root;
        while (current != null) {
            minium = current;
            current = current.getLeftChild();
        }
        return minium;
    }

    public Node<T> maximum() {
        Node<T> current = root, maximum = root;
        while (current != null) {
            maximum = current;
            current = current.getRightChild();
        }
        return maximum;
    }

    @Override
    public void display() {

    }

    private class TreeNode<T extends Comparable<T>> implements Node<T> {

        private T data;
        private Node<T> leftChild;
        private Node<T> rightChild;

        private TreeNode(T data) {
            this.data = data;
        }

        public void display() {

        }

        @Override
        public T getData() {
            return data;
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
            return this.leftChild = node;
        }

        @Override
        public Node<T> setRightChild(Node<T> node) {
            return this.rightChild = node;
        }
    }
}
