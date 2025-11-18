package com.javastack.datastructures.test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FirstNonRepeatingCharSinglePass {
    public static char findFirstNonRepeating(String input) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();

        for (char c : input.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
            if (frequencyMap.get(c) == 1) {
                queue.offer(c);
            } else {
                queue.remove(c);
            }
        }

        return queue.isEmpty() ? '$' : queue.peek();
    }

    public static void main(String[] args) {
        String input = "swiss";
        System.out.println("First non-repeating character: " + findFirstNonRepeating(input));
    }
}
