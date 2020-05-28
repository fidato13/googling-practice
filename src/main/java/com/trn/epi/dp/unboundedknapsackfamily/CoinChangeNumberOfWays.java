package com.trn.epi.dp.unboundedknapsackfamily;

/**
 * https://www.geeksforgeeks.org/understanding-the-coin-change-problem-with-dynamic-programming/
 *
 * Given a list of coins i.e 1 cents, 5 cents and 10 cents, can you determine the total number of permutations of the coins in the given list to make up the number N?
 *
 * Example 1:
 * Input : N=8
 *         Coins : 1, 5, 10
 * Output : 2
 *
 * Explanation: 1 way: 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 = 8 cents.
 *              2 way: 1 + 1 + 1 + 5 = 8 cents.
 *
 * Example 2:
 * Input : N=10
 *         Coins : 1, 5, 10
 * Output : 4
 * Explanation: 1 way: 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 = 10 cents.
 *              2 way: 1 + 1 + 1 + 1 + 1 + 5 = 10 cents.
 *              3 way: 5 + 5 = 10 cents.
 *              4 way: 10 cents = 10 cents.
 */
public class CoinChangeNumberOfWays {

    private int numberOfWays(int[] coins, int sum){

        int[][] dp = new int[coins.length + 1][sum + 1];

        for(int i = 0; i < dp.length; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                dp[i][j] = dp[i - 1][j];

                if(coins[i - 1] > j){
                    continue;
                }

                dp[i][j] = dp[i][j - coins[i - 1]] + dp[i][j];
            }
        }

        return dp[coins.length][sum];
    }

    public static void main(String[] args) {

        CoinChangeNumberOfWays c1 = new CoinChangeNumberOfWays();

//        int sum = 8;
//        int[] coins = new int[]{1,5,10};

        int sum = 10;
        int[] coins = new int[]{1,5,10};

        int result = c1.numberOfWays(coins, sum);

        System.out.println("The number of ways : "+ result);
    }
}
