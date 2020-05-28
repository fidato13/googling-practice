package com.trn.epi.dp.knapsackzeroonefamily;

/**
 *  This problem is similar to Count of subset sum and will get derived to the same.
 *  Description : find the number (n) of subset sum pair (s1 & s2) whose difference abs(s1 - s2) is X
 *
 *  Input nums : {1,1,2,3} , X = 1
 */
public class NumberOfSubsetWithDifference {

    private int subsetWithGivenDifference(int[] nums, int difference){

        int total = 0;
        for(int num : nums){
            total += num;
        }

        /**
         *  Now,
         *  s1 + s2 = total (as two subset from a given array would always be equal to total of the array)
         *  s1 - s2 = difference
         *
         *  so , 2s1 = total + difference
         *  or s1 = (total + difference) / 2
         *
         *  i.e. we have to find a subset whose sum is 4...and we have to find the count of such subsets
         *  so the problem reduces to CountSubsetSum problem
         */

        int subset = (total + difference) / 2;

        int[][] dp = new int[nums.length + 1][subset + 1];

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

        return Math.max(dp[nums.length][subset], dp[nums.length][total - subset]);
    }

    public static void main(String[] args) {

        NumberOfSubsetWithDifference n1 = new NumberOfSubsetWithDifference();

        int[] nums = new int[]{1,1,2,3};
        int difference = 1;

        int result = n1.subsetWithGivenDifference(nums, difference);

        System.out.println("Number of subsets with given difference : "+ result);
    }
}
