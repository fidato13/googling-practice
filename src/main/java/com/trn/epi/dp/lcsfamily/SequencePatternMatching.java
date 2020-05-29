package com.trn.epi.dp.lcsfamily;

/**
 * Given two strings A: "AXY" & B: "ADXCYB" , Return true or false depending upon whether A is a subsequence of B
 *
 * Example:
 * A : "AXY"
 * B : "ADXCYB"
 *
 * Output: True
 */
public class SequencePatternMatching {

    private boolean isALCSOfB(String word1, String word2){
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(word1.charAt( i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    continue;
                }

                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[word1.length()][word2.length()] == word1.length();
    }

    public static void main(String[] args) {

        SequencePatternMatching s1 = new SequencePatternMatching();

        String word1 = "AXY";
        String word2 = "ADXCYB";

        boolean result = s1.isALCSOfB(word1, word2);

        System.out.println("A is a subsequence of B : "+ result);
    }
}
