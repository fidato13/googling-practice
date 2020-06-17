package com.trn.epi.dp.minimax;

/**
 * https://leetcode.com/problems/stone-game-ii/
 *
 * Alex and Lee continue their games with piles of stones.  There are a number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].  The objective of the game is to end with the most stones.
 *
 * Alex and Lee take turns, with Alex starting first.  Initially, M = 1.
 *
 * On each player's turn, that player can take all the stones in the first X remaining piles, where 1 <= X <= 2M.  Then, we set M = max(M, X).
 *
 * The game continues until all the stones have been taken.
 *
 * Assuming Alex and Lee play optimally, return the maximum number of stones Alex can get.
 *
 *
 *
 * Example 1:
 *
 * Input: piles = [2,7,9,4,4]
 * Output: 10
 * Explanation:  If Alex takes one pile at the beginning, Lee takes two piles, then Alex takes 2 piles again. Alex can get 2 + 4 + 4 = 10 piles in total. If Alex takes two piles at the beginning, then Lee can take all three piles left. In this case, Alex get 2 + 7 = 9 piles in total. So we return 10 since it's larger.
 *
 *
 * Constraints:
 *
 * 1 <= piles.length <= 100
 * 1 <= piles[i] <= 10 ^ 4
 */
public class StoneGameII {

    private static int stoneGameII(int[] piles){
        //sum array , sum[i] represents the sum from piles[i] to piles[piles.length - 1]
        int[] sum = new int[piles.length];

        //dp array to store previous results ,
        // dp[i][x] represents at index i of the piles, if x piles are choosen then what is the max number of stones one can get from the remaining piles
        int[][] dp = new int[piles.length + 1][piles.length + 1];

        //populate sum
        sum[piles.length - 1] = piles[piles.length - 1];
        for(int i = piles.length - 2; i >= 0; i--){
            sum[i] = piles[i] + sum[i + 1];
        }


        // dp arrays defintion above mentioned in comment also tells us that we need to somewhat run the loop from end to beginning. i.e. since the definition says, at i , if m piles are collected then the max number of stones...
// so now, if start to fill the array from index 0, then we would be relying on states which are still pending like what if alex chooses 1, lee chosses 2nd, 3rd and 4th index ... in recursive sense this makes sense... however for a bottom up dp,  we need to solve this from end to beginning and then find the answer at beginning of the dp array....

        for(int i = dp.length - 1; i >=0; i--){

            for(int m = dp.length - 1; m >= 0; m--){

                for(int x = 1; x <= 2*m && i + x <= dp.length - 1; x++){
                    dp[i][m] = Math.max(dp[i][m], sum[i] - dp[i + x][Math.max(m,x)]);
                }
            }
        }

        return dp[0][1];

    }

    public static void main(String[] args) {

        int[] piles = new int[]{2,7,9,4,4};

        int result = stoneGameII(piles);

        System.out.println("The result : "+ result);
    }
}
