package com.trn.epi.dp.lisfamily;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/russian-doll-envelopes/
 *
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
 *
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 *
 * Note:
 * Rotation is not allowed.
 *
 * Example:
 *
 * Input: [[5,4],[6,4],[6,7],[2,3]]
 * Output: 3
 * Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 */
public class RussianDollEnvelopes {

    private static int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length <= 1){
            return envelopes.length;
        }

        int[] dp = new int[envelopes.length];

        Arrays.fill(dp, 1);

        Arrays.sort(envelopes, (a, b) -> (a[0] - b[0]));
        int globalMax = Integer.MIN_VALUE;

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp.length; j++){
                if(i == j){
                    continue;
                }

                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            globalMax = Math.max(globalMax, dp[i]);

        }

        return globalMax;
    }

    public static void main(String[] args) {

        int[][] envelopes = new int[][]{{4,5},{4,6},{6,7},{2,3},{1,1}};

        int result = maxEnvelopes(envelopes);

        System.out.println("The result is : "+result);
    }
}
