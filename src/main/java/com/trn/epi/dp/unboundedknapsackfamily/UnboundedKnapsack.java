package com.trn.epi.dp.unboundedknapsackfamily;

/**
 * Given a knapsack weight W and a set of n items with certain value vali and weight wti, we need to maximize the value we can put in knapsack using unlimited amount of items
 * However, the capcaity of Knapsack is limited and should not be exceeded
 */
public class UnboundedKnapsack {

    private int unboundedKnapsack(int[] value, int[] weight, int capacity){

        int[][] dp = new int[value.length + 1][capacity + 1];

        for(int i = 1; i < dp.length; i++){
            for (int j = 1; j < dp[0].length; j++){

                dp[i][j] = dp[i - 1][j];
                if(weight[i - 1] > j){
                    continue;
                }

                dp[i][j] = Math.max(value[i - 1] + dp[i][j - weight[i - 1]], dp[i - 1][j]);
            }
        }

        return dp[value.length][capacity];
    }

    public static void main(String[] args) {

        UnboundedKnapsack u1 = new UnboundedKnapsack();

        int[] value = new int[]{1,30};
        int[] weight = new int[]{1,50};
        int capacity = 100;

//        int[] value = new int[]{10, 40, 50, 70};
//        int[] weight = new int[]{1, 3, 4, 5};
//        int capacity = 8;

        int result = u1.unboundedKnapsack(value, weight, capacity);

        System.out.println("Max value that can be collected : "+ result);
    }
}
