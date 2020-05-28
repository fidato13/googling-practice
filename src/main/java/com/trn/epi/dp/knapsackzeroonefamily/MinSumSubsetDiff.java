package com.trn.epi.dp.knapsackzeroonefamily;

/**
 * https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/
 *
 * Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.
 * If there is a set S with n elements, then if we assume Subset1 has m elements,
 * Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.
 *
 * Input:  arr[] = {1, 6, 11, 5}
 * Output: 1
 * Explanation:
 * Subset1 = {1, 5, 6}, sum of Subset1 = 12
 * Subset2 = {11}, sum of Subset2 = 11
 */
public class MinSumSubsetDiff {


    private int minDiffSubsets(int[] nums){
        int total = 0;

        for(int num : nums){
            total += num;
        }

        boolean[][] dp = new boolean[nums.length + 1][total + 1];

        for(int i = 0; i < dp.length; i++){
            dp[i][0] = true;
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                dp[i][j] = dp[i - 1][j];

                if(nums[i - 1] > j){
                    continue;
                }

                dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i][j];
            }
        }

        int width = dp[0].length;

        if(width % 2 == 0){
            width /= 2;
            width--;
        } else {
            width /= 2;
        }

        for(int j = width; j >= width; j--){
            if(dp[nums.length][j]){
                return Math.abs((2 * j) - total);
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        MinSumSubsetDiff m1 = new MinSumSubsetDiff();

        int[] nums = new int[]{1, 6, 11, 5};

        int result = m1.minDiffSubsets(nums);

        System.out.println("Minimum subset difference : "+ result);
    }
}
