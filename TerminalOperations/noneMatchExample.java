package TerminalOperations;

import java.util.*;
import java.util.stream.Stream;

public class noneMatchExample {

	 public static void main(String[] args) {
	        List<String> stringList = new ArrayList<>();
	        stringList.add("john");
	        stringList.add("tom");

	        Stream<String> stream = stringList.stream();
	        boolean noneMatch = stream.noneMatch((element) -> "Ramesh".equals(element));
	        System.out.println("noneMatch = " + noneMatch);
	    }

}
