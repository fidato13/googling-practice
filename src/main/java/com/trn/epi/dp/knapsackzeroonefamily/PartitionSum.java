package com.trn.epi.dp.knapsackzeroonefamily;

/**
 * https://leetcode.com/problems/partition-equal-subset-sum/
 *
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 * Example 1:
 * Input: [1, 5, 11, 5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 *
 * Example 2:
 * Input: [1, 2, 3, 5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 *
 */
public class PartitionSum {

    private boolean canPartition(int[] nums){

        int total = 0;
        for(int i = 0; i < nums.length; i++){
            total += nums[i];
        }

        if(total % 2 != 0){
            return false;
        }

        int targetSum = total / 2;

        boolean[][] dp = new boolean[nums.length + 1][targetSum + 1];

        for(int j = 0; j < dp[0].length; j++){
            dp[0][j] = false;
        }

        for(int i = 0; i < dp.length; i++){
            dp[i][0] = true;
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                dp[i][j] = dp[i - 1][j];

                if(nums[i - 1] > j){
                    continue;
                }

                dp[i][j] = dp[i - 1][j - nums[i - 1]] ||
                        dp[i][j];

            }
        }

        return dp[nums.length][targetSum];
    }

    public static void main(String[] args) {
        PartitionSum p1 = new PartitionSum();

        int[] nums = new int[]{1, 5, 11, 5};

        boolean result = p1.canPartition(nums);

        System.out.println("The array can be partitioned in equal subset sum : "+ result);
    }
}
