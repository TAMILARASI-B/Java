package intermediateoperations;

import java.util.*;
import java.util.stream.Collectors;

public class FlatMapExample {

	 public static void main(String[] args) {
	        List<List<String>> nestedList = Arrays.asList(
	                Arrays.asList("Java", "Python"),
	                Arrays.asList("C++", "Go")
	        );

	        // Flatten the nested list
	        List<String> flatList = nestedList.stream()
	                                          .flatMap(List::stream)
	                                          .collect(Collectors.toList());

	        System.out.println(flatList);
	    }
}
