package com.trn.epi.dp.mcmfamily;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-score-triangulation-of-polygon/
 *
 * Intuition :: https://leetcode.com/problems/minimum-score-triangulation-of-polygon/discuss/286753/C%2B%2B-with-picture
 *
 * Given N, consider a convex N-sided polygon with vertices labelled A[0], A[i], ..., A[N-1] in clockwise order.
 *
 * Suppose you triangulate the polygon into N-2 triangles.  For each triangle, the value of that triangle is the product of the labels of the vertices, and the total score of the triangulation is the sum of these values over all N-2 triangles in the triangulation.
 *
 * Return the smallest possible total score that you can achieve with some triangulation of the polygon.
 *
 *
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: 6
 * Explanation: The polygon is already triangulated, and the score of the only triangle is 6.
 * Example 2:
 *
 *
 *
 * Input: [3,7,4,5]
 * Output: 144
 * Explanation: There are two triangulations, with possible scores: 3*7*5 + 4*5*7 = 245, or 3*4*5 + 3*4*7 = 144.  The minimum score is 144.
 * Example 3:
 *
 * Input: [1,3,1,4,1,5]
 * Output: 13
 * Explanation: The minimum score triangulation has score 1*1*3 + 1*1*4 + 1*1*5 + 1*1*1 = 13.
 */
public class TriangulationOfPolygon {

    private static int[][] dp;

    private static int minScoreTriangulation(int[] A) {
        dp = new int[A.length + 1][A.length + 1];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return helper(A, 0, A.length - 1);
    }

    private static int helper(int[] A, int i, int j){
        if( (j-i+1) < 3) {
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;

        for(int k = i + 1 ; k < j; k++){
            int temp = helper(A, i, k) + A[i] * A[j] * A[k] + helper(A, k, j);

            if(temp < min){
                min = temp;
            }
        }

        return dp[i][j] = min;
    }

    public static void main(String[] args) {

        int[] A = new int[]{3,7,4,5};

        int result = minScoreTriangulation(A);

        System.out.println("The result : "+ result);
    }
}
