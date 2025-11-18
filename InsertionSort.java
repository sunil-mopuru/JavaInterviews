package com.javastack.datastructures.sorting;

import java.util.Arrays;

/**
 * InsertionSort implementation demonstrating the insertion sort algorithm.
 * 
 * Insertion Sort is a simple sorting algorithm that builds the final sorted array
 * one item at a time. It works by taking elements from the unsorted portion and
 * inserting them into their correct position in the sorted portion.
 * 
 * The algorithm is similar to how people sort playing cards in their hands:
 * - Start with one card (already "sorted")
 * - Pick the next card and insert it in the correct position among the sorted cards
 * - Repeat until all cards are sorted
 * 
 * Time Complexity: O(n) best case (already sorted), O(n²) average and worst case
 * Space Complexity: O(1) - sorts in-place
 * 
 * Advantages: Simple implementation, efficient for small datasets, adaptive (performs well on nearly sorted arrays),
 *             stable (maintains relative order of equal elements), in-place, online (can sort as it receives data)
 * Disadvantages: Inefficient for large datasets due to O(n²) complexity
 * 
 * @author Your Name
 * @version 1.0
 */
public class InsertionSort {
    /**
     * Main method to demonstrate insertion sort algorithm.
     * Creates a sample array, displays it before and after sorting.
     */
    public static void main(String[] args) {
        // Initialize test array with unsorted integers
        int[] arr = {12, 11, 13, 5, 6};

        // Display array before sorting
        System.out.println("Before Sorting: " + Arrays.toString(arr));

        // Perform insertion sort
        insertionSort(arr);

        // Display array after sorting
        System.out.println("After Sorting: " + Arrays.toString(arr));

        // Test with another array to show versatility
        int[] arr2 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("\nAnother example:");
        System.out.println("Before Sorting: " + Arrays.toString(arr2));
        insertionSort(arr2);
        System.out.println("After Sorting: " + Arrays.toString(arr2));
    }

    /**
     * Implements the insertion sort algorithm to sort an array in ascending order.
     * <p>
     * Algorithm explanation:
     * - Start with second element (index 1) as the first element is considered sorted
     * - For each element, compare it with elements in the sorted portion (to its left)
     * - Shift larger elements one position to the right to make space
     * - Insert the current element in its correct position
     * - Continue until all elements are processed
     * <p>
     * Example walkthrough with [12, 11, 13, 5, 6]:
     * Initial: [12, 11, 13, 5, 6] (12 is considered sorted)
     * Pass 1: Insert 11 → [11, 12, 13, 5, 6]
     * Pass 2: Insert 13 → [11, 12, 13, 5, 6] (no change, already in position)
     * Pass 3: Insert 5 → [5, 11, 12, 13, 6]
     * Pass 4: Insert 6 → [5, 6, 11, 12, 13]
     *
     * @param arr The integer array to be sorted (modified in-place)
     */
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        // Start from second element (index 1) since single element is already sorted
        for (int i = 1; i < n; i++) {
            // Current element to be inserted into sorted portion
            int key = arr[i];

            // Initialize position for comparison (last element of sorted portion)
            int j = i - 1;

            // Move elements that are greater than key one position ahead
            // Continue while we haven't reached the beginning AND current element > key
            while (j >= 0 && arr[j] > key) {
                // Shift element one position to the right
                arr[j + 1] = arr[j];

                // Move to previous element for next comparison
                j--;
            }

            // Insert the key at its correct position
            // j+1 is the correct position because j was decremented after last valid position
            arr[j + 1] = key;

            // At this point, elements from arr[0] to arr[i] are sorted
            // Optional: Print array state after each insertion for educational purposes
            // System.out.println("After inserting " + key + ": " + Arrays.toString(arr));
        }
    }
}



