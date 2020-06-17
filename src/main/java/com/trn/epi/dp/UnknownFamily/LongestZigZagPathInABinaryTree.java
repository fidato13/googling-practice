package com.trn.epi.dp.UnknownFamily;

import com.trn.epi.utils.TreeNode;

/**
 * https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/
 *
 * Given a binary tree root, a ZigZag path for a binary tree is defined as follow:
 *
 * Choose any node in the binary tree and a direction (right or left).
 * If the current direction is right then move to the right child of the current node otherwise move to the left child.
 * Change the direction from right to left or right to left.
 * Repeat the second and third step until you can't move in the tree.
 * Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).
 *
 * Return the longest ZigZag path contained in that tree.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]
 * Output: 3
 * Explanation: Longest ZigZag path in blue nodes (right -> left -> right).
 * Example 2:
 *
 *
 *
 * Input: root = [1,1,1,null,1,null,null,1,1,null,1]
 * Output: 4
 * Explanation: Longest ZigZag path in blue nodes (left -> right -> left -> right).
 * Example 3:
 *
 * Input: root = [1]
 * Output: 0
 *
 *
 * Constraints:
 *
 * Each tree has at most 50000 nodes..
 * Each node's value is between [1, 100].
 */
public class LongestZigZagPathInABinaryTree {

    private static int global = Integer.MIN_VALUE;

    private static int longestZigZag(TreeNode<Integer> root) {

        if(root == null){
            return -1;
        }
        helper(root.right, 1,  true);
        helper(root.left, 1, false);
        return global;
    }

    // boolean rightDir = true, coming to this node as right child of it's parent
    // boolean rightDir = false, coming to this node as left child of it's parent
    private static void helper(TreeNode root, int step, boolean rightDir){
        if(root == null){
            return;
        }

        global = Math.max(global, step);

        // go right
        if(!rightDir){ // if this was a left child of it's parent then go right
            helper(root.right, step + 1, true);
            helper(root.left, 1, false);

        } else {
            // go left
            helper(root.left, step + 1, false);
            helper(root.right, 1, true);
        }


    }

    public static void main(String[] args) {

        TreeNode<Integer> node1 = new TreeNode<>(1);
        TreeNode<Integer> node2 = new TreeNode<>(2);
        TreeNode<Integer> node3 = new TreeNode<>(3);
        TreeNode<Integer> node4 = new TreeNode<>(4);
        TreeNode<Integer> node5 = new TreeNode<>(5);
        TreeNode<Integer> node6 = new TreeNode<>(6);
        TreeNode<Integer> node7 = new TreeNode<>(7);

        node1.left = node2;
        node1.right = node3;

        node2.right = node4;

        node4.left = node5;
        node4.right = node6;

        node5.right = node7;

        int result = longestZigZag(node1);

        System.out.println("The result : "+ result);


    }
}
