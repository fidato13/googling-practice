package com.trn.epi.dp.lcsfamily;

/**
 * https://www.geeksforgeeks.org/longest-common-substring-dp-29/
 *
 * Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
 *
 * Example:
 * Input : X = “GeeksforGeeks”, y = “GeeksQuiz”
 * Output : 5
 * The longest common substring is “Geeks” and is of length 5.
 *
 * Input : X = “abcdxyz”, y = “xyzabcd”
 * Output : 4
 * The longest common substring is “abcd” and is of length 4.
 *
 * Input : X = “zxabcdezy”, y = “yzabcdezx”
 * Output : 6
 * The longest common substring is “abcdez” and is of length 6.
 */
public class LongestCommonSubstring {

    private int globalResult = 0;

    private int lengthOfLCSubstring(String word1, String word2){

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    globalResult = Math.max(globalResult, dp[i][j]);
                    continue;
                }

                dp[i][j] = 0;
            }
        }

        return globalResult;
    }

    public static void main(String[] args) {

        LongestCommonSubstring longestCommonSubstring = new LongestCommonSubstring();

        String word1 = "zxabcdezy";
        String word2 = "yzabcdezx";

        int result = longestCommonSubstring.lengthOfLCSubstring(word1, word2);

        System.out.println("The longest Common Substring's length is : "+ result);
    }
}
