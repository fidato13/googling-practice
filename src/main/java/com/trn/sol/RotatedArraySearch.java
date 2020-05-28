package com.trn.sol;

public class RotatedArraySearch {

    public static int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + ((right - left) / 2);

            if(nums[mid] == target){
                //found it
                return mid;
            }

            if(nums[mid] > target){
                // mid is greater so target should be on left; however just check if the array is not rotated
                if(nums[right] > target){
                    //rotated , check on right array now
                    right = mid - 1;
                    continue;

                }
                left = mid + 1;
                continue;
            }

            if(nums[mid] < target){
                //target should be right ; however just check if it is not rotated
                if(nums[left] < target){
                    // rotated, check on left array now
                    left = mid + 1;
                    continue;

                }

                right = mid - 1;
                continue;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int result = search(new int[]{4,5,6,7,8,1,2,3}, 8);
        System.out.println("result => "+ result);

        String json = "{\"metadata\":{\"annotations\":{\"iam.amazonaws.com/role\":\"secret-manager-iam-role\"}}}";
    }
}
