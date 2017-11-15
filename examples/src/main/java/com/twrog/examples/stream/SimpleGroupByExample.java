package com.twrog.examples.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SimpleGroupByExample {

    public static void main(String[] args) {
	List<String> strs = Arrays.asList("hello", "world", "highway", "waterfall");
	Map<Character, List<String>> byFirstLetter = strs.stream().collect(Collectors.groupingBy(s -> s.charAt(0)));
	List<String> h = byFirstLetter.get('h');
	for (String s : h) {
	    System.out.println(s);
	}
    }

}