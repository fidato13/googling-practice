package com.trn.epi.dp.mcmfamily;

/**
 * https://www.geeksforgeeks.org/palindrome-partitioning-dp-17/
 *
 * Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a palindrome.
 * For example, “aba|b|bbabb|a|b|aba” is a palindrome partitioning of “ababbbabbababa”.
 * Determine the fewest cuts needed for palindrome partitioning of a given string. For example, minimum 3 cuts are needed for “ababbbabbababa”.
 * The three cuts are “a|babbbab|b|ababa”. If a string is palindrome, then minimum 0 cuts are needed.
 * If a string of length n containing all different characters, then minimum n-1 cuts are needed.
 */
public class PalindromePartitioning {

    private int[][] dp;

    private int minPartitionsPalindrome(String word, int i, int j){

        if(i >= j){
            return 0;
        }

        if(isPalindrome(word, i , j)){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;

        for(int k = i; k < j; k++){
            int temp = minPartitionsPalindrome(word, i, k) +
                    minPartitionsPalindrome(word, k + 1, j) + 1;

            if(temp < min){
                min = temp;
            }
        }

        return dp[i][j] = min;
    }

    private boolean isPalindrome(String word, int i, int j){

        while(i < j){
            if(word.charAt(i) != word.charAt(j)){
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {

        PalindromePartitioning p1 = new PalindromePartitioning();

        String word = "ababbbabbababa";

        p1.dp = new int[word.length() + 1][word.length() + 1];

        for(int i = 0; i < p1.dp.length; i++){
            for(int j = 0; j < p1.dp[0].length; j++){
                p1.dp[i][j] = -1;
            }
        }

        int result = p1.minPartitionsPalindrome(word, 0, word.length() - 1);

        System.out.println("The min # of partitions are : "+result);
    }
}
