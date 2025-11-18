package com.javastack.datastructures.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(subsets(arr));
    }

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        recursive(nums,0,subset, subsets);
        return subsets;
    }

    private static void recursive(int[] nums, int idx, List<Integer> subset, List<List<Integer>> subsets)
    {
        // Yes choice
        if(idx == nums.length)
        {
            subsets.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[idx]);
        recursive(nums,idx+1,subset,subsets);
        subset.remove(subset.size()-1); // backtracking (removing while returning)

        // No Choice
        recursive(nums,idx+1,subset,subsets);
    }
}
