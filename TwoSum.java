package com.javastack.datastructures.twopointer;

public class TwoSum
{
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                break;
            } else if (sum < target) {
                left++;
            } else  right--;
        }
        System.out.println((left + 1) + " " + (right + 1));
    }
}
