package com.skdamoda.sorting;

public class BubbleSorting {

	public static void main(String args[]) {
		BubbleSorting bs = new BubbleSorting();
		int arr[]= {1,3,2,9,4,8,5};
		bs.bubbleSort(arr);
		for(int j=0;j<(arr.length);j++) {
			System.out.print(arr[j]);	
		}		
	}
	
	public void bubbleSort(int [] arr) {
		for(int i=0;i<arr.length-1;i++) {
			boolean swap = false;
			for(int j=0;j<(arr.length-i-1);j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					swap=true;
				}					
			}
			if(!swap) {
				break;
			}
		}
	}
}
