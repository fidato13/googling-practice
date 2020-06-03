package com.trn.epi.dp.lisfamily;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-length-of-pair-chain/
 *
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.
 *
 * Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.
 *
 * Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.
 *
 * Example 1:
 * Input: [[1,2], [2,3], [3,4]]
 * Output: 2
 * Explanation: The longest chain is [1,2] -> [3,4]
 * Note:
 * The number of given pairs will be in the range [1, 1000].
 */
public class MaxLengthOfPairChain {

    private int findLongestChain(int[][] pairs) {
        if(pairs.length <= 1){
            return pairs.length;
        }

        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));

        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);

        int globalMax = Integer.MIN_VALUE;

        for(int i = 0; i < pairs.length; i++){
            for(int j = 0; j < i; j++){
                if(i == j){
                    continue;
                }

                if(pairs[i][0] > pairs[j][1]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }

            globalMax = Math.max(globalMax, dp[i]);
        }

        return globalMax;
    }

    public static void main(String[] args) {

        MaxLengthOfPairChain m1 = new MaxLengthOfPairChain();

        int[][] pairs = new int[][]{{1,2}, {2,3}, {3,4}};

        int result = m1.findLongestChain(pairs);

        System.out.println("max length of pair chain :  "+ result);
    }
}
