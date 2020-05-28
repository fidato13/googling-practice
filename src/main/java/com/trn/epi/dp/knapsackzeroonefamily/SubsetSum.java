package com.trn.epi.dp.knapsackzeroonefamily;

/**
 * https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
 *
 * Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
 *
 * Example :
 * Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
 * Output: True
 * There is a subset (4, 5) with sum 9.
 *
 * Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30
 * Output: False
 * There is no subset that add up to 30.
 */
public class SubsetSum {

    private boolean hasSubsetSum(int[] nums, int sum){

        boolean[][] dp = new boolean[nums.length + 1][sum + 1];

        //init first row
        for(int j = 0; j < dp[0].length; j++){
            dp[0][j] = false;
        }

        //init first column
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = true;
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){

                dp[i][j] = dp[i - 1][j];
                // if item is greater than sum at this point then ignore the item as it can't be included
                if(nums[i - 1] > j){
                    continue;
                }

                //if item is lesser then it may or may not be the part of the subset which is giving us the required sum, depending upon the combination
                dp[i][j] = dp[i - 1][j - nums[i - 1]] || //if we have selected the item
                        dp[i][j];   // if the item is not selected
            }
        }

        return dp[nums.length][sum];

    }

    public static void main(String[] args) {

        SubsetSum s1 = new SubsetSum();

        int[] nums = new int[]{3, 34, 4, 12, 5, 2};
        int sum = 11;

        boolean result = s1.hasSubsetSum(nums, sum);

        System.out.println("The subset is present for the required sum : "+result);
    }
}
