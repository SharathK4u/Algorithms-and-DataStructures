package com.skdamoda.sorting;

public class InsertionSorting {

	public static void main(String args[]) {
		InsertionSorting bs = new InsertionSorting();
		int arr[]= {1,8,2,7,3,6,4,5};
		bs.insertionSort(arr);
		for(int j=0;j<(arr.length);j++) {
			System.out.print(arr[j]);	
		}		
	}
	
	public void insertionSort(int [] arr) {
		for(int i=0;i<arr.length;i++) {
			int j=i;
			int temp=arr[i];
			//swapping the numbers till the location on the left is found
			while(j>0 && arr[j-1]>temp) {
				arr[j]=arr[--j];
			}
			//swapping the element to its correct position
			arr[j]=temp;
			}
		}
}
