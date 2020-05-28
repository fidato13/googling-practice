package com.trn.sol;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    private static Set<String> dictSet;
    public static boolean wordBreak(String s, List<String> wordDict) {

        dictSet = new HashSet<>(wordDict);


        return helper(s);
    }

    private static boolean helper(String s){
        if(s.length() == 0 || dictSet.contains(s)){
            return true;
        }

        boolean subResult = false;
        for(int i = 0; i < s.length(); i++){
            if(dictSet.contains(s.substring(0, i + 1))){
                subResult =  helper(s.substring(i+1));
            }

            if(subResult){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        boolean result = wordBreak("leetcode", Arrays.asList("leet", "code"));
        System.out.println("Result => "+ result);
    }
}
