package com.javastack.datastructures.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {

        int[] arr = {1,2,3};
        System.out.println(permutations(arr));
    }

    private static List<List<Integer>> permutations(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for(int i=0; i<nums.length; i++) output.add(null); // creating empty output list with same input size
        recursive(nums,0,output,permutations);
        return permutations;
    }

    private static void recursive(int[] nums, int idx, List<Integer> output, List<List<Integer>> permutations)
    {
        if(idx == nums.length)
        {
            permutations.add(new ArrayList<>(output));
            return;
        }

        for(int j=0; j < nums.length ; j++)
        {
            if(output.get(j) == null)
            {
                output.set(j,nums[idx]);
                recursive(nums,idx+1,output,permutations);
                output.set(j,null); // backtracking (setting null while returning)
            }
        }
    }
}
