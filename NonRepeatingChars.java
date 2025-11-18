package com.javastack.datastructures.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class NonRepeatingChars {
    public static List<Character> findNonRepeatingChars(String input) {
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

        List<Character> nonRepeatingChars = new ArrayList<>();
        while (!queue.isEmpty()) {
            nonRepeatingChars.add(queue.poll());
        }
        return nonRepeatingChars;
    }

    public static void main(String[] args) {
        String input = "swiss";
        List<Character> result = findNonRepeatingChars(input);
        System.out.println("Non-repeating characters: " + result);
    }
}
