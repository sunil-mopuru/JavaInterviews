package com.javastack.datastructures.test;

import java.util.Set;
import java.util.TreeSet;

public class UniquePermutations {
    public static void main(String[] args) {
        String s = "abc";
        Set<String> result = new TreeSet<>();
        generatePermutations(s.toCharArray(), 0, result);
        System.out.println(result);
    }

    private static void generatePermutations(char[] s, int index, Set<String> result) {
        if (index == s.length) {
            result.add(new String(s));
            return;
        }

        for (int i = index; i < s.length; i++) {
            swap(s, index, i);
            generatePermutations(s, index + 1, result);
            swap(s, index, i); // backtrack
        }
    }

    private static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
