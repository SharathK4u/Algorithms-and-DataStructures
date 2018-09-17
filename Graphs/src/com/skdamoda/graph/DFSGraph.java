package com.skdamoda.graph;

import java.util.LinkedList;
import java.util.Queue;
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
		boolean [] visited = new boolean [v];
		for(int i=0;i<v;i++) {
			visited[i]=false;
		}
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(s);
		visited[s]=true;
		while(!stack.isEmpty()) {
			s = stack.pop();
			System.out.println(s);
			
			for(int i : adjListArray[s]) {
				if(!visited[i]) {
					visited[i]=true;
					stack.push(i);
				}
			}			
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
