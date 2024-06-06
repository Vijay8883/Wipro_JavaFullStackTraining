package com.functionalprogramming;

public class StringLengthLambda {
	public static void main(String[] args) {
		String input="Hello,World!";
		//Implementing Runnable interface using a lambda expression
		Runnable stringLengthFinder=()->{
			//Functional interface to find the length of a string
			StringLengthFunction lengthFunction=s->s.length();
			int length=lengthFunction.getLength(input);
			System.out.println("Length of the string \""+ input + "\" is:"+length);
		};
		//Create a new thread with the Runnable
		Thread thread=new Thread(stringLengthFinder);
		//Start the thread
		thread.start();
	}
	//Functional interface to find the length of a string
	interface StringLengthFunction{
		int getLength(String str);
	}

}
