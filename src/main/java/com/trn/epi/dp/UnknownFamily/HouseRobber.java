package com.trn.epi.dp.UnknownFamily;

/**
 * https://leetcode.com/problems/house-robber/
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 *
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 *              Total amount you can rob = 2 + 9 + 1 = 12.
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 */
public class HouseRobber {

    private static int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        int[] take = new int[nums.length];
        int[] skip = new int[nums.length];

        int result = nums[0];
        take[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            take[i] = skip[i - 1] + nums[i];
            skip[i] = Math.max(take[i - 1], skip[i - 1]);

            result = Math.max(result, Math.max(take[i], skip[i]));
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{2,7,9,3,1};
        int result = rob(nums);

        System.out.println("The result : "+ result);

    }
}
