package com.skdamoda.common;

import java.util.Scanner;

public class Anagram {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String word1 = scanner.nextLine();
		String word2 = scanner.nextLine();
		StringBuilder sb = new StringBuilder(word2);
		boolean isAnagram = true;
		if(word1.length()==word2.length()) {
			char [] word1CharArray = word1.toCharArray();
			for(char c : word1CharArray) {
				int index = sb.indexOf(""+c);
				if(index==-1) {
					isAnagram=false;
					break;
				}
				sb.deleteCharAt(index);
			}
		}else{isAnagram=false;}
		System.out.println("Strings are anagram"+isAnagram);
	}

}
