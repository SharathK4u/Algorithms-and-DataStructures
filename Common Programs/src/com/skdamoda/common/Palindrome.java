package com.skdamoda.common;
import java.util.*;

public class Palindrome {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
        char [] charArray = name.toCharArray();
        int length = name.length();
        boolean palindrome=true;
        for(int i=0;i<length/2;i++){
            if(charArray[i]!=charArray[length-1-i]){
                palindrome=false;
                break;
            }
        }
        if(palindrome){
            System.out.println("YES");
        }

	}
	
	public String reverse(String s) {
		if(s.length()==1)
			return s;
		return reverse(s.substring(1))+s.charAt(0);
	}
}
