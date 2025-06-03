package intermediateoperations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainExample {
    public static void main(String[] args) {
        List<List<Integer>> numbers = Arrays.asList(
                Arrays.asList(1, 9, 3, 2, 3, 4, 4, 5, 6, 7, 8, 9, 10),
                Arrays.asList(1, 2, 3, 5, 7)
        );

        // Filter even numbers, map, skip, sort, distinct, and limit
        List<Integer> evenNumbers = numbers.stream()
                .flatMap(List::stream)//nested list to single stream
                .peek(n -> System.out.println("Before filtering: " + n))// Peek to see the elements before filtering
                .filter(n -> n % 2 == 0)//2,4,4,6,8,10,2
                .map(n -> n * 3)//6,12,12,18,24,30,6
                .skip(4)//skip first 4 elements=>24,30,6
                .sorted()//6,24,30
                .distinct()//all are unique
                .limit(2)//take only 2 elements=>6,24
                .collect(Collectors.toList());

        System.out.println(evenNumbers);
    }
}
