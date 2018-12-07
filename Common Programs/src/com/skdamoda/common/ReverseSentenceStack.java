package com.skdamoda.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 
 * Reverse a sentence using only stacks.
 * If the input is "Today is a good day"
 * Output should be "day good a is Today"
 */
public class ReverseSentenceStack {
	public static void main(String [] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String sentence="";
		try {
			sentence = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		char [] sentenceArray = sentence.toCharArray();
		Stack s1= new Stack();
		Stack s2=new Stack();
		for(char c:sentenceArray) {
			s1.add(c);
		}
		while(!s1.isEmpty()) {
			if((char)s1.peek()==' ') {
				while(!s2.isEmpty()) {
					System.out.print(s2.pop());
				}
				System.out.print(" ");
			}
			s2.push(s1.pop());
		}
		while(!s2.empty()) {
			System.out.print(s2.pop());
		}
	}
}
