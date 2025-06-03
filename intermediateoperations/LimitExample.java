package intermediateoperations;

import java.util.*;
import java.util.stream.Collectors;

public class LimitExample {

	 public static void main(String[] args) {
	        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

	        // Limit the stream to the first 3 elements
	        List<Integer> limitedNumbers = numbers.stream()
	                                              .limit(3)
	                                              .collect(Collectors.toList());

	        System.out.println(limitedNumbers);
	    }

}
