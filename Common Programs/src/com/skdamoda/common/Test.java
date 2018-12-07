package com.skdamoda.common;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		System.out.print("Test");
		int [] used = {1,2,5,8,15};
		int paired=0;
		int unpaired=0;
		boolean [] usedN=new boolean[used.length];
		Arrays.sort(used);
		for(int i=used.length-1;i>=0;i--) {
			int b=used[i];
			for(int j=i;j>0;j--) {
				if(usedN[j]==false&&b>=2*used[j]) {
					usedN[j]=true;
					paired+=1;
				}
			}
		}
		unpaired=used.length-2*paired;
		System.out.println(paired+" "+unpaired);
	}
	
	public void testing() {
		System.out.print("Test");
	}

}