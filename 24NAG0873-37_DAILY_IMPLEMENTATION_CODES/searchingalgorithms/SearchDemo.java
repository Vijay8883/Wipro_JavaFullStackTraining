package com.searchingalgorithms;

public class SearchDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int[] arr= {1,3,5,6,10,12,15,20,21,28};
System.out.println(BinarySearch.search(arr, 1));
int[] arr1= {10,8,6,2,0};
System.out.println(BinarySearch.search(arr1, 18));
int[] arr2= {10,8,6,5,4,3,1};
System.out.println(BinarySearch.search(arr2, 8));
System.out.println(BinarySearch.search(arr2, 3));
}
}