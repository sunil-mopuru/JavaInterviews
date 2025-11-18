package com.javastack.datastructures.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 7, 9, 0, 2, 4, 6, 8};
        System.out.println(Arrays.toString(sortArray(nums)));

    }

    public static void quickSort(int[] nums, int start, int end) {
        if(start>=end) return;

        int i=start, l =start, r =end, pivot = nums[end];
        while (i<=r)
        {
            if(nums[i] < pivot) {
                swap(nums, i, l);
                i++; l++;
            }
            else if(nums[i] > pivot) {
                swap(nums, i, r);
                r--;
            }
            else i++;
        }
        quickSort(nums, start, l-1);
        quickSort(nums, r+1, end);
    }

    public static void swap(int[] nums, int p1, int p2)
    {
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }

    public static int[] sortArray(int[] nums)
    {
        quickSort(nums,0,nums.length-1);
        return nums;
    }
}
