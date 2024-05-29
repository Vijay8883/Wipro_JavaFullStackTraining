package com.computationalalgorithms;
import java.util.Arrays;
import java.util.Comparator;
 
class Item {
    int value, weight;
 
    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}
public class FractionalKnapsack {
	 private static double getMaxValue(Item[] items, int capacity) {
	        // Sorting items by value-to-weight ratio
	        Arrays.sort(items, new Comparator<Item>() {
	            @Override
	            public int compare(Item o1, Item o2) {
	                double r1 = (double) o1.value / o1.weight;
	                double r2 = (double) o2.value / o2.weight;
	                return Double.compare(r2, r1);
	            }
	        });
 
	        double totalValue = 0.0;
	        
	        for (Item item : items) {
	            if (capacity - item.weight >= 0) {
	                // If the item can be added completely
	                capacity -= item.weight;
	                totalValue += item.value;
	            } else {
	                // If the item can be added fractionally
	                totalValue += item.value * ((double) capacity / item.weight);
	                break;
	            }
	        }
 
	        return totalValue;
	    }
 
	    public static void main(String[] args) {
	        Item[] items = {
	            new Item(60, 10),
	            new Item(100, 20),
	            new Item(120, 30)
	        };
	        int capacity = 50;
	        
	        double maxValue = getMaxValue(items, capacity);
	        System.out.println("Maximum value we can obtain = " + maxValue);
	    }
}
 