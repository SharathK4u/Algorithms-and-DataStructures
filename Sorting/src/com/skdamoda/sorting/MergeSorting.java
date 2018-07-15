package com.skdamoda.sorting;

public class MergeSorting {

	public static void main(String[] args) {
		MergeSorting bs = new MergeSorting();
		int arr[]= {1,8,2,7,3,4,5,6};
		bs.mergeSort(arr,0,arr.length-1);
		for(int j=0;j<(arr.length);j++) {
			System.out.print(arr[j]);	
		}	
	}

	public void mergeSort(int arr[],int start,int end) {
		
		//Finding the median
		if(start<end) {
		int mid = (start+end)/2;
		mergeSort(arr,start,mid);
		mergeSort(arr,mid+1,end);
		merge(arr,start,mid,end);
		}
	}
	
	public void merge(int arr[],int start,int mid,int end) {
		int p=start;
		int q=mid+1;
		int k=0;
		int [] sortArr=new int[end-start+1];
		for(int i=start;i<=end;i++) {
			if(p>mid)
				sortArr[k++]=arr[q++];
			else if(q>end)
				sortArr[k++]=arr[p++];
			else if(arr[p]>arr[q])
				sortArr[k++]=arr[q++];
			else
				sortArr[k++]=arr[p++];
		}
		for(int i=0;i<k;i++) {
			arr[start++]=sortArr[i];
		}
	}
	
}
