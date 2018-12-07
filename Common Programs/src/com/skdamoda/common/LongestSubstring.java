package com.skdamoda.common;
import java.util.*;
public class LongestSubstring {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		char [] charS = s.toCharArray();
		int total = 0;
		String longestString="";
		for(int i=0;i<charS.length;i++) {
			HashSet set = new LinkedHashSet();
			for(int j=i;j<charS.length;j++) {
				if(!set.add(charS[j]) || j==charS.length-1) {
					if(set.size()>total) {
						total=set.size();
						longestString=set.toString();
					}
					break;
				}
			}
		}

		System.out.println("Length"+total+": string "+longestString);
	}

}
