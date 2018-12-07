package com.skdamoda.common;
/* IMPORTANT: Multiple classes and nested static classes are supported */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * To return the longest subsequence of ascending characters.
 * If input is aabcade --> Longest subsequence is abcde of length 5.
 * There can be queries executed on this sequence. Two types.
 * If query is 2. Return the length of the longest subsequence.
 * If the query is 1 <position> <character>. Replace the character at that position with the input.
 * First two inputs are length of sequence and the sequence of numbers.
 * Next input is the nof of queries.
 * Next is the series of query of the format specified above.
 * **/
public class LongestSubsequence {
    public static void main(String args[] ) throws Exception {
        
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());                // Reading input from STDIN
        StringBuilder input = new StringBuilder(br.readLine());
        int noOfQ = Integer.parseInt(br.readLine());
        for(int i=0;i<=noOfQ;i++) {
        	String query = br.readLine();
        	if(query.length()==1) {
        		int qLength = subsequence(input);
        		System.out.println(qLength);
        	}else {
        		String [] array = query.split(" ");
        		input = changeSequence(input, Integer.parseInt(array[1]), array[2].charAt(0));
        	}
        }

    }
    static int subsequence(StringBuilder input) {
    	char [] charArray = input.toString().toCharArray();
    	Stack s = new Stack();
    	int length = 1;
    	s.add(charArray[0]);
    	for(char c : charArray) {
    		if(c>s.peek().toString().charAt(0)) {
    			s.add(c);
    			length+=1;
    		}
    	}
    	return length;
    }
    static StringBuilder changeSequence(StringBuilder input, int position, char character) {
    	input.setCharAt(position-1, character);
    	return input;
    }
}
