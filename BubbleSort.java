package com.javastack.datastructures.sorting;

import java.util.Arrays;

/**
 * BubbleSort implementation demonstrating the bubble sort algorithm.
 * 
 * Bubble Sort is a simple sorting algorithm that repeatedly steps through the list,
 * compares adjacent elements and swaps them if they are in the wrong order.
 * The pass through the list is repeated until the list is sorted.
 * 
 * Time Complexity: O(n²) in worst and average cases, O(n) in best case (already sorted)
 * Space Complexity: O(1) - sorts in-place
 * 
 * @author Your Name
 * @version 1.0
 */
public class BubbleSort
{
    /**
     * Main method to demonstrate bubble sort algorithm
     * Creates a sample array, displays it before and after sorting
     */
    public static void main(String[] args) {
        // Initialize test array with unsorted integers
        int[] arr = {40,10,30,20,50};
        
        // Display array before sorting
        System.out.println("Before Sorting: " + Arrays.toString(arr));
        
        // Perform bubble sort
        sort(arr);
        
        // Display array after sorting
        System.out.println("After Sorting: " + Arrays.toString(arr));
    }

    /**
     * Implements the bubble sort algorithm to sort an array in ascending order.
     * 
     * Algorithm explanation:
     * - Uses nested loops where outer loop controls the number of passes
     * - Inner loop performs comparisons and swaps adjacent elements
     * - After each pass, the largest element "bubbles up" to its correct position
     * - Number of comparisons reduces after each pass as sorted elements are excluded
     * 
     * @param arr The integer array to be sorted (modified in-place)
     */
    private static void sort(int[] arr) {
        int n = arr.length;
        
        // Outer loop: controls number of passes (n-1 passes needed)
        // j starts from 1 because after each pass, one element is in correct position
        for(int j = 1; j < n; j++)
        {
            // Inner loop: performs comparisons and swaps
            // Loop boundary decreases (n-j) as sorted elements are excluded from comparison
            for(int i = 0; i < n - j; i++)
            {
                // Compare adjacent elements and swap if left element is greater than right
                // This ensures larger elements move towards the end (ascending order)
                if(arr[i] > arr[i+1])
                {
                    swap(arr, i, i+1);
                }
            }
        }
    }

    /**
     * Utility method to swap two elements in an array.
     * Uses temporary variable to perform the swap operation.
     * 
     * @param arr The array containing elements to swap
     * @param a   Index of first element to swap
     * @param b   Index of second element to swap
     */
    private static void swap(int[] arr, int a, int b) {
        // Store first element in temporary variable
        int temp = arr[a];
        
        // Move second element to first position
        arr[a] = arr[b];
        
        // Move first element (from temp) to second position
        arr[b] = temp;
    }
}