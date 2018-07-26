package com.skdamoda.tree;

public class BinarySearch {

	public static void main(String [] args) {
		int [] arr= {1,5,7,9,15,232};
		int key = 15;
		BinarySearch bs = new BinarySearch();
		int found = bs.binarySearch(arr, key);
		System.out.println("Binary search "+found);
	}
	
	int binarySearch(int [] arr,int key) {
		int low = 0;
		int high = arr.length-1;
		
		while(low<=high) {
			int median = (low+high)/2;
			if(key>arr[median])
				low=median+1;
			else if(key<arr[median])
				high=median-1;
			else
				return arr[median];
		}
		return -1;
	}
	
}
