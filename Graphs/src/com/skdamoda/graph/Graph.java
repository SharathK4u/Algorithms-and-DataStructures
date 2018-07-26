package com.skdamoda.graph;

import java.util.LinkedList;

public class Graph {
	//Number of Vertices
	int v;
	//The array of linked list which stores the data
	LinkedList<Integer> [] adjListArray;
	
	Graph(int v){
		this.v=v;
		adjListArray = new LinkedList[v];
		for(int i=0;i<v;i++) {
			adjListArray[i]=new LinkedList<Integer>();
		}
	}
	
	private void addEdge(Graph graph,int src, int dest) {
		graph.adjListArray[src].addFirst(dest);
		graph.adjListArray[dest].addFirst(src);
	}
	
	private void printGraph(Graph graph) {
		for(int i=0;i<graph.v;i++) {
			System.out.println("Adjacency list of vertex for "+i);
			for(Integer vertex : graph.adjListArray[i] )
				System.out.println("-->"+vertex);
		}
	}
	
	public static void main(String [] args) {
		int v = 5;
		Graph g = new Graph(v);
		g.addEdge(g, 0, 1);
		g.addEdge(g, 1, 4);
		g.addEdge(g, 2, 1);
		g.addEdge(g, 3, 1);
		g.addEdge(g, 3, 2);
		g.printGraph(g);
	}
}
