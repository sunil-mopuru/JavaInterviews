package com.javastack.datastructures.search;

public class FindClosest
{
    public static void main(String[] args) {
        int[] nums = {-5, -2, 0, 4, 6, 10};
        int target = 5;
        System.out.println(findClosest(nums, target));
    }

    private static int findClosest(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        if(target < nums[left]) return nums[left];
        if(target > nums[right]) return nums[right];

        while(left<=right)
        {
            int mid = (left+right)/2;
            if(nums[mid]==target) return nums[mid];
            else if(nums[mid]<target) left = mid+1;
            else right = mid-1;
        }

        // At this point, right < left
        // closest may be nums[left] or nums[right]
        if (Math.abs(nums[left] - target) < Math.abs(nums[right] - target)) {
            return nums[left];
        }
        return nums[right];
    }
}
