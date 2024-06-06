package com.functionalprogramming;
import java.util.function.BiFunction;
public class AdditionLambda {
public static void main(String[] args) {
	//Using BiFunction interface
	BiFunction<Integer,Integer,Integer>addAndPrintLambda=(Integer a,Integer b)->{
		int sum=a+b;
		System.out.println("Sum of "+a +" and "+b+" is: "+sum);
		return sum;
	};
	//Execute the lambda expression
	int result=addAndPrintLambda.apply(5, 10);
	System.out.println("Returned result:"+result);
}
}
