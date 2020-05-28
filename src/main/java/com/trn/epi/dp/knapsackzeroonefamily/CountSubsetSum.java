package com.trn.epi.dp.knapsackzeroonefamily;

/**
 * Given an array arr[] of length N and an integer X, the task is to find the number of subsets with sum equal to X
 *
 * Example 1 :
 * Input: arr[] = {1, 2, 3, 3}, X = 6
 * Output: 3
 * All the possible subsets are {1, 2, 3},
 * {1, 2, 3} and {3, 3}
 *
 * Example 2:
 * Input: arr[] = {1, 1, 1, 1}, X = 1
 * Output: 4
 */
public class CountSubsetSum {

    private int countOfSubsetSum(int[] nums, int sum){
        int[][] dp = new int[nums.length + 1][sum + 1];

        // number of ways where an array of arbitrary length is given and we have to make a subset of sum 0
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(nums[i - 1] > j){
                    continue;
                }

                dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
            }
        }

        return dp[nums.length][sum];

    }

    public static void main(String[] args) {

        CountSubsetSum c1 = new CountSubsetSum();

        int[] nums = new int[]{1, 2, 3, 3};
        int sum = 6;

        //int[] nums = new int[]{1, 1,2,3};
        //int sum = 4;

        int result = c1.countOfSubsetSum(nums, sum);

        System.out.println("The number of subsets who have the required sum : "+ result);

    }
}
