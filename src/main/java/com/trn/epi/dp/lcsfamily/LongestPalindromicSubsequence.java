package com.trn.epi.dp.lcsfamily;

/**
 * https://www.geeksforgeeks.org/longest-palindromic-subsequence-dp-12/
 *
 * Given a sequence, find the length of the longest palindromic subsequence in it.
 *
 * example, if the given sequence is “BBABCBCAB”, then the output should be 7 as “BABCBAB” is the longest palindromic subseuqnce in it.
 * “BBBBB” and “BBCBB” are also palindromic subsequences of the given sequence, but not the longest ones.
 */
public class LongestPalindromicSubsequence {

    private int getLengthOfLPS(String word1){

        String word2 = new StringBuilder(word1).reverse().toString();

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

        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {

        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();

        String word = "BBABCBCAB";

        int result = lps.getLengthOfLPS(word);

        System.out.println("The length of LPS : "+ result);


    }
}
