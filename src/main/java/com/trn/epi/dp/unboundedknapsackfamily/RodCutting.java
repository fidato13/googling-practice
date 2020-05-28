package com.trn.epi.dp.unboundedknapsackfamily;

/**
 * Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces.
 * For example, if length of the rod is 8 and the values of different pieces are given as following,
 * then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 *
 * Example:
 * length   | 1   2   3   4   5   6   7   8
 * --------------------------------------------
 * price    | 1   5   8   9  10  17  17  20
 *
 *
 */
public class RodCutting {

    private int maxProfit(int[] price, int initialLengthOfRod){
        int[][] dp = new int[price.length + 1][initialLengthOfRod + 1];

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                dp[i][j] = dp[i - 1][j];

                if(i > j){
                    continue;
                }

                dp[i][j] = Math.max(price[i - 1] + dp[i][j - i] ,dp[i - 1][j]);
            }
        }

        return dp[price.length][initialLengthOfRod];
    }

    public static void main(String[] args) {
        RodCutting rodCutting = new RodCutting();

        int[] price = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        int length = 8;
        //int[] price = new int[]{2,5,7,8};
        //int length = 4;

        int result = rodCutting.maxProfit(price, length);

        System.out.println("The max profit is : "+ result);

    }
}
