package com.javastack.datastructures.sorting;

import java.util.Arrays;

/**
 * SelectionSort implementation demonstrating the selection sort algorithm.
 * 
 * Selection Sort is a simple sorting algorithm that divides the input list into two parts:
 * - A sorted portion (initially empty, grows from left to right)
 * - An unsorted portion (initially the entire list, shrinks from right to left)
 * 
 * The algorithm repeatedly finds the minimum element from the unsorted portion
 * and places it at the beginning of the unsorted portion (end of sorted portion).
 * 
 * Time Complexity: O(n²) in all cases (best, average, and worst)
 * Space Complexity: O(1) - sorts in-place
 * 
 * Advantages: Simple implementation, performs well on small lists, in-place sorting
 * Disadvantages: Inefficient for large datasets, not stable (doesn't preserve relative order)
 * 
 * @author Your Name
 * @version 1.0
 */
public class SelectionSort {
    
    /**
     * Main method to demonstrate selection sort algorithm.
     * Creates a sample array, displays it before and after sorting.
     */
    public static void main(String[] args) {
        // Initialize test array with unsorted integers
        int[] arr = {64, 25, 12, 22, 11};
        
        // Display array before sorting
        System.out.println("Before Sorting: " + Arrays.toString(arr));
        
        // Perform selection sort
        selectionSort(arr);
        
        // Display array after sorting
        System.out.println("After Sorting: " + Arrays.toString(arr));
    }
    
    /**
     * Implements the selection sort algorithm to sort an array in ascending order.
     * 
     * Algorithm explanation:
     * - Outer loop maintains the boundary between sorted and unsorted portions
     * - For each position in the sorted portion, find the minimum element from unsorted portion
     * - Swap the minimum element with the current position
     * - After each iteration, the sorted portion grows by one element
     * 
     * Example: [64, 25, 12, 22, 11]
     * Pass 1: Find min(64,25,12,22,11)=11, swap with arr[0] → [11, 25, 12, 22, 64]
     * Pass 2: Find min(25,12,22,64)=12, swap with arr[1] → [11, 12, 25, 22, 64]
     * Pass 3: Find min(25,22,64)=22, swap with arr[2] → [11, 12, 22, 25, 64]
     * Pass 4: Find min(25,64)=25, no swap needed → [11, 12, 22, 25, 64]
     * 
     * @param arr The integer array to be sorted (modified in-place)
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        
        // Outer loop: move boundary of unsorted subarray
        // i represents the current position where minimum element should be placed
        for (int i = 0; i < n - 1; i++) {
            
            // Find the minimum element in the remaining unsorted array
            int minIndex = i; // Assume first element of unsorted portion is minimum
            
            // Inner loop: search for minimum element in unsorted portion
            // Start from i+1 because arr[i] is already considered as minimum
            for (int j = i + 1; j < n; j++) {
                // If current element is smaller than assumed minimum, update minIndex
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            
            // Swap the found minimum element with the first element of unsorted portion
            // Only swap if minimum element is not already at correct position
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
            
            // At this point, arr[0] to arr[i] are sorted
            // arr[i+1] to arr[n-1] are unsorted
        }
    }
    
    /**
     * Utility method to swap two elements in an array.
     * Uses temporary variable to perform the swap operation safely.
     * 
     * @param arr The array containing elements to swap
     * @param i   Index of first element to swap
     * @param j   Index of second element to swap
     */
    private static void swap(int[] arr, int i, int j) {
        // Store first element in temporary variable to prevent data loss
        int temp = arr[i];
        
        // Move second element to first position
        arr[i] = arr[j];
        
        // Move first element (from temp) to second position
        arr[j] = temp;
    }
}