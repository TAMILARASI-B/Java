package TerminalOperations;


import java.util.*;
import java.util.stream.*;

public class MainExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 3, 7, 2, 8, 10, 1, 4, 6, 9);

        // 1. anyMatch() - checks if any number is even
        boolean anyEven = numbers.stream().anyMatch(n -> n % 2 == 0);
        System.out.println("Any even number? " + anyEven);

        // 2. allMatch() - checks if all numbers are less than 20
        boolean allLessThan20 = numbers.stream().allMatch(n -> n < 20);
        System.out.println("All numbers < 20? " + allLessThan20);

        // 3. noneMatch() - checks if no number is negative
        boolean noneNegative = numbers.stream().noneMatch(n -> n < 0);
        System.out.println("No negative numbers? " + noneNegative);

        // 4. collect() - collect even numbers into a List
        List<Integer> evens = numbers.stream()
                                     .filter(n -> n % 2 == 0)
                                     .collect(Collectors.toList());
        System.out.println("Even numbers collected: " + evens);

        // 5. count() - count of numbers > 5
        long countGreaterThan5 = numbers.stream().filter(n -> n > 5).count();
        System.out.println("Count > 5: " + countGreaterThan5);

        // 6. findAny() - returns any number
        Optional<Integer> any = numbers.stream().findAny();
        System.out.println("Any number: " + any.orElse(null));

        // 7. findFirst() - find the first number
        Optional<Integer> first = numbers.stream().findFirst();
        System.out.println("First number: " + first.orElse(null));

        // 8. forEach() - print all numbers
        System.out.print("All numbers: ");
        numbers.stream().forEach(n -> System.out.print(n + " "));
        System.out.println();

        // 9. min() - find the minimum number
        Optional<Integer> min = numbers.stream().min(Integer::compareTo);
        System.out.println("Minimum number: " + min.orElse(null));

        // 10. max() - find the maximum number
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        System.out.println("Maximum number: " + max.orElse(null));

        // 11. reduce() - sum of all numbers
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sum using reduce(): " + sum);

        // 12. toArray() - convert to array and print
        Integer[] array = numbers.stream().toArray(Integer[]::new);
        System.out.println("Array from stream: " + Arrays.toString(array));
    }
}

