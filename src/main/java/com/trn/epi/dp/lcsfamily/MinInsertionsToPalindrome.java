package com.trn.epi.dp.lcsfamily;

/**
 * https://www.geeksforgeeks.org/minimum-insertions-to-form-a-palindrome-dp-28/
 *
 * Given a string str, the task is to find the minimum number of characters to be inserted to convert it to palindrome.
 * Before we go further, let us understand with few examples:
 *
 * ab: Number of insertions required is 1 i.e. bab
 * aa: Number of insertions required is 0 i.e. aa
 * abcd: Number of insertions required is 3 i.e. dcbabcd
 * abcda: Number of insertions required is 2 i.e. adcbcda which is same as number of insertions in the substring bcd(Why?).
 * abcde: Number of insertions required is 4 i.e. edcbabcde
 */
public class MinInsertionsToPalindrome {

    private int getMinNumberInsertToPalindrome(String word1){

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
        MinInsertionsToPalindrome m1 = new MinInsertionsToPalindrome();

        String word1 = "abcd";

        int result = m1.getMinNumberInsertToPalindrome(word1);

        System.out.println("Min number of inserts : " + result);
    }
}
