package com.trn.epi.dp.knapsackzeroonefamily;

/**
 * 0-1 Knapsack Problem
 * https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 *
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
 * In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items respectively.
 * Also given an integer W which represents knapsack capacity,
 * find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W.
 * You cannot break an item, either pick the complete item or don’t pick it (0-1 property).
 */
public class KnapsackZeroOne {

    // find the max value that can be obtained, given the capacity of the knapsack.
    private int knapsack(int[] weight, int[] value, int capacity){

        int totalItems = value.length;

        int[][] dp = new int[totalItems + 1][capacity + 1];

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                dp[i][j] = dp[i - 1][j];
                //if the weight of the item is greater already then we can't use it
                if(weight[i - 1] > j){
                    continue;
                }

                /**
                 * if the weight is less than or equal to the capacity then:
                 * 1. we can either choose this item to be in the knapsack
                 * 2. or we can discard it
                 *
                 * depending upon whether collecting this item would prove to be useful in extending the total value or not based on other items and their combinations
                 */

                //so we have to select the max (value we get) of when we choose this item vs when we ignore this item
                dp[i][j] = Math.max(
                        value[i - 1] + dp[i - 1][j - weight[i - 1]], // when we chose this item
                        dp[i - 1][j] // when we don't choose this
                );

            }
        }

        return dp[totalItems][capacity];

    }

    public static void main(String[] args) {
        KnapsackZeroOne k1 = new KnapsackZeroOne();

        //int[] weight = new int[]{10,20,30};
        int[] weight = new int[]{1,1,2};
        int[] value = new int[]{60,100,120};
        int capacity = 2;

        int result = k1.knapsack(weight, value, capacity);

        System.out.println("Max value in knapsack : "+ result);
    }
}
