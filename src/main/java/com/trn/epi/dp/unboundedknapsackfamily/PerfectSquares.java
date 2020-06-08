package com.trn.epi.dp.unboundedknapsackfamily;

/**
 * https://leetcode.com/problems/perfect-squares/
 *
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */
public class PerfectSquares {

    private static int numSquares(int n) {
        int row = 0;
        while(row * row <= n){
            row++;
        }
        int[][] dp = new int[row][n + 1];

        for(int j = 1; j <  dp[0].length; j++){
            dp[0][j] = Integer.MAX_VALUE - 1;
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                dp[i][j] = dp[i - 1][j];

                if(j < i * i ) {
                    continue;
                }
                //either we pick this square or not
                dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - (i * i)]);
            }
        }

        return dp[row - 1][n];

    }

    public static void main(String[] args) {

        int n = 12;

        int result = numSquares(n);

        System.out.println("The result : "+ result);
    }
}
