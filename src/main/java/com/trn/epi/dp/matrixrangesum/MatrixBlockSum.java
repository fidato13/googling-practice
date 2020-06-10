package com.trn.epi.dp.matrixrangesum;

/**
 * https://leetcode.com/problems/matrix-block-sum/
 *
 * https://leetcode.com/problems/matrix-block-sum/discuss/620405/Easy-Prefix-Logic-Explanation-with-Matrix-Example-%3A-Python-Soution
 *
 *
 * Given a m * n matrix mat and an integer K, return a matrix answer where each answer[i][j] is the sum of all elements mat[r][c] for i - K <= r <= i + K, j - K <= c <= j + K, and (r, c) is a valid position in the matrix.
 *
 *
 * Example 1:
 *
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
 * Output: [[12,21,16],[27,45,33],[24,39,28]]
 * Example 2:
 *
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]], K = 2
 * Output: [[45,45,45],[45,45,45],[45,45,45]]
 *
 *
 * Constraints:
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n, K <= 100
 * 1 <= mat[i][j] <= 100
 */
public class MatrixBlockSum {

    public static int[][] matrixBlockSumII(int[][] mat, int K) {
        int m = mat.length, n = mat[0].length;
        int[][] rangeSum = new int[m + 1][n + 1];
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                rangeSum[i + 1][j + 1] = rangeSum[i + 1][j] + rangeSum[i][j + 1] - rangeSum[i][j] + mat[i][j];

        int[][] ans = new int[m][n];

        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j) {
                int r1 = Math.max(0, i - K), c1 = Math.max(0, j - K), r2 = Math.min(m, i + K + 1), c2 = Math.min(n, j + K + 1);
                ans[i][j] = rangeSum[r2][c2] - rangeSum[r2][c1] - rangeSum[r1][c2] + rangeSum[r1][c1];
            }
        return ans;
    }

    private static int[][] matrixBlockSum(int[][] mat, int K) {
        int[][] prefixMatrix = new int[mat.length + 1][mat[0].length + 1];

        //row wise prefix calc
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(j == 0){
                    prefixMatrix[i + 1][j + 1] = mat[i][j];
                    continue;
                }
                prefixMatrix[i + 1][j + 1] = prefixMatrix[i + 1][j] +  mat[i][j];
            }
        }

        //col wise prefix calc
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(i == 0){
                    continue;
                }
                prefixMatrix[i + 1][j + 1] += prefixMatrix[i][j + 1];
            }
        }

        //once we have calculated the prefix sum/matrix, we need to now find out the answer by finding the actual range given by K, using the above generated prefix matrix
        int[][] ans = new int[mat.length][mat[0].length];
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                int r1 = Math.max(0, i - K);
                int c1 = Math.max(0, j - K);
                int r2 = Math.min(mat.length, i + K + 1);
                int c2 = Math.min(mat[0].length, j + K + 1);

                ans[i][j] = prefixMatrix[r2][c2] - prefixMatrix[r2][c1] - prefixMatrix[r1][c2] + prefixMatrix[r1][c1];

            }
        }


        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int k = 1;

        int[][] result = matrixBlockSum(mat, k);

        System.out.println("The result : "+ result);
    }
}
