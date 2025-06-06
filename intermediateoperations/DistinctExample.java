package intermediateoperations;

import java.util.*;
import java.util.stream.Collectors;

public class DistinctExample {

	 public static void main(String[] args) {
	        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);

	        // Remove duplicates
	        List<Integer> uniqueNumbers = numbers.stream()
	                                             .distinct()
	                                             .collect(Collectors.toList());

	        System.out.println(uniqueNumbers);
	    }
}
