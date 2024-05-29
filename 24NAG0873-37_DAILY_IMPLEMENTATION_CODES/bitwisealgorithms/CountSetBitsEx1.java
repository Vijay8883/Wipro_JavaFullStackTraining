package com.bitwisealgorithms;
/*
 * Iterative Method
 * This is a straight forward method where you repeatedly shift the bits
 * of the number and check if the
 * latest significant bit is set
 */
public class CountSetBitsEx1 {
	//Function to count the number of set bits in a number
	public static int countSetBits(int n) {
		int count=0;
		while(n>0)
		{
			count+=(n&1);
			//step1:We have to find a bitwise_and with 1
			n>>=1;//step2:We have to right shift with 1
			
		}
		return count;
	}
public static void main(String[] args)
{
	int num=14;
	System.out.println("Number of set bits in "+ num +" is "+countSetBits(num));
}
}
