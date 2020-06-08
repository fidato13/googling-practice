package com.trn.epi.backtracking;

/**
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
 *
 * Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * Output: True
 * Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 *
 *
 * Note:
 *
 * 1 <= k <= len(nums) <= 16.
 * 0 < nums[i] < 10000.
 */
public class PartitionKSubsets {

    private static boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;

        for(int num : nums){
            total += num;
        }

        if(k == 0 || total % k != 0){
            return false;
        }

        return canPartition(nums, k, 0, total / k, new boolean[nums.length], 0);

    }

    private  static boolean canPartition(int[] nums, int k, int currentBucketSum, int targetBucketSum, boolean[] used, int iterationStart){
        if(k == 1){
            return true;
        }

        if(currentBucketSum == targetBucketSum){
            return canPartition(nums, k - 1, 0, targetBucketSum, used, 0);
        }

        for(int i = iterationStart; i < nums.length; i++){
            if(!used[i]){
                used[i] = true;
                if(canPartition(nums, k , currentBucketSum + nums[i], targetBucketSum, used, iterationStart + 1)){
                    return true;
                }
                used[i] = false;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 3, 5, 2, 1};
        int k = 4;

        Boolean result = canPartitionKSubsets(nums, k);

        System.out.println("The result : "+result);
    }
}
