package com.functionalprogramming;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BuiltInFunctionalInterfaceEx {

	public static void main(String[] args) {
		
		//Predicate is a functional interface that represents a boolean-valued function of one argument
		Predicate<String> isLongerThan5 = str -> str.length() > 5;
		System.out.println(isLongerThan5.test("Hello")); // Output: false
		System.out.println(isLongerThan5.test("Hello, World!")); // Output: true
      
		
		//Function is a functional interface that represents a function that takes one argument and produces a result.
		Function<String, Integer> lengthFunction = str -> str.length();
		System.out.println(lengthFunction.apply("Hello")); // Output: 5
		
		
		//Consumer is a functional interface that represents an operation that accepts a single input argument and returns no result.
		Consumer<String> printConsumer = str -> System.out.println(str);
		printConsumer.accept("Hello, World!"); // Output: Hello, World!
		
		
		//Supplier is a functional interface that represents a supplier of results.
		 Supplier<String> stringSupplier = () -> "Hello, World!";
        System.out.println(stringSupplier.get()); // Output: Hello, World!
	    

	}

}

