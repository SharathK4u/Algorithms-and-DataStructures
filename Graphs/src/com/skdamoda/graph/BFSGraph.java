package com.skdamoda.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFSGraph {
	int v;
	//The array of linked list which stores the data
	LinkedList<Integer> [] adjListArray;
	BFSGraph(int v){
		this.v=v;
		adjListArray=new LinkedList[v];
		for(int i=0;i<v;i++)
			adjListArray[i]=new LinkedList<Integer>();
	}
	
	private void addEdge(BFSGraph graph,int src,int dest) {
		graph.adjListArray[src].add(dest);
		graph.adjListArray[dest].add(src);
	}
	private void printBFS(int s) {
		boolean [] visited = new boolean [v];
		for(int i=0;i<v;i++) {
			visited[i]=false;
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		visited[s]=true;
		while(!queue.isEmpty()) {
			s = queue.poll();
			System.out.println(s);
			
			for(int i : adjListArray[s]) {
				if(visited[i]!=true) {
					visited[i]=true;
					queue.add(i);
				}
			}			
		}
	}
	public static void main(String [] args) {
		BFSGraph graph = new BFSGraph(12);
		graph.addEdge(graph, 0, 1);
		graph.addEdge(graph, 0, 2);
		graph.addEdge(graph, 0, 3);
		graph.addEdge(graph, 1, 4);
		graph.addEdge(graph, 1, 5);
		graph.addEdge(graph, 1, 6);
		graph.addEdge(graph, 3, 7);
		graph.addEdge(graph, 5, 10);
		graph.addEdge(graph, 7, 8);
		graph.addEdge(graph, 7, 9);
		graph.printBFS(0);
	}
}
