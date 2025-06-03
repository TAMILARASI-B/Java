package TerminalOperations;

import java.util.*;
import java.util.stream.Stream;

public class allMatchExample {

	public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("Java Guides");
        stringList.add("Python Guides");
        stringList.add("C Guides");

        Stream<String> stream = stringList.stream();
        boolean allMatch = stream.allMatch((value) -> value.contains("Guides"));
        System.out.println(allMatch);
    }

}
