package com.trn.epi.dp.mcmfamily;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/burst-balloons/
 *
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 *
 * Find the maximum coins you can collect by bursting the balloons wisely.
 *
 * Note:
 *
 * You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * Example:
 *
 * Input: [3,1,5,8]
 * Output: 167
 * Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *              coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */
public class BurstBalloons {

    private static int[][]dp;

    private static int maxCoins(int[] inums) {

        int[] nums = new int[inums.length + 2];
        int n = 1;
        for (int x : inums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;

        dp = new int[nums.length + 1][nums.length + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return helper(nums, 0, nums.length - 1);
    }

    private static int helper(int[] nums, int i, int j){
        if(i + 1 == j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int max = Integer.MIN_VALUE;
        for(int k = i + 1; k < j; k++){
            int temp = helper(nums, i, k) + nums[i] * nums[k] * nums[j] + helper(nums, k, j);

            max = Math.max(max, temp);
        }

        return dp[i][j] = max;

    }

    public static void main(String[] args) {

        int[] nums = new int[]{3,1,5,8};

        int result = maxCoins(nums);

        System.out.println("The result : "+ result);
    }
}
