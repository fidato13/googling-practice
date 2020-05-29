package com.trn.epi.dp.lcsfamily;

/**
 * https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
 *
 * LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them.
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
 * For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
 *
 * Example:
 * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 * LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 *
 *
 */
public class LongestCommonSubsequence {

    private int lengthOfLCS(String word1, String word2){

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    continue;
                }

                dp[i][j] = Math.max(dp[i-1][j], dp[i][j - 1]);
            }
        }

        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {

        LongestCommonSubsequence lcs = new LongestCommonSubsequence();

//        String word1 = "ABCDGH";
//        String word2 = "AEDFHR";

        String word1 = "AGGTAB";
        String word2 = "GXTXAYB";

        int result = lcs.lengthOfLCS(word1, word2);

        System.out.println("The length of LCS is : "+ result);
    }
}
