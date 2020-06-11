package com.trn.epi.dp.knapsackzeroonefamily;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/target-sum/
 * https://leetcode.com/problems/target-sum/discuss/97334/Java-(15-ms)-C%2B%2B-(3-ms)-O(ns)-iterative-DP-solution-using-subset-sum-with-explanation
 *
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -.
 * For each integer, you should choose one from + and - as its new symbol.
 *
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 *
 *
 * Example:
 *
 * Input: nums is [1, 1, 1, 1, 1], S is 3.
 * Output: 5
 * Explanation:
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 */
public class TargetSum {

    private static int[][] dp;

    private static int findTargetSumWays(int[] nums, int S) {
        dp = new int[nums.length + 1][2001];
        for(int[] row : dp){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        //System.out.println("Value : "+ dp[0][1000]);
        return helper(nums, 0, 0, S);
    }

    private static int helper(int[] nums, int i, int sum, int S){
        if(i == nums.length){
            if(sum == S){
                return 1;
            }
            return 0;
        }

        if(dp[i][sum + 1000] != Integer.MAX_VALUE){
            return dp[i][sum + 1000];
        }

        //recurrene relation...ie. number of ways when element had (+) plus sign attached to it + it had (-) negative sign attached to it
        return dp[i][sum + 1000] = helper(nums, i+1, sum + nums[i], S) +
                helper(nums, i + 1, sum - nums[i], S);
    }


    /**
     * This problem can be converted to a subset sum problem, in particular "Count of Subset Sum" problem
     * https://leetcode.com/problems/target-sum/discuss/97334/Java-(15-ms)-C%2B%2B-(3-ms)-O(ns)-iterative-DP-solution-using-subset-sum-with-explanation
     * @param nums
     * @param target
     * @return
     */
    private static int findTargetSumSubsetSum(int[] nums, int target){

        /**
         * sum(positive) : SP
         * sum(negative) : SN
         *  SP + SN = total
         *  SP - SN = target
         *
         *  SP + SN + SP - SN = total + target
         *  2SP = total + target
         *  SP = (total + target) / 2
         *
         *  So we have to find count of such subsets whose sum is SP...
         *  and this is the exact same problem as "Count of subset sum"
         */

        int total = 0;

        for(int num : nums){
            total += num;
        }

        int sumPositive = (total + target) / 2;

        int[][] lookup = new int[nums.length + 1][sumPositive + 1];

        for(int i = 0; i < lookup.length; i++){
            lookup[i][0] = 1;
        }

        for(int i = 1; i < lookup.length; i++){
            for(int j = 1; j < lookup[0].length; j++){

                if(nums[i - 1] > j){
                    continue;
                }

                lookup[i][j] = lookup[i - 1][j - nums[i - 1]] + lookup[i - 1][j];
            }
        }

        return lookup[nums.length][sumPositive];
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1,1,1,1,1};
        int target = 3;

        //int result = findTargetSumWays(nums, target);
        int result = findTargetSumSubsetSum(nums, target);

        System.out.println("The number of ways are : "+ result);
    }
}
