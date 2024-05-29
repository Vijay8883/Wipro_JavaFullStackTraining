package com.bitwisealgorithms;
public class CountTotalSetsBits {
	// Function to count total set bits in all numbers from 1 to n
    public static int countTotalSetBits(int n) {
        int totalSetBits = 0;
        int i = 0;
        
        while ((1 << i) <= n) {
            // Find the size of blocks and count how many full blocks of size 2^(i+1) are there
            int blockSize = 1 << (i + 1);
            int fullBlocks = n / blockSize;
            
            // Each full block contributes with 2^i set bits in i-th position
            totalSetBits += fullBlocks * (1 << i);
            
            // Check if there are remaining bits after the last full block
            int remainingBits = n % blockSize;
            
            // Add set bits in the remaining part, if any
            totalSetBits += Math.max(0, remainingBits - (1 << i) + 1);
            
            i++;
        }
        
        return totalSetBits;
    }
 
    public static void main(String[] args) {
        int n = 7; // Example input
        System.out.println("Total set bits from 1 to " + n + " is " + countTotalSetBits(n));
    }
}
 