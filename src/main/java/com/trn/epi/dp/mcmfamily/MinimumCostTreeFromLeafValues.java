package com.trn.epi.dp.mcmfamily;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/
 *
 * Given an array arr of positive integers, consider all binary trees such that:
 *
 * Each node has either 0 or 2 children;
 * The values of arr correspond to the values of each leaf in an in-order traversal of the tree.  (Recall that a node is a leaf if and only if it has 0 children.)
 * The value of each non-leaf node is equal to the product of the largest leaf value in its left and right subtree respectively.
 * Among all possible binary trees considered, return the smallest possible sum of the values of each non-leaf node.  It is guaranteed this sum fits into a 32-bit integer.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [6,2,4]
 * Output: 32
 * Explanation:
 * There are two possible trees.  The first has non-leaf node sum 36, and the second has non-leaf node sum 32.
 *
 *     24            24
 *    /  \          /  \
 *   12   4        6    8
 *  /  \               / \
 * 6    2             2   4
 *
 *
 * Constraints:
 *
 * 2 <= arr.length <= 40
 * 1 <= arr[i] <= 15
 * It is guaranteed that the answer fits into a 32-bit signed integer (ie. it is less than 2^31).
 */
public class MinimumCostTreeFromLeafValues {

    private static int[][] dp;

    private static int mctFromLeafValues(int[] arr) {
        dp = new int[arr.length + 1][arr.length + 1];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return helper(arr, 0, arr.length - 1);
    }

    private static int helper(int[] arr, int i , int j){
        if(i >= j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;
        for(int k = i; k < j; k++){
            int leftMax = Integer.MIN_VALUE;
            for(int a = i; a <= k; a++){
                leftMax = Math.max(leftMax, arr[a]);
            }

            int rightMax = Integer.MIN_VALUE;
            for(int a = k + 1; a <= j; a++){
                rightMax = Math.max(rightMax, arr[a]);
            }
            int temp = helper(arr, i , k) + (leftMax * rightMax) + helper(arr, k + 1 , j);

            if(temp < min){
                min = temp;
            }
        }


        return dp[i][j] = min;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6,2,4};

        int result = mctFromLeafValues(arr);

        System.out.println("The result : "+ result);
    }
}
