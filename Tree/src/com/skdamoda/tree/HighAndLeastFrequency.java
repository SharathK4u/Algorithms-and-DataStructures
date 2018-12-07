package com.skdamoda.tree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;
import java.lang.Integer;

class HighAndLeastFrequency {
	static Map<Integer,Integer> countMap;
    public static void main(String args[] ) throws Exception {

    	BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Pallavi\\Desktop\\input.txt"));
        int M = Integer.parseInt(br.readLine());
        countMap = new TreeMap<Integer,Integer>();
        for (int i = 0; i < M; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(tk.nextToken());
            if (type == 1) {
                int val = Integer.parseInt(tk.nextToken());
                add_to_list(val);
            }
            else if (type == 2) {
                int val = Integer.parseInt(tk.nextToken());
                remove_from_list(val);
            }
            else if (type == 3) {
                int ans = find_least_frequency();
                System.out.println(ans);
            }
            else if (type == 4){
                int ans = find_highest_frequency();
                System.out.println(ans);
            }
        }
    }
    public static void add_to_list(int val){
        //Process queries of type 1 here
    	if(countMap.containsKey(val)) {
    		countMap.put(val, countMap.get(val)+1);
    	}
    	else {
    		countMap.put(val, 1);
    	}

    }

    public static void remove_from_list(int val){
        //Process queries of type 2 here
    	if(countMap.containsKey(val)) {
    		int count=countMap.get(val)-1;
    		if(count!=0) {
    			countMap.put(val, count);
    		}
    		else {
    			countMap.remove(val);
    		}
    	}
    }

    public static int find_least_frequency(){
        //Process queries of type 3 here
    	Set<Entry<Integer, Integer>> set=countMap.entrySet();
    	List<Integer> leastFrequents = new ArrayList<Integer>();
    	int leastFrequent=-1;
    	Iterator<Entry<Integer, Integer>> it = set.iterator();
    	if(it.hasNext()) {
    		Entry<Integer,Integer> e=it.next();
    		leastFrequent=e.getValue();
    		leastFrequents.add(e.getKey());
    		}
    	while(it.hasNext()) {
    		Entry<Integer,Integer> e=it.next();
    		if(leastFrequent==e.getValue()) {
    			leastFrequents.add(e.getKey());
    		}
    	}
    	Collections.reverse(leastFrequents);
    	if(leastFrequents.isEmpty())
    		return -1;
    	return leastFrequents.get(0);
    }

    public static int find_highest_frequency(){
        //Process queries of type 4 here
    	Set<Entry<Integer, Integer>> set=countMap.entrySet();
    	List<Integer> highFrequents = new ArrayList<Integer>();
    	int highFrequent=-1;
    	Iterator<Entry<Integer, Integer>> it = set.iterator();
    	if(it.hasNext()) {
    		Entry<Integer,Integer> e=it.next();
    		highFrequent=e.getValue();
    		highFrequents.add(e.getKey());
    		}
    	while(it.hasNext()) {
    		Entry<Integer,Integer> e=it.next();
    		if(highFrequent<e.getValue()) {
    			highFrequents = new ArrayList<Integer>();
    			highFrequents.add(e.getKey());
    		}
    		else if(highFrequent==e.getValue()) {
    			highFrequents.add(e.getKey());
    		}
    	}
    	Collections.sort(highFrequents);
    	if(highFrequents.isEmpty())
    		return -1;
    	return highFrequents.get(0);
        
    }
    
    class ValueComparator implements Comparator{
    	private Map<Integer,Integer> map;
    	ValueComparator(Map<Integer,Integer> map){
    		this.map=map;
    	}
    	
    	public int compare(Object a,Object b) {
    		return map.get((Integer)a).compareTo((Integer)map.get(b));
    	}
    }
}