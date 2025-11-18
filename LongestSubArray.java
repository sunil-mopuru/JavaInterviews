package com.javastack.datastructures.hashmap;

import java.util.HashMap;

public class LongestSubArray
{
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    }

    private static int longestSubArray(int[] arr, int k) {

        HashMap<Long, Integer> map = new HashMap<>();

        map.put(0L, -1);

        int ans = 0;
        long sum = 0;

        for (int r = 0; r < arr.length; r++) {
            sum += arr[r];

            Integer l = map.get(sum - k);
            if (l != null) {
                ans = Math.max(ans, r - l);
            }
            map.putIfAbsent(sum, r);

        }
        return ans;
    }

}
