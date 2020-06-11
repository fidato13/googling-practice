package com.trn.epi.dp.UnknownFamily;

import com.trn.epi.utils.TreeNode;

/**
 * https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
 *
 * Given a binary tree root. Split the binary tree into two subtrees by removing 1 edge such that the product of the sums of the subtrees are maximized.
 *
 * Since the answer may be too large, return it modulo 10^9 + 7.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: root = [1,2,3,4,5,6]
 * Output: 110
 * Explanation: Remove the red edge and get 2 binary trees with sum 11 and 10. Their product is 110 (11*10)
 * Example 2:
 *
 *
 *
 * Input: root = [1,null,2,3,4,null,null,5,6]
 * Output: 90
 * Explanation:  Remove the red edge and get 2 binary trees with sum 15 and 6.Their product is 90 (15*6)
 * Example 3:
 *
 * Input: root = [2,3,9,10,7,8,6,5,4,11,1]
 * Output: 1025
 * Example 4:
 *
 * Input: root = [1,1]
 * Output: 1
 *
 *
 * Constraints:
 *
 * Each tree has at most 50000 nodes and at least 2 nodes.
 * Each node's value is between [1, 10000].
 */
public class MaxProductSplittedBinaryTree {

    private static long globalMax = 0L;
    private static long total = 0L;
    private static long sub = 0L;

    private static int maxProduct(TreeNode root) {
        total = getSum(root);
        getSum(root);
        return (int)(globalMax % (int)(1e9 + 7));
    }

    //get sum of tree rooted at this node
    private static long getSum(TreeNode root){
        if(root == null){
            return 0;
        }

        long left = getSum(root.left);
        long right = getSum(root.right);

        sub =  ( Long.valueOf(String.valueOf(root.val)) + left + right);
        globalMax = Math.max(globalMax, sub * (total - sub));

        return sub;
    }


    public static void main(String[] args) {

        TreeNode<Integer> node1 = new TreeNode<>(1);
        TreeNode<Integer> node2 = new TreeNode<>(2);
        TreeNode<Integer> node3 = new TreeNode<>(3);
        TreeNode<Integer> node4 = new TreeNode<>(4);
        TreeNode<Integer> node5 = new TreeNode<>(5);
        TreeNode<Integer> node6 = new TreeNode<>(6);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;

        int result = maxProduct(node1);

        System.out.println("The result : "+ result);

    }
}
