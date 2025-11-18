package com.javastack.datastructures.test;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingChar {
    public static char findFirstNonRepeating(String input) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : input.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return '$'; // Return '$' if no non-repeating character is found
    }

    public static void main(String[] args) {
        String input = "swiss";
        System.out.println("First non-repeating character: " + findFirstNonRepeating(input));
    }
}
