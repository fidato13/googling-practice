package com.trn.epi.dp.matrixrangesum;

/**
 * https://leetcode.com/problems/minimum-falling-path-sum/
 *
 * Given a square array of integers A, we want the minimum sum of a falling path through A.
 *
 * A falling path starts at any element in the first row, and chooses one element from each row.  The next row's choice must be in a column that is different from the previous row's column by at most one.
 *
 *
 *
 * Example 1:
 *
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: 12
 * Explanation:
 * The possible falling paths are:
 * [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
 * [2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
 * [3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
 * The falling path with the smallest sum is [1,4,7], so the answer is 12.
 *
 *
 *
 * Note:
 *
 * 1 <= A.length == A[0].length <= 100
 * -100 <= A[i][j] <= 100
 */
public class MinimumFallingPathSum {

    private static int minFallingPathSum(int[][] A) {
        int[][] dp = new int[A.length][A[0].length];

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(i == 0){
                    dp[0][j] = A[0][j];
                    continue;
                }

                //assign the above cell
                int minCell = dp[i - 1][j];

                if(j - 1 >= 0){
                    minCell = Math.min(minCell, dp[i-1][j - 1]);
                }

                if(j + 1 < A.length){
                    minCell = Math.min(minCell, dp[i - 1][j + 1]);
                }

                dp[i][j] = A[i][j] + minCell;

            }
        }

        //find min in last row
        int result = Integer.MAX_VALUE;

        for(int j = 0; j < dp[0].length; j++){
            result = Math.min(dp[A.length - 1][j], result);
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] A = new int[][]{{1,2,3},{4,5,6},{7,8,9}};

        int result = minFallingPathSum(A);

        System.out.println("The result : "+ result);
    }
}
