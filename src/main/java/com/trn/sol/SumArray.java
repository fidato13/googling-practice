package com.trn.sol;

public class SumArray {

    public static int findBestValue(int[] arr, int target) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int num : arr){
            max = Math.max(max, num);
            sum += num;
        }

        if(sum == target){
            return max;
        }

        //range would be between 1 and max
        int left = 1;
        int right = max, diff = Integer.MAX_VALUE;

        int res = 1;

        while(left <= right){
            int mid = left + ((right - left) / 2);
            int currentDifference = getAbsoluteDifference(arr, mid, target);

            if(currentDifference > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }

            // If current difference is less than diff || current difference==diff but mid < res.(choose the smaller one.)
            if (Math.abs(currentDifference - target) < diff || (Math.abs(currentDifference - target) == diff && mid < res)) {
                res = mid;
                diff = Math.abs(currentDifference - target);
            }
        }

        return res;

    }

    private static int getAbsoluteDifference(int[] arr, int value, int target){
        int sum = 0;

        for(int num : arr){
            if(num > value){
                sum += value;
            } else {
                sum += num;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int result = findBestValue(new int[]{4,9,3}, 10);
        System.out.println("The result => "+ result);
    }
}
