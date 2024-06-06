package com.functionalprogramming;

public class HelloWorld {
	public static void main(String[] args) {
		//Using Runnable interface
		Runnable helloWorldLambda=()->System.out.println("Hello World..!");
		//Execute the lambda expression
		helloWorldLambda.run();
	}

}
