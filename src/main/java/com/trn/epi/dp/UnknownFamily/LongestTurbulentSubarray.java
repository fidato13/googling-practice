package com.trn.epi.dp.UnknownFamily;

/**
 * https://leetcode.com/problems/longest-turbulent-subarray/
 *
 * DP Approach : https://leetcode.com/problems/longest-turbulent-subarray/discuss/222511/DP-Thinking-Process-(Java)
 *
 * A subarray A[i], A[i+1], ..., A[j] of A is said to be turbulent if and only if:
 *
 * For i <= k < j, A[k] > A[k+1] when k is odd, and A[k] < A[k+1] when k is even;
 * OR, for i <= k < j, A[k] > A[k+1] when k is even, and A[k] < A[k+1] when k is odd.
 * That is, the subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.
 *
 * Return the length of a maximum size turbulent subarray of A.
 *
 *
 *
 * Example 1:
 *
 * Input: [9,4,2,10,7,8,8,1,9]
 * Output: 5
 * Explanation: (A[1] > A[2] < A[3] > A[4] < A[5])
 * Example 2:
 *
 * Input: [4,8,12,16]
 * Output: 2
 * Example 3:
 *
 * Input: [100]
 * Output: 1
 *
 *
 * Note:
 *
 * 1 <= A.length <= 40000
 * 0 <= A[i] <= 10^9
 */
public class LongestTurbulentSubarray {
    /**
     * After observation, we realize that the last element of the longest turbulent subarray must be one of elements in A.
     *
     * Let's define
     *
     * state[i]: longest turbulent subarray ending at A[i]
     *
     * state transition relies on the comparison sign between A[i - 1] and A[i], so
     *
     * state[i][0]: longest turbulent subarray ending at A[i] and A[i-1] < A[i]
     * state[i][1]: longest turbulent subarray ending at A[i] and A[i-1] > A[i]
     *
     * state transition is
     *
     * state[i][0] = state[i - 1][1] + 1 or 1
     * state[i][1] = state[i - 1][0] + 1 or 1
     *
     * We maintain maxLen as the maximum element in the state array.
     * @param A
     * @return
     */
    private static int maxTurbulenceSizeDP(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        int n = A.length, maxLen = 0;
        int[][] state = new int[n][2];

        for(int i = 1; i < n; i++){

            if(A[i - 1] > A[i]){
                state[i][1] = 1 + state[i - 1][0];
                maxLen = Math.max(maxLen, state[i][1]);
            } else if (A[i - 1] < A[i])  {
                state[i][0] = 1 + state[i - 1][1];
                maxLen = Math.max(maxLen, state[i][0]);
            }
        }

        return maxLen + 1;
    }

    private static int maxTurbulenceSizeSlidingWindow(int[] A) {

        if(A.length <= 2){
            return A.length;
        }

        int globalMax = 2;

        int windowStart = 0;

        for(int i = 2; i <= A.length - 1; i++){
            if(A[i] == A[i - 1]){
                windowStart = i;
                continue;
            }

            if(A[i] > A[i - 1]){ // greater
                if(A[i - 1] < A[i - 2]){ // previous pair lesser
                    globalMax = Math.max(globalMax, i - windowStart + 1);
                    continue;
                } else {
                    windowStart = i - 1;
                }

            }

            if(A[i] < A[i - 1]){ // lesser
                if(A[i - 1] > A[i - 2]){ // previous pair greater
                    globalMax = Math.max(globalMax, i - windowStart + 1);
                    continue;
                } else {
                    windowStart = i - 1;
                }
            }
        }

        return globalMax;
    }

    public static void main(String[] args) {

        int[] A = new int[]{9,4,2,10,7,8,8,1,9};

        int result = maxTurbulenceSizeDP(A);

        System.out.println("The result : "+ result);
    }
}
