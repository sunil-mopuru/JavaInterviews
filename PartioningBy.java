package com.javastack.collections.streamsapi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartioningBy {
    public static void main(String[] args) {

        List<Integer> al = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Map<Boolean, List<Integer>> map = al.stream()
                .collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println(map.get(true));
    }
}
