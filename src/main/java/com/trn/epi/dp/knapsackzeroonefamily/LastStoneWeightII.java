package com.trn.epi.dp.knapsackzeroonefamily;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/last-stone-weight-ii/
 *
 * We have a collection of rocks, each rock has a positive integer weight.
 *
 * Each turn, we choose any two rocks and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
 *
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 * At the end, there is at most 1 stone left.  Return the smallest possible weight of this stone (the weight is 0 if there are no stones left.)
 *
 *
 *
 * Example 1:
 *
 * Input: [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We can combine 2 and 4 to get 2 so the array converts to [2,7,1,8,1] then,
 * we can combine 7 and 8 to get 1 so the array converts to [2,1,1,1] then,
 * we can combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we can combine 1 and 1 to get 0 so the array converts to [1] then that's the optimal value.
 *
 *
 * Note:
 *
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 100
 */
public class LastStoneWeightII {

    private static int lastStoneWeightII(int[] stones) {
        // The question is similar to finding the subsets (S1, S2) of a given set S, such that difference between subsets is minimum
        // how did we reach to the above conclusion? ... well, if we look closely, we have to reduce the array to a single value... and [2,7,4,1,8,1] can be reduced to [2,4,1,1,1] , by removing 7,8 and inserting 1 in place... thus the state of the array still doesn't make any difference to the problem statement..
// again if we look... since we are removing the two elements and replacing it with their difference... how about we just instead move them to different spaces (areas) instead of removing them from array...
// like S1 : 7 , S2 : 8 ... arr becomes [2,4,1,1].. thus difference between s1,s2 still preserves the "1" that was about to be added back to array...
// and let's pick two more values from arr...
// S1 : 7, 4 and S2 : 8, 2 ...arr[1,1]
// and one more...
// S1 : 7,4,1 and S2 : 8,2,1 ...arr[]
// so now, s1 - s2 = 1 ..is our anwser
// so if we are able to partition the array in two subsets, such that their difference is min, and that min would be our answer

        int total = 0;

        for(int stone : stones){
            total += stone;
        }

        //this will keep track of , out of the given set, what all values can be formed from selecting a subset with any values
        boolean[][] dp = new boolean[stones.length + 1][total +1];

        for(int i = 0; i < dp.length; i++){
            dp[i][0] = true;
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                dp[i][j] = dp[i - 1][j];

                if(j < stones[i - 1]){
                    continue;
                }

                dp[i][j] = dp[i][j] || dp[i - 1][j - stones[i - 1]];
            }
        }

        // now dp contains what totals can be acheived..so as our goal was to find a partition which would divide the array(total) into two sets...we would start by looking at the middle.

//if the dp array is of odd length
        int partition = total + 1;
        if(partition % 2 == 0){
            partition /= 2;
            partition--;
        } else {
            partition/= 2;
        }

        for(int j = partition; j >= 0; j--){
            if(dp[stones.length][j]){
                return Math.abs((2 * j) - total);
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] stones = new int[]{31,26,33,21,40};

        int result = lastStoneWeightII(stones);

        System.out.println("The result : "+ result);

    }
}
