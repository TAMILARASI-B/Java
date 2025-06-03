package TerminalOperations;

import java.util.*;
import java.util.stream.Stream;

public class anyMatchExample {
	public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("Java Guides");
        stringList.add("Python Guides");
        stringList.add("C Guides");

        Stream<String> stream = stringList.stream();
        boolean anyMatch = stream.anyMatch((value) -> value.startsWith("Java"));
        System.out.println(anyMatch);
    }
}
