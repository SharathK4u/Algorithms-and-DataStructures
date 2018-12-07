package com.skdamoda.tree;

/* IMPORTANT: Multiple classes and nested static classes are supported */


//uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
//import for Scanner and other utility classes
import java.util.*;


//Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass2 {
 public static void main(String args[] ) throws Exception {
     /* Sample code to perform I/O:
      * Use either of these methods for input

     //BufferedReader
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     String name = br.readLine();                // Reading input from STDIN
     System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

     //Scanner
     Scanner s = new Scanner(System.in);
     String name = s.nextLine();                 // Reading input from STDIN
     System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

     */

     // Write your code here
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     String arraySize = br.readLine();   
     //System.out.println(arraySize);
     String [] arraySizeA = arraySize.split(" ");
     int n=Integer.parseInt(arraySizeA[0]);
     int m=Integer.parseInt(arraySizeA[1]);
     BigInteger maxValue=new BigInteger("0");
     int result=0;
     for(int i=0;i<n;i++){
         String arrayLine = br.readLine(); 
         int [] arrayLineA = new int [m];
         BigInteger totalValue=new BigInteger("0");
         
         //Getting array of line
         for (int k = 0; k < arrayLine.length(); k++) {
                 arrayLineA[k] = Integer.parseInt(String.valueOf(arrayLine.charAt(k)));
         }
         //Calculating the totalValue per row
         for(int j=0;j<m;j++) {
        	 int value = (int)(arrayLineA[j]*(Math.pow(2, n-j-1)));
        	 totalValue=totalValue.add(new BigInteger(String.valueOf(value)));
        	 
         }
         //Finding out the maxValue and settint row.
         if(totalValue.compareTo(maxValue)==1) {
        	 maxValue=totalValue;
        	 result=i+1;
         }
     }
     System.out.println(result);
    
 }
}

