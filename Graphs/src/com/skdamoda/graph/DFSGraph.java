package com.skdamoda.graph;

import java.util.LinkedList;
import java.util.Stack;

public class DFSGraph {

	int v;
	LinkedList<Integer> [] adjListArray;
	DFSGraph(int v){
		this.v=v;
		adjListArray = new LinkedList[v];
		for(int i=0;i<v;i++)
			adjListArray[i]=new LinkedList<Integer>();
	}
	
	private void addEdge(int src,int dest) {
		adjListArray[src].add(dest);
		adjListArray[dest].add(src);
	}
	
	private void printDFS(int s) {
		boolean [] visited=new boolean [v];
		boolean deadEnd=true;
		for(int i=0;i<v;i++)
			visited[i]=false;
		Stack stack = new Stack();
		stack.push(s);
		visited[s]=true;
		System.out.println(s);
		while(!stack.empty()){
			for(int v : adjListArray[s]) {
				if(!visited[v]) {
					stack.push(v);
					visited[v]=true;
					s=v;
					System.out.println(s);
					deadEnd=false;
					break;
				}
				if(deadEnd) {
					s=(int)stack.pop();
				}
			}
			deadEnd=true;
		}
	}
	public static void main(String [] args) {
		DFSGraph graph = new DFSGraph(12);
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
		graph.printDFS(0);
	}
	
}
