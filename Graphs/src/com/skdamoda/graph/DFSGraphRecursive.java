package com.skdamoda.graph;

import java.util.LinkedList;

public class DFSGraphRecursive {
	int v;
	LinkedList<Integer> [] adjList;
	DFSGraphRecursive(int v){
		this.v=v;
		adjList=new LinkedList[v];
		for(int i=0;i<v;i++)
			adjList[i]=new LinkedList<Integer>();
	}
	
	public void addEdge(int src,int dest) {
		adjList[src].add(dest);
		adjList[dest].add(src);
	}
	
	public void printDFSRecursive(int s,boolean [] visited) {
		System.out.println(s);
		for(int i:adjList[s]) {
			if(!visited[s]) {
				visited[i]=true;
				printDFSRecursive(i,visited);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DFSGraphRecursive graph = new DFSGraphRecursive(12);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(1, 4);
		graph.addEdge(1, 5);
		graph.addEdge(1, 6);
		graph.addEdge(3, 7);
		graph.addEdge(5, 10);
		graph.addEdge(7, 8);
		graph.addEdge(7, 9);
		graph.printDFSRecursive(0,new boolean [10]);
	}
	

}
