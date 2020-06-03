package com.trn.epi.dp.lisfamily;

import java.util.Arrays;

/**
 * Given an unsorted array of integers, find the number of longest increasing subsequence.
 *
 * Example 1:
 * Input: [1,3,5,4,7]
 * Output: 2
 * Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
 * Example 2:
 * Input: [2,2,2,2,2]
 * Output: 5
 * Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.
 */
public class NumberLIS {

    private int findNumberOfLIS(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }

        int[] dp = new int[nums.length];
        int[] counts = new int[nums.length];

        Arrays.fill(dp, 1);
        Arrays.fill(counts, 1);

        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){

                if(nums[i] > nums[j]){

                    if(dp[j] >= dp[i]){
                        dp[i] = dp[j] + 1;
                        counts[i] = counts[j];
                    } else if(dp[j] + 1 == dp[i]){
                        counts[i] += counts[j];
                    }

                }
            }
        }


        int longest = 0, ans = 0;
        for (int length: dp) {
            longest = Math.max(longest, length);
        }
        for (int i = 0; i < dp.length; ++i) {
            if (dp[i] == longest) {
                ans += counts[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        NumberLIS n1 = new NumberLIS();

        int[] nums = new int[]{1,3,5,4,7};

        int result = n1.findNumberOfLIS(nums);

        System.out.println("The result is : "+ result);

    }
}
