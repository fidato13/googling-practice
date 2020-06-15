package com.trn.epi.dp.fibonaccifamily;

/**
 * https://leetcode.com/problems/decode-ways/
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * Example 1:
 *
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 *
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class DecodeWays {

    private static int numDecodings(String s) {
        int[] lookup = new int[s.length() + 1];

        lookup[0] = 1; //empty string
        // one char
        lookup[1] = s.charAt(0) != '0' ? 1 : 0;

        for(int i = 2; i < lookup.length; i++){
            // lookup[i] = lookup[i - 1] + lookup[i - 2];
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            if(first >= 1 && first <= 9) {
                lookup[i] += lookup[i-1];
            }
            if(second >= 10 && second <= 26) {
                lookup[i] += lookup[i-2];
            }
        }

        return lookup[lookup.length - 1];
    }

    public static void main(String[] args) {

        String s = "226";

        int result = numDecodings(s);

        System.out.println("The result : "+ result);
    }
}
