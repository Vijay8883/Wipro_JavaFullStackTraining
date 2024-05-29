package com.dynamicprogrammingalgorithms;
//Knapsack0/1 problem
public class Knapsack {
	// Function to solve the 0/1 Knapsack problem
 public static int knapsack(int[] weights, int[] values, int weightLimit) {
     int n = weights.length;
     int[][] dp = new int[n + 1][weightLimit + 1];

     for (int i = 0; i <= n; i++) {
         for (int w = 0; w <= weightLimit; w++) {
             if (i == 0 || w == 0) {
                 dp[i][w] = 0;
             } else if (weights[i - 1] <= w) {
                 dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
             } else {
                 dp[i][w] = dp[i - 1][w];
             }
         }
     }
     return dp[n][weightLimit];
 }

 public static void main(String[] args) {
     int[] weights = {2, 3, 4, 5};
     int[] values = {3, 4, 5, 6};
     int weightLimit = 5;
     System.out.println("Maximum value in knapsack = " + knapsack(weights, values, weightLimit));
 }
}