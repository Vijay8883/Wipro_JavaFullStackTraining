package com.bitwisealgorithms;
public class SwapBits {
	 public static int swapBits(int n, int i, int j) {
	        // Extract the i-th and j-th bits
	        int bitAtI = (n >> i) & 1;
	        int bitAtJ = (n >> j) & 1;

	        // If the bits are the same, no need to swap
	        if (bitAtI == bitAtJ) {
	            return n;
	        }

	        // Create a bit mask where bits at positions i and j are set
	        int mask = (1 << i) | (1 << j);

	        // Toggle the bits at positions i and j
	        n = n ^ mask;

	        return n;
	    }

	    public static void main(String[] args) {
	        int num = 29; // binary: 11101
	        int i = 1;
	        int j = 3;
	        System.out.println("Original number: " + num + " (" + Integer.toBinaryString(num) + ")");
	        int result = swapBits(num, i, j);
	        System.out.println("Number after swapping bits at positions " + i + " and " + j + ": " + result + " (" + Integer.toBinaryString(result) + ")");
	    }
}