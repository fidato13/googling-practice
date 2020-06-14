package com.trn.epi.dp.UnknownFamily;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 *
 * Solution : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/discuss/54114/Easy-understanding-and-can-be-easily-modified-to-different-situations-Java-Solution
 *
 * Say you have an array for which the i-th element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 *
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *
 * Example 1:
 *
 * Input: [2,4,1], k = 2
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 * Example 2:
 *
 * Input: [3,2,6,5,0,3], k = 2
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
 *              Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 */
public class BestTimetoBuyandSellStockIV {

    //hold[i][k]  ith day k transaction have stock and maximum profit
    //unhold[i][k] ith day k transaction do not have stock at hand and maximum profit
    private static int maxProfit(int k, int[] prices) {

        if(k>prices.length/2){
            return maxP(prices);
        }

        int[][] hold = new int[prices.length][k+1];
        int[][] unhold = new int[prices.length][k+1];

        hold[0][0] = -prices[0];

        for(int i=1;i<prices.length;i++) {
            hold[i][0] = Math.max(hold[i-1][0],-prices[i]);
        }

        for(int j=1;j<=k;j++) {
            hold[0][j] = -prices[0];
        }
        for(int i=1;i<prices.length;i++){
            for(int j=1;j<=k;j++){
                hold[i][j] = Math.max(unhold[i-1][j]-prices[i],hold[i-1][j]);
                unhold[i][j] = Math.max(hold[i-1][j-1]+prices[i],unhold[i-1][j]);
            }
        }
        return Math.max(hold[prices.length-1][k],unhold[prices.length-1][k]);
    }
    private static int maxP(int[] prices){
        int res =0;
        for(int i=0;i<prices.length;i++){
            if(i>0 && prices[i] > prices[i-1]){
                res += prices[i]-prices[i-1];
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] prices = new int[]{3,2,6,5,0,3};

        int k = 2;

        int result = maxProfit(k, prices);

        System.out.println("The result : "+ result);
    }
}
