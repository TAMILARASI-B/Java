package intermediateoperations;

import java.util.*;
import java.util.stream.Collectors;

public class PeekExample {

	public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Peek to see the elements before filtering
        List<Integer> filteredNumbers = numbers.stream()
                                               .peek(n -> System.out.println("Before filtering: " + n))
                                               .filter(n -> n % 2 == 0)
                                               .collect(Collectors.toList());

        System.out.println("Filtered numbers: " + filteredNumbers);
    }
}
