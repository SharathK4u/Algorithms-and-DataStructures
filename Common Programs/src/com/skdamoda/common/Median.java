package com.skdamoda.common;

import java.util.Arrays;

public class Median {

	public static void main(String[] args) {
		int [] numbers = {1,3,7,10};
		float f = median(numbers);
		System.out.println(f);
		
	}
	
	static float median(int numbers[]) {
		Arrays.sort(numbers);
		int length = numbers.length;
		if(length%2==0) {
			return (numbers[length/2]+numbers[(length-1)/2])/2;
		}else {
			return numbers[length/2];
		}
	}

}
