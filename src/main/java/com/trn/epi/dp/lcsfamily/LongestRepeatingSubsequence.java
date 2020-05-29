package com.trn.epi.dp.lcsfamily;

/**
 * https://www.geeksforgeeks.org/longest-repeating-subsequence/
 *
 * Given a string, find length of the longest repeating subseequence such that the two subsequence don’t have same string character at same position,
 * i.e., any i’th character in the two subsequences shouldn’t have the same index in the original string.
 *
 * Examples:
 *
 *
 *
 * Input: str = "abc"
 * Output: 0
 * There is no repeating subsequence
 *
 * Input: str = "aab"
 * Output: 1
 * The two subssequence are 'a'(first) and 'a'(second).
 * Note that 'b' cannot be considered as part of subsequence
 * as it would be at same index in both.
 *
 * Input: str = "aabb"
 * Output: 2
 *
 * Input: str = "axxxy"
 * Output: 2
 */
public class LongestRepeatingSubsequence {

    private int lengthOfLongestRepeatingSubsequence(String word1){

        int[][] dp = new int[word1.length() + 1][word1.length() + 1];

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(word1.charAt(i - 1) == word1.charAt(j - 1) && i != j){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    continue;
                }

                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[word1.length()][word1.length()];
    }

    public static void main(String[] args) {

        LongestRepeatingSubsequence l1 = new LongestRepeatingSubsequence();

        String word1 = "aabb";

        int result = l1.lengthOfLongestRepeatingSubsequence(word1);

        System.out.println("The length of LRS : "+ result);
    }
}
