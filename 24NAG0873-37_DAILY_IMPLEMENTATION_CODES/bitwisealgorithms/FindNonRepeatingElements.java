package com.bitwisealgorithms;
public class FindNonRepeatingElements {
	public static void findNonRepeating(int[] arr) {
        int xorResult = 0;
 
        // Step 1: XOR all elements to get xorResult
        for (int num : arr) {
            xorResult ^= num;
        }
 
        // Step 2: Find the rightmost set bit in xorResult
        int setBit = xorResult & -xorResult;
 
        // Step 3: Divide elements into two sets and XOR them
        int x = 0, y = 0;
        for (int num : arr) {
            if ((num & setBit) == 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }
 
        // The two non-repeating elements are x and y
        System.out.println("The two non-repeating elements are " + x + " and " + y);
    }
 
    public static void main(String[] args) {
        int[] arr = {5, 4, 5, 9, 2, 4};
        findNonRepeating(arr);
    }
}
 