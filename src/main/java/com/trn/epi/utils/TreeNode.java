package com.trn.epi.utils;

/**
 * This represents a tree node
 */
public class TreeNode<T> {
    // value of the node
    public T val;

    // left child
    public TreeNode<T> left;

    // right child
    public TreeNode<T> right;

    // Constructor
    public TreeNode(T val) {
        this.val = val;
    }

    // Constructor
    public TreeNode(T val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
