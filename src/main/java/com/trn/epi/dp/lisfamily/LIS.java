package com.trn.epi.dp.lisfamily;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 *
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * Example:
 *
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Note:
 *
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
public class LIS {

    private int lengthOfLIS(int[] nums) {

        if(nums.length <= 1){
            return nums.length;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int globalMax = Integer.MIN_VALUE;

        for(int i = 1; i < dp.length; i++){
            int greaterCount = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }


            globalMax = Math.max(globalMax, dp[i]);
        }

        return globalMax;
    }


    public static void main(String[] args) {

        LIS lis = new LIS();

        int[] nums = new int[]{10,9,2,5,3,7,101,18};

        int result = lis.lengthOfLIS(nums);

        System.out.println("The length of lis is :  "+result);
    }
}
