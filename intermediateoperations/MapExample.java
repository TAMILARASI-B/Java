package intermediateoperations;

import java.util.*;
import java.util.stream.Collectors;

public class MapExample {

	public static void main(String[] args) {
        List<String> words = Arrays.asList("java", "stream", "api");

        // Convert each word to uppercase
        List<String> upperCaseWords = words.stream()
                                           .map(String::toUpperCase)
                                           .collect(Collectors.toList());

        System.out.println(upperCaseWords);
    }
}
