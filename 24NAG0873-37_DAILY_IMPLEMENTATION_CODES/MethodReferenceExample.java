package com.functionalprogramming;
import java.util.*;
import java.util.function.*;
public class MethodReferenceExample {
 
	public static void main(String[] args) {
		//Reference to a Static Method
		Consumer<String> print = System.out::println;
		print.accept("Hello, World!"); // Output: Hello, World!
		//Reference to an Instance Method of a Particular Object
		String str = "Hello, World!";
		Supplier<Integer> lengthSupplier = str::length;
		System.out.println(lengthSupplier.get()); // Output: 13
		//Reference to an Instance Method of an Arbitrary Object of a Particular Type
		Function<String, Integer> lengthFunction = String::length;
		System.out.println(lengthFunction.apply("Hello")); // Output: 5
		//Reference to a Constructor
		Supplier<List<String>> listSupplier = ArrayList::new;
		List<String> list = listSupplier.get();
 
	}
 
}


