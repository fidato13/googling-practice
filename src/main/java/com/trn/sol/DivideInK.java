package com.trn.sol;

import java.util.TreeMap;

public class DivideInK {

    public static boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length % k != 0) return false;
        TreeMap<Integer,Integer> map = new TreeMap<Integer, Integer>();

        for(int x: nums) {
            map.put(x,map.getOrDefault(x,0)+1);
        }

        for(int n: map.keySet()){
            int curr = map.get(n);

            if(curr == 0) continue;

            for(int i = n; i < k + n; i++){
                if(!map.containsKey(i) || map.get(i) <= 0)
                    return false;
                map.put(i,map.get(i) - curr);

            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,3,4,4,5,6};
        boolean result = isPossibleDivide(nums, 4);
        System.out.println("result => "+ result);
    }
}
