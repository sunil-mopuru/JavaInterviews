package com.javastack.datastructures.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 7, 9, 0, 2, 4, 6, 8};
        System.out.println(Arrays.toString(sortArray(nums)));
    }

    public static int[] mergeSort(int[] nums, int l, int r) {
        if(l==r) return new int[]{nums[l]};

        int mid = (l + r) / 2;
        int[] left = mergeSort(nums, l, mid);
        int[] right = mergeSort(nums, mid + 1, r);
        return merge(left, right);
    }

    public static int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] res =new int[m+n];
        int p1 =0, p2 =0;

        for(int i=0; i<m+n; i++){
            int first = (p1==m) ? Integer.MAX_VALUE : nums1[p1];
            int second = (p2==n) ? Integer.MAX_VALUE : nums2[p2];

            if(first <= second)
            {
                res[i] = first; p1++;
            }
            else
            {
                res[i] = second; p2++;
            }
        }

        return res;
    }

    public static int[] sortArray(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
}
