package com.trn.epi.dp.lcsfamily;

/**
 * https://www.geeksforgeeks.org/minimum-number-deletions-make-string-palindrome/
 *
 * Given a string of size ‘n’. The task is to remove or delete minimum number of characters from the string so that the resultant string is palindrome.
 *
 * Note: The order of characters should be maintained.
 *
 * Examples :
 *
 * Input : aebcbda
 * Output : 2
 * Remove characters 'e' and 'd'
 * Resultant string will be 'abcba'
 * which is a palindromic string
 *
 * Input : geeksforgeeks
 * Output : 8
 */
public class MinNoOfDeletePalindrome {

    private int getMinNoOfDeletion(String word1){

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

        return word1.length() - dp[word1.length()][word2.length()];

    }

    public static void main(String[] args) {

        MinNoOfDeletePalindrome m1 = new MinNoOfDeletePalindrome();

        //String word1 = "aebcbda";

        String word1 = "geeksforgeeks";

        int result = m1.getMinNoOfDeletion(word1);

        System.out.println("The Min number of deletion is : " + result);
    }
}
