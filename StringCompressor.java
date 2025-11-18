package com.javastack.collections.streamsapi;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringCompressor {
    public static void main(String[] args) {

        String input = "aabcccccaaa";
        System.out.println(compressByFrequency(input));
    }
    public static String compressByFrequency(String input) {
        return input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .map(e -> e.getKey() + String.valueOf(e.getValue()))
                .collect(Collectors.joining());
    }
}
