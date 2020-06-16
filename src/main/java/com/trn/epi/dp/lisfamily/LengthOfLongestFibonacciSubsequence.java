package com.trn.epi.dp.lisfamily;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/
 *
 * A sequence X_1, X_2, ..., X_n is fibonacci-like if:
 *
 * n >= 3
 * X_i + X_{i+1} = X_{i+2} for all i + 2 <= n
 * Given a strictly increasing array A of positive integers forming a sequence, find the length of the longest fibonacci-like subsequence of A.  If one does not exist, return 0.
 *
 * (Recall that a subsequence is derived from another sequence A by deleting any number of elements (including none) from A, without changing the order of the remaining elements.  For example, [3, 5, 8] is a subsequence of [3, 4, 5, 6, 7, 8].)
 *
 *
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5,6,7,8]
 * Output: 5
 * Explanation:
 * The longest subsequence that is fibonacci-like: [1,2,3,5,8].
 * Example 2:
 *
 * Input: [1,3,7,11,12,14,18]
 * Output: 3
 * Explanation:
 * The longest subsequence that is fibonacci-like:
 * [1,11,12], [3,11,14] or [7,11,18].
 *
 *
 * Note:
 *
 * 3 <= A.length <= 1000
 * 1 <= A[0] < A[1] < ... < A[A.length - 1] <= 10^9
 * (The time limit has been reduced by 50% for submissions in Java, C, and C++.)
 */
public class LengthOfLongestFibonacciSubsequence {

    /**
     * This problem is similar to Longest Increasing subsequence wherein we track length using 1-d array at any given index....
     * however as we need to figure out thee fibonacci sequence , thus we need to track two numbers here..hence two 2d array..
     *
     * Recurrence relation :
     * dp[r][i] = 1 + dp[l][r]
     *
     * so, dp[r][i] contains the length of longest fib subsequnce, where i = last element of fib sequence... r, is the one previous to last element
     * and it is related to dp[l][r] ... where r is the same as above i.e. one previous to last element and l is obtained by (i - r) as for a valid fib sequnce l , r, i ... l + r = i ...and thus l = i - r;
     *
     * @param A
     * @return
     */

    private static int lenLongestFibSubseq(int[] A) {

        HashMap<Integer, Integer> map = new HashMap<>();

        //build the hashset
        int index = 0;
        for(int num : A){
            map.put(num, index);
            index++;
        }


        //every value in this array represents the length of longest fibonacci subsequence formed at the given index
        int[][] dp = new int[A.length + 1][A.length + 1];

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(i == j){
                    dp[i][j] = 0;
                    continue;
                }

                dp[i][j] = 2;
            }
        }

        int globalMax = 2;

        for(int i = 2; i < A.length; i++){
            for(int j = 0; j < i; j++){

                int right = A[j];
                int left = A[i] - A[j];

                if(left == right || left == A[i] || left > right){
                    continue;
                }

                if(map.containsKey(left)){
                    dp[j][i] = 1 + dp[map.get(left)][j];
                    globalMax = Math.max(globalMax, dp[j][i]);
                }
            }
        }

        return (globalMax > 2) ? globalMax : 0;

    }

    public static void main(String[] args) {

        int[] A = new int[]{2,4,7,8,9,10,14,15,18,23,32,50};

        int result = lenLongestFibSubseq(A);

        System.out.println("The result : "+ result);
    }
}
