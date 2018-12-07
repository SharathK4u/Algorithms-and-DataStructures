package com.skdamoda.common;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

/**
 * Find if a set of number is K PrimeNumber.
 * Given a number K and an N series of numbers, the series of numbers is a KPrimeNumber if the series
 * contains atleast K primeNumbers.
 * Input format like
 * K N -->FirstLine
 * 1 3 4 7 9 ... N
 * return 0 if its K PrimeNumber. If there are no K PrimeNumbers, List the number of steps to be 
 * added to existing list of numbers to make them K PrimeNumbers
 * */
public class KPrimeNumber {
    public static void main(String args[] ) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1 = br.readLine();                // Reading input from STDIN
        String [] array1 = input1.split(" ");
        
        int n = Integer.parseInt(array1[0]);
        int k = Integer.parseInt(array1[1]);
        String input2 = br.readLine();                // Reading input from STDIN
        String [] array2 = input2.split(" ");
        
        int count=0;
        Set<Integer> nonPrimeNumberList = new TreeSet<Integer>();
        
        for(String s : array2) {
        	if(isPrimeNumber(Integer.parseInt(s))) {
        		count+=1;
        	}else {
        		nonPrimeNumberList.add(Integer.parseInt(s));
        	}
        }
        
        if(count<k) {
        	System.out.println(findOperations(nonPrimeNumberList,(k-count)));
        }else {
        	System.out.println(0);
        }
        

    }
    
    static boolean isPrimeNumber(int input) {
    	if(input==0 || input==1) {
    		return false;
    	}
    	for(int i=2;i<=input/2;i++) {
    		if(input%i==0) {
    			return false;
    		}
    	}
    	return true;
    }
    static int findOperations(Set nonPN, int primeNeeded) {
    	int operations = 0;
    	Iterator it = nonPN.iterator();
    	for(int i=0;i<primeNeeded;i++) {
    		operations+= findDiff(Integer.parseInt(it.next().toString()));
    	}
    	return operations;
    }
    
    static int findDiff(int number) {
    	int primeNumber = number;
    	for(int i=0;i<Integer.MAX_VALUE;i++) {
    		primeNumber+=1;
    		boolean t = isPrimeNumber(primeNumber);
    		if(t==true) {
    			return primeNumber-number;
    		}
    	}
    	return 0;
    }
}
