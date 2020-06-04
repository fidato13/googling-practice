package com.trn.epi.dp.UnknownFamily;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/delete-and-earn/
 *
 * Given an array nums of integers, you can perform operations on the array.
 *
 * In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.
 *
 * You start with 0 points. Return the maximum number of points you can earn by applying such operations.
 *
 * Example 1:
 *
 * Input: nums = [3, 4, 2]
 * Output: 6
 * Explanation:
 * Delete 4 to earn 4 points, consequently 3 is also deleted.
 * Then, delete 2 to earn 2 points. 6 total points are earned.
 *
 *
 * Example 2:
 *
 * Input: nums = [2, 2, 3, 3, 3, 4]
 * Output: 9
 * Explanation:
 * Delete 3 to earn 3 points, deleting both 2's and the 4.
 * Then, delete 3 again to earn 3 points, and 3 again to earn 3 points.
 * 9 total points are earned.
 *
 *
 * Note:
 *
 * The length of nums is at most 20000.
 * Each element nums[i] is an integer in the range [1, 10000].
 */
public class DeleteAndEarn {

    private static int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);

        int total = 0;

        int n = 10001;

        int[] individualSum = new int[n];

        for(int num : nums){
            //calculate individual sum for every number
            individualSum[num] += num;
        }

        int[] take = new int[n];
        int[] skip = new int[n];

        // so the idea is to, any ith value in the modified array (individualSum) (plus it's copies) can be either takenor can be skipped... depending upon whether it's neighbors were picked or not

        //take... if the element is being taken, then...i-1 needs to be skipped ... we will not worry about i + 1 as of now...because when in next iteration, i would become i + 1, then this current logic will take that into account...
        // take[i] = skip[i - 1] + individualSum[i];

        //if skip... then i - 1 , can  be taken or can be skipped as well...depending upon i - 2 was taken or not..since we need to maximize the outcome,we will take a max of two
        // skip[i] = Math.max(skip[i - 1], take[i - 1])

        int globalMax = Integer.MIN_VALUE;
        for(int i = 1; i < n; i++){
            take[i] = skip[i - 1] + individualSum[i];
            skip[i] = Math.max(skip[i - 1], take[i - 1]);

            globalMax = Math.max(globalMax, Math.max(take[i], skip[i]));
        }

        return globalMax;

    }

    public static void main(String[] args) {

        int[] nums = new int[]{2, 2, 3, 3, 3, 4};
        int result = deleteAndEarn(nums);

        System.out.println("The result : "+ result);
    }
}
