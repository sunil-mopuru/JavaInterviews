package com.javastack.datastructures.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeadersInArray {
    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        List<Integer> leaders = findLeaders(arr);

        for (int num : leaders) {
            System.out.print(num + " ");
        }
    }

    public static List<Integer> findLeaders(int[] arr) {
        List<Integer> result = new ArrayList<>();
        int n = arr.length;

        int maxFromRight = arr[n - 1];  // Rightmost element is always a leader
        result.add(maxFromRight);

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= maxFromRight) {
                maxFromRight = arr[i];
                result.add(maxFromRight);
            }
        }

        Collections.reverse(result); // Reverse to get leaders in original order
        return result;
    }
}
