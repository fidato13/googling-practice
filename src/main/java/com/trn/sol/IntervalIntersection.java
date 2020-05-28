package com.trn.sol;

import java.util.*;

public class IntervalIntersection {

    public static int longestValidParentheses(String s) {
        int globalLongest = 0;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        //track the index of '('
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
                continue;
            }

            if(s.charAt(i) == ')'){
                //either it corresponds to something in stack
                if(!stack.isEmpty()){
                    Integer index = stack.pop();
                    map.put(index, i);
                    continue;
                }

                //or else it is an unexpected one , simply ignored
            }
        }

        //now evaluate and find the longest interval
        int previousEnd = -1;
        int previousLength = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(previousEnd >=   entry.getValue()){
                //skip as the range is already covered
                continue;
            }

            // if current start is previousEnd + 1; then add previousLength
            if(entry.getKey() == previousEnd + 1){
                int totalCurrentLength = 1 + previousLength + entry.getValue() - entry.getKey();
                previousEnd =   entry.getValue();
                previousLength = totalCurrentLength;
                globalLongest = Math.max(globalLongest, totalCurrentLength);
                continue;
            }

            // if they are disjoint
            int totalCurrentLength = 1 +  entry.getValue() - entry.getKey();
            previousEnd =   entry.getValue();
            previousLength = totalCurrentLength;
            globalLongest = Math.max(globalLongest, totalCurrentLength);
        }

        return globalLongest;

    }

    public static void main(String[] args) {
        int result  = longestValidParentheses("");
        System.out.println("The result => "+result);
    }
}
