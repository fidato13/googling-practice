package com.trn.epi.dp.lcsfamily;

/**
 *  https://www.geeksforgeeks.org/printing-longest-common-subsequence/
 *
 * Given two sequences, print the longest subsequence present in both of them.
 * Examples:
 * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 * LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 *
 */
public class PrintLCS {

    private String getLCS(String word1, String word2){
        int[][] dp = getLCSMatrix(word1, word2);

        StringBuilder sb = new StringBuilder();

        int i = dp.length - 1;
        int j = dp[0].length - 1;

        while(i > 0 && j > 0){
            if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                sb.append(word1.charAt(i - 1));
                i--;
                j--;
                continue;
            }

            if(dp[i][j - 1] > dp[i - 1][j]){
                j--;
            } else {
                i--;
            }
        }

        return sb.reverse().toString();
    }

    private int[][] getLCSMatrix(String word1, String word2){

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    continue;
                }

                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp;
    }

    public static void main(String[] args) {

        PrintLCS printLCS = new PrintLCS();

        String word1 = "AGGTAB";
        String word2 = "GXTXAYB";

        String result = printLCS.getLCS(word1, word2);

        System.out.println("The LCS is : "+ result);
    }
}
