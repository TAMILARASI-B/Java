package intermediateoperations;

import java.util.*;
import java.util.stream.Collectors;

public class FilterExample {

	public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Filter even numbers
        List<Integer> evenNumbers = numbers.stream()
                                           .filter(n -> n % 2 == 0)
                                           .collect(Collectors.toList());

        System.out.println(evenNumbers);
    

	}

}
