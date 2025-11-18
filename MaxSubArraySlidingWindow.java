package com.javastack.datastructures.slidingwindow;

public class MaxSubArraySlidingWindow
{
    public static void main(String[] args) {
        int[] arr = {1, 12, -5, -6, 50, 3};
        int k = 3;
        int sum = 0;
        int n = arr.length;
        int left = 0, right = k-1;
        for(int i=0; i<k ; i++)
        {
            sum += arr[i];
        }
        int maxSum = sum;
        while (right < n -1)
        {
            left++;right++;
            sum += arr[right] - arr[left - 1];
            maxSum = Math.max(maxSum, sum);
        }
        System.out.println("Average sum sub array : " + maxSum / k);
    }
}
