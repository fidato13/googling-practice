package com.trn.epi.dp.lcsfamily;

/**
 * https://www.geeksforgeeks.org/minimum-number-deletions-insertions-transform-one-string-another/
 *
 * Given two strings ‘str1’ and ‘str2’ of size m and n respectively.
 * The task is to remove/delete and insert minimum number of characters from/in str1 so as to transform it into str2.
 * It could be possible that the same character needs to be removed/deleted from one point of str1 and inserted to some another point.
 *
 * Examples:
 *
 * Input : str1 = "heap", str2 = "pea"
 * Output : Minimum Deletion = 2 and
 *          Minimum Insertion = 1
 * p and h deleted from heap
 * Then, p is inserted at the beginning
 * One thing to note, though p was required yet
 * it was removed/deleted first from its position and
 * then it is inserted to some other position.
 * Thus, p contributes one to the deletion_count
 * and one to the insertion_count.
 *
 * Input : str1 = "geeksforgeeks", str2 = "geeks"
 * Output : Minimum Deletion = 8
 *          Minimum Insertion = 0
 */
public class MinNumberInsertDelete {

    private int getLCS(String word1, String word2){

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

        MinNumberInsertDelete m1 = new MinNumberInsertDelete();

//        String word1 = "heap";
//        String word2 = "pea";

        String word1 = "geeksforgeeks";
        String word2 = "geeks";

        int result = m1.getLCS(word1, word2);

        System.out.println("Min # of delete are : "+ (word1.length() - result));
        System.out.println("Min # of Insert are : "+ (word2.length() - result));

    }
}
