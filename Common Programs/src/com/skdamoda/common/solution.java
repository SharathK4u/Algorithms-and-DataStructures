package com.skdamoda.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class solution {
	public static void main(String [] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Map<String,String> map = new LinkedHashMap<String,String>();
		try {
			int count = Integer.parseInt(in.readLine());
			for(int i=0;i<count;i++) {
				String chromosome = in.readLine();
				String gene = in.readLine();
				map.put(chromosome, gene);
			}
			Set<Entry<String,String>> cgSet = map.entrySet();
			for(Entry<String,String> e : cgSet) {
				if(isPresent(e.getKey(),new StringBuilder(e.getValue()))) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
				
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static boolean isPresent(String chromosome,StringBuilder gene) {
		char [] chromChar = chromosome.toCharArray();
		for(char c : chromChar) {
			if(gene.charAt(0)==c) {
				gene.deleteCharAt(0);
				if(gene.length()==0)
					return true;
			}
		}
		return false;
		
	}
}
