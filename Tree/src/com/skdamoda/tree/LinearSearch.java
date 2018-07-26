package com.skdamoda.tree;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.*/
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class LinearSearch {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input*/

        //BufferedReader
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = "5 1";             // Reading input from STDIN
        String [] size = line1.split(" ");
        int number = Integer.parseInt(size[1]);
        //Scanner
        String line2 = "1 2 3 4 1";                // Reading input from STDIN
        String [] elements = line2.split(" ");
        int location=-1;
        for(int i=0;i<elements.length;i++){
            if(number==Integer.parseInt(elements[i])){
                location=i+1;
            }
                
        }
        System.out.println(location);

    }
}

