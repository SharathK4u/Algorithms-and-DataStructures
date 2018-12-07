package com.skdamoda.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.Integer;

public class AlignRectangles {

    public static void main(String args[] ) throws Exception {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int L[] = new int[N];
        int R[] = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            L[i] = Integer.parseInt(tk.nextToken());
            R[i] = Integer.parseInt(tk.nextToken());
        }
        align_rectangles(N , L , R);
        for(int i = 0; i < N; i++) {
            System.out.println(L[i] + " " + R[i]);
        }
    }
    public static void align_rectangles(int N,int L[],int R[]){
        //Not that you neeed to update the Lays L and R as per the new aligned order
		for(int i=0;i<N-1;i++) {
			boolean swap = false;
			for(int j=0;j<(N-i-1);j++) {
				if(L[j]>L[j+1]) {
					int temp = L[j];
					L[j]=L[j+1];
					L[j+1]=temp;
					temp = R[j];
					R[j]=R[j+1];
					R[j+1]=temp;
					swap=true;
				}else if(L[j]==L[j+1]) {
					if(L[j]*R[j]<L[j+1]*R[j+1]) {
						int temp = L[j];
						L[j]=L[j+1];
						L[j+1]=temp;
						temp = R[j];
						R[j]=R[j+1];
						R[j+1]=temp;
						swap=true;
					}
				}					
			}
			if(!swap) {
				break;
			}
		}
    }

}