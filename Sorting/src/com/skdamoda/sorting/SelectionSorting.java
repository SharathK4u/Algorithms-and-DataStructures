package com.skdamoda.sorting;

public class SelectionSorting {

	public static void main(String args[]) {
		SelectionSorting bs = new SelectionSorting();
		int arr[]= {1,8,2,7,3,4,5};
		bs.selectionSort(arr);
		for(int j=0;j<(arr.length);j++) {
			System.out.print(arr[j]);	
		}		
	}
	
	public void selectionSort(int [] arr) {
		for(int i=0;i<arr.length-1;i++) {
			int minimum=i;
			//Finding minimum number
			for(int j=i+1;j<(arr.length);j++) {
				
				if(arr[minimum]>arr[j]) {
					minimum=j;
				}					
			}
			//swapping as first element
			int temp=arr[i];
			arr[i]=arr[minimum];
			arr[minimum]=temp;
			}
		}
}
