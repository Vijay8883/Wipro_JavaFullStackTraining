package com.searchingalgorithms;

public class BinarySearch {
	public static int search(int[] arr,int target)
	{
		int start=0;
		int end=arr.length-1;
		boolean asc=false;
		if(arr[start]<arr[end])
			asc=true;
		while(start<=end)//
		{   
	       int mid=(start+end)/2;
		if(asc)
		{
			if(target>arr[mid])
				start=mid+1;
			else
				if(target<arr[mid])
					end=mid-1;
				else
					return mid;
		}
		else     //desc array
		{
			if(target>arr[mid])
				end=mid-1;   //end=end-1;
			else
				if(target<arr[mid])
					start=mid+1;     //start=start+1;
				else 
					return mid;
		}
	}
	return -1;

}
}