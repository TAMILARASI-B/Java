package intermediateoperations;

import java.util.*;
import java.util.stream.Collectors;

public class SkipExample {

	 public static void main(String[] args) {
	        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

	        // Skip the first 5 elements
	        List<Integer> skippedNumbers = numbers.stream()
	                                              .skip(5)
	                                              .collect(Collectors.toList());

	        System.out.println(skippedNumbers);
	    }

}
