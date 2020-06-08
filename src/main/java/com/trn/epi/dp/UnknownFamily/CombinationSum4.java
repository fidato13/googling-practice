package com.trn.epi.dp.UnknownFamily;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/combination-sum-iv/
 *
 * Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.
 *
 * Example:
 *
 * nums = [1, 2, 3]
 * target = 4
 *
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 *
 * Note that different sequences are counted as different combinations.
 *
 * Therefore the output is 7.
 *
 */
public class CombinationSum4 {

    /**
     * The below portion gives the recursive + top down dp approach
     * @param args
     */
    private static int[] dp;
    public static int combinationSum4(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(nums, target);
    }

    private static int helper(int[] nums, int target){
        if(dp[target] != -1){
            return dp[target];
        }

        int result = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= target){
                result += helper(nums, target - nums[i]);
            }
        }
        dp[target] = result;
        return result;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3};
        int target = 4;

        int result = combinationSum4(nums, target);

        System.out.println("The result : "+ result);

    }
}
