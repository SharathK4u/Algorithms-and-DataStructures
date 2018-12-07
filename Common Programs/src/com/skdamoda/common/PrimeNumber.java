package com.skdamoda.common;
import java.util.*;
public class PrimeNumber {

	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int length = Integer.parseInt(s.nextLine());
        List<Integer> primeNumbers = new ArrayList<Integer>();
        for(int i=2;i<length;i++){
        		boolean primeNumber=true;
                for(Integer number:primeNumbers){
                    if(i%number==0){
                        primeNumber=false;
                        break;
                    }
                }
            if(primeNumber){
                primeNumbers.add(i);
            }
        }
        System.out.println(primeNumbers);

	}

}
