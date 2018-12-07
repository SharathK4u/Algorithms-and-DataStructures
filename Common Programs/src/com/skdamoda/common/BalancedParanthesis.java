package com.skdamoda.common;

import java.util.Scanner;
import java.util.Stack;

public class BalancedParanthesis {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		char [] array = input.toCharArray();
		Stack stack = new Stack();
		boolean isBalanced = true;
		for(char c : array) {
			if(c=='(' | c=='{' | c=='[')
				stack.push(c);
			else if(c==')' | c=='}' | c==']') {
				if(stack.isEmpty()) {
				isBalanced=false;
				break;
				}
				else {
					if(c==')' && stack.peek().toString().equals("(") ||
							c==']' && stack.peek().toString().equals("[") ||
							c=='}' && stack.peek().toString().equals("{")) {
						stack.pop();
						isBalanced=true;
					}
					else {isBalanced=false;break;}
				}
			}
		}
		if(!stack.isEmpty()) {isBalanced=false;}
		System.out.println("A balanced set : "+isBalanced);
	}
}