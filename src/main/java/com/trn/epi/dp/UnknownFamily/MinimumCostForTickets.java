package com.trn.epi.dp.UnknownFamily;

/**
 * https://leetcode.com/problems/minimum-cost-for-tickets/
 *
 * In a country popular for train travel, you have planned some train travelling one year in advance.  The days of the year that you will travel is given as an array days.  Each day is an integer from 1 to 365.
 *
 * Train tickets are sold in 3 different ways:
 *
 * a 1-day pass is sold for costs[0] dollars;
 * a 7-day pass is sold for costs[1] dollars;
 * a 30-day pass is sold for costs[2] dollars.
 * The passes allow that many days of consecutive travel.  For example, if we get a 7-day pass on day 2, then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.
 *
 * Return the minimum number of dollars you need to travel every day in the given list of days.
 *
 *
 *
 * Example 1:
 *
 * Input: days = [1,4,6,7,8,20], costs = [2,7,15]
 * Output: 11
 * Explanation:
 * For example, here is one way to buy passes that lets you travel your travel plan:
 * On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
 * On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
 * On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
 * In total you spent $11 and covered all the days of your travel.
 * Example 2:
 *
 * Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
 * Output: 17
 * Explanation:
 * For example, here is one way to buy passes that lets you travel your travel plan:
 * On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1, 2, ..., 30.
 * On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
 * In total you spent $17 and covered all the days of your travel.
 *
 *
 * Note:
 *
 * 1 <= days.length <= 365
 * 1 <= days[i] <= 365
 * days is in strictly increasing order.
 * costs.length == 3
 * 1 <= costs[i] <= 1000
 */
public class MinimumCostForTickets {

    private static int mincostTickets(int[] days, int[] costs) {

        int[] dp = new int[366];

        boolean[] daysIncluded = new boolean[366];

        for(int day : days){
            daysIncluded[day] = true;
        }

        for(int i = 1; i < 366; i++){
            if(!daysIncluded[i]){
                dp[i] = dp[i - 1];
                continue;
            }

            int min = Integer.MAX_VALUE;
            //let's buy 1 day pass - idea is we are required to buy a 1 day pass today, then the cost will be equal to that of yesterday's PLUS cost of one day pass
            min = Math.min(min, dp[i - 1] + costs[0]);
            //let's buy 7 day pass - idea is , for today, buying a pass 7-day ago would have cost us dp[i - 7] + costs[1] today
            min = Math.min(min, dp[Math.max(0, i - 7)] + costs[1]);
            //let's buy 30 days pass - idea is, for today, buying a pass 30-days ago would have cost us dp[i - 30] + costs[2] today
            min = Math.min(min, dp[Math.max(i - 30, 0)] + costs[2]);

            dp[i] = min;
        }

        return dp[365];
    }

    public static void main(String[] args) {

        int[] days = new int[]{1,4,6,7,8,20};
        int[] costs = new int[]{2,7,15};

        int result = mincostTickets(days, costs);

        System.out.println("The result : "+ result);
    }
}
