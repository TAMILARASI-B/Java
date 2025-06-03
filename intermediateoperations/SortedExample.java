package intermediateoperations;

import java.util.*;
import java.util.stream.Collectors;

public class SortedExample {
	 public static void main(String[] args) {
	        List<String> names = Arrays.asList("Rahul", "Amit", "Deepa", "Suresh");

	        // Sort names in alphabetical order
	        List<String> sortedNames = names.stream()
	                                        .sorted()
	                                        .collect(Collectors.toList());

	        System.out.println(sortedNames);
	    }
}
