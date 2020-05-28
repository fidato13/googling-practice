package com.trn.sol;

public class BuySell {

    public static int maxProfit(int[] prices) {

        if(prices.length < 2){
            return 0;
        }

        int maxProfit = 0;

        int buy = prices[0];
        int sell = prices[1];

        for(int i = 1; i < prices.length; i++){
            maxProfit = Math.max(maxProfit, sell - buy);
            if(prices[i] < buy){
                buy = prices[i];
                sell = prices[i];
                continue;
            }
            if(prices[i] > sell){
                sell = prices[i];
                continue;
            }

        }

        maxProfit = Math.max(maxProfit, sell - buy);

        return maxProfit;
    }

    public static void main(String[] args) {
        int result = maxProfit(new int[]{1,2,4});
        System.out.println("Result => "+ result);
    }
}
