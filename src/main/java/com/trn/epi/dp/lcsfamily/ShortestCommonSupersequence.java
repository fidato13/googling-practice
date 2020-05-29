package com.trn.epi.dp.lcsfamily;

/**
 * https://www.geeksforgeeks.org/shortest-common-supersequence/
 *
 * Given two strings str1 and str2, find the shortest string that has both str1 and str2 as subsequences.
 * Examples :
 *
 * Input:   str1 = "geek",  str2 = "eke"
 * Output: "geeke"
 *
 * Input:   str1 = "AGGTAB",  str2 = "GXTXAYB"
 * Output:  "AGXGTXAYB"
 *
 */
public class ShortestCommonSupersequence {

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

    private String printSCS(String word1, String word2){
        int[][] dp = getLCSMatrix(word1, word2);

        int i = dp.length - 1;
        int j = dp[0].length - 1;

        StringBuilder sb = new StringBuilder();

        while(i > 0 && j > 0){
            if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                sb.append(word1.charAt(i - 1));
                i--;
                j--;
                continue;
            }

            if(dp[i][j - 1] > dp[i - 1][j]){
                sb.append(word2.charAt(j - 1));
                j--;
            } else {
                sb.append(word1.charAt(i - 1));
                i--;
            }
        }

        while(i > 0){
            sb.append(word1.charAt(i - 1));
            i--;
        }

        while(j > 0){
            sb.append(word2.charAt(j - 1));
            j--;
        }

        return sb.reverse().toString();
    }

    private int lengthOfSCS(String word1, String word2){
        int[][] dp = getLCSMatrix(word1, word2);

        return word1.length() + word2.length() - dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {

        ShortestCommonSupersequence s1 = new ShortestCommonSupersequence();

//        String word1 = "AGGTAB";
//        String word2 = "GXTXAYB";

        String word1 = "geek";
        String word2 = "eke";

        int lengthOfSCS = s1.lengthOfSCS(word1, word2);
        String scs = s1.printSCS(word1, word2);

        System.out.println("The SCS is : "+ scs);
        System.out.println("The length of SCS is : "+ lengthOfSCS);

    }
}
