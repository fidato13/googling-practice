package com.trn.epi.dp.mcmfamily;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/
 *
 * Given a sequence of matrices, find the most efficient way to multiply these matrices together.
 * The problem is not actually to perform the multiplications, but merely to decide in which order to perform the multiplications.
 *
 * We have many options to multiply a chain of matrices because matrix multiplication is associative.
 * In other words, no matter how we parenthesize the product, the result will be the same. For example, if we had four matrices A, B, C, and D, we would have:
 *
 *     (ABC)D = (AB)(CD) = A(BCD) = ....
 * However, the order in which we parenthesize the product affects the number of simple arithmetic operations needed to compute the product, or the efficiency.
 * For example, suppose A is a 10 × 30 matrix, B is a 30 × 5 matrix, and C is a 5 × 60 matrix. Then,
 *
 *     (AB)C = (10×30×5) + (10×5×60) = 1500 + 3000 = 4500 operations
 *     A(BC) = (30×5×60) + (10×30×60) = 9000 + 18000 = 27000 operations.
 * Clearly the first parenthesization requires less number of operations.
 *
 * -------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * Given an array p[] which represents the chain of matrices such that the ith matrix Ai is of dimension p[i-1] x p[i].
 * We need to write a function MatrixChainOrder() that should return the minimum number of multiplications needed to multiply the chain.
 *
 *  Input: p[] = {40, 20, 30, 10, 30}
 *   Output: 26000
 *   There are 4 matrices of dimensions 40x20, 20x30, 30x10 and 10x30.
 *   Let the input 4 matrices be A, B, C and D.  The minimum number of
 *   multiplications are obtained by putting parenthesis in following way
 *   (A(BC))D --> 20*30*10 + 40*20*10 + 40*10*30
 *
 *   Input: p[] = {10, 20, 30, 40, 30}
 *   Output: 30000
 *   There are 4 matrices of dimensions 10x20, 20x30, 30x40 and 40x30.
 *   Let the input 4 matrices be A, B, C and D.  The minimum number of
 *   multiplications are obtained by putting parenthesis in following way
 *   ((AB)C)D --> 10*20*30 + 10*30*40 + 10*40*30
 *
 *   Input: p[] = {10, 20, 30}
 *   Output: 6000
 *   There are only two matrices of dimensions 10x20 and 20x30. So there
 *   is only one way to multiply the matrices, cost of which is 10*20*30
 */
public class MCM {

    private int[][] dp;

    private int getMinMCMCost(int[] arr, int i, int j){

        if(i >= j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;

        for(int k = i; k < j; k++){
            int temp = getMinMCMCost(arr, i, k) +
                    getMinMCMCost(arr, k + 1, j) +
                    arr[i - 1] * arr[k] * arr[j];

            if(temp < min){
                min = temp;
            }
        }

        return dp[i][j] = min;

    }

    public static void main(String[] args) {

        MCM mcm = new MCM();
        int[] arr = new int[]{40, 20, 30, 10, 30};

        mcm.dp = new int[arr.length + 1][arr.length + 1];

        for(int i = 0; i < mcm.dp.length; i++){
            for(int j = 0; j < mcm.dp[0].length; j++){
                mcm.dp[i][j] = -1;
            }
        }

        int result = mcm.getMinMCMCost(arr, 1, arr.length - 1);

        System.out.println("The min cost for MCM : "+result);
    }
}
