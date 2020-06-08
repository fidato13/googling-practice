package com.trn.epi.dp.lcsfamily;

/**
 * https://leetcode.com/problems/distinct-subsequences/
 *
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
 *
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 *
 * It's guaranteed the answer fits on a 32-bit signed integer.
 *
 * Example 1:
 *
 * Input: S = "rabbbit", T = "rabbit"
 * Output: 3
 * Explanation:
 * As shown below, there are 3 ways you can generate "rabbit" from S.
 * (The caret symbol ^ means the chosen letters)
 *
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 * Example 2:
 *
 * Input: S = "babgbag", T = "bag"
 * Output: 5
 * Explanation:
 * As shown below, there are 5 ways you can generate "bag" from S.
 * (The caret symbol ^ means the chosen letters)
 *
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 *   ^  ^^
 * babgbag
 *     ^^^
 */
public class DistinctSubsequences {

    // https://leetcode.com/problems/distinct-subsequences/discuss/37327/Easy-to-understand-DP-in-Java/239647
    private static int numDistinct(String S, String T) {
        /**
         **
         lets see if T[i] != S[j]
         then we stil have to find the entire T in a subset of S[j-1] hence it will be listed as
         dp[i,j] = dp[i,j-1] // i.e. ignore the jth character in S.
         now if T[i] == S[j] it means we have a choice, either we take the jth character to find the entire T or we do not take the jth character to find the entire T.
         If we take the jth character - that means now we have to find a solution to T[i-1] (because T[i] == S[j]))
         If we do not take the jth character - that means now we have to find a solution to T[i] from S[j-1] (not taking the jth character).
         The total number of permutations would be = permutations with considering the jth character + permutations without considering the jth character.
         Hence in this case dp[i,j] = dp[i-1,j-1] + dp[i,j-1].
         **/

        // array creation
        int[][] mem = new int[T.length()+1][S.length()+1];

        // filling the first row: with 1s
        for(int j=0; j<=S.length(); j++) {
            mem[0][j] = 1;
        }

        // the first column is 0 by default in every other rows but the first, which we need.

        for(int i=1; i<=T.length(); i++) {
            for(int j=1; j<=S.length(); j++) {
                if(T.charAt(i - 1) == S.charAt(j - 1)) {
                    mem[i][j] = mem[i - 1][j - 1] + mem[i][j - 1];
                } else {
                    mem[i][j] = mem[i][j - 1];
                }
            }
        }

        return mem[T.length()][S.length()];
    }

    public static void main(String[] args) {

        String S = "RABBBIT";
        String T = "RABBIT";

        int result = numDistinct(S, T);

        System.out.println("The result :  "+result);

    }
}
