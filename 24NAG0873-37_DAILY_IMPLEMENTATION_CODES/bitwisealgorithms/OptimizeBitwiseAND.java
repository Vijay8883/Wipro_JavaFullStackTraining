package com.bitwisealgorithms;
public class OptimizeBitwiseAND {
	// Function to calculate the Bitwise AND of all subsets of an array
    public static int bitwiseANDOfAllSubsets(int[] arr) {
        int result = arr[0];  // Initialize result with the first element
 
        // Iterate through each element and compute the AND with the result
        for (int i = 1; i < arr.length; i++) {
            result &= arr[i];
 
            // If result becomes zero, we can break early
            if (result == 0) {
                break;
            }
        }
 
        return result;
    }
 
    public static void main(String[] args) {
        int[] arr = {12, 15, 7};  // Example input
        int andResult = bitwiseANDOfAllSubsets(arr);
        System.out.println("Bitwise AND of all subsets: " + andResult);
    }
}
