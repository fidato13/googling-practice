package com.trn.epi.dp.lisfamily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/largest-divisible-subset/
 *
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:
 *
 * Si % Sj = 0 or Sj % Si = 0.
 *
 * If there are multiple solutions, return any subset is fine.
 */
public class LargestDivisibleSubset {

    private List<Integer> largestDivisibleSubset(int[] nums) {
        int[] dp = new int[nums.length];

        if(nums.length == 1){
            return Arrays.asList(nums[0]);
        }

        Arrays.fill(dp, 1);
        int globalMax = Integer.MIN_VALUE;

        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }

            globalMax = Math.max(dp[i], globalMax);

        }


        List<Integer> result = new ArrayList<>();
        int k = globalMax;

        for(int i = dp.length - 1; i >= 0; i--){
            if(dp[i] == k){
                result.add(nums[i]);
                k--;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        LargestDivisibleSubset l1 = new LargestDivisibleSubset();
        int[] nums = new int[]{4,8,10,240};

        List<Integer> result = l1.largestDivisibleSubset(nums);

        System.out.println("The result is : "+result);
    }
}
