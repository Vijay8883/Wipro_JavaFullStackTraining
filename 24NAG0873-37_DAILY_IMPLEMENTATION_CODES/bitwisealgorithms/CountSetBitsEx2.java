package com.bitwisealgorithms;
/*
* Using Built-in Functions
* Some languages provide built-in functions to count set bits.
 
In Java 1.5 and later, you can use  Integer.bitCount() method
*/
public class CountSetBitsEx2 {
	public static void main(String[] args) {
        int num = 29;
        System.out.println("Number of set bits in " + num + " is " + Integer.bitCount(num));
    }
}