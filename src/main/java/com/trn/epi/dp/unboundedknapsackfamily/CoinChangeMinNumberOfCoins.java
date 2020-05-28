package com.trn.epi.dp.unboundedknapsackfamily;

/**
 * https://www.educative.io/edpresso/coin-change-problem-1-in-javafinding-the-minimum-number-of-coins
 *
 * Assume that we are given a set of coins having the values {1, 3, 6}.
 * To make a sum of 7 using these coins, all possible solutions are: {1,1,1,1,1,1,1}, {1,3,3}, and {1,6}.
 * So the minimum number of coins required are 2, i.e. {1,6}.
 */
public class CoinChangeMinNumberOfCoins {

    private int minNumberofCoins(int[] coins, int sum){

        // every cell in this matrix contains the number of coins for that sum (column label) with given coins (row label till that index)
        int[][] dp = new int[coins.length + 1][sum + 1];

        //first row
        for(int j = 0; j < dp[0].length; j++){
            dp[0][j] = Integer.MAX_VALUE - 1;
        }

        //second row - if the first coin in the array is able to resolve the sum in it's multiples or not
        for(int j = 1; j < dp[0].length; j++){
            if(j < coins[0]){
                dp[1][j] = Integer.MAX_VALUE - 1;
                continue;
            }

            if(j % coins[0] == 0){
                dp[1][j] = j / coins[0];
            } else {
                dp[1][j] = Integer.MAX_VALUE - 1;
            }
        }

        // for all other rows
        for(int i = 2; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                dp[i][j] = dp[i - 1][j];

                if(coins[i - 1] > j){
                    continue; // the current coin is greater than the sum
                }

                dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], //when we have selected the coin
                        dp[i - 1][j]    // when we have not selected the coin
                        );
            }
        }

        return dp[coins.length][sum];
    }

    public static void main(String[] args) {
        CoinChangeMinNumberOfCoins c1 = new CoinChangeMinNumberOfCoins();

//        int[] coins = new int[]{1,3,6};
//        int sum = 7;

        int[] coins = new int[]{25,10,5};
        int sum = 60;

        int result = c1.minNumberofCoins(coins, sum);

        System.out.println("Minimum number of coins needed are : "+ result);
    }
}
