package com.skdamoda.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstrasSPT {

	public static void main(String[] args) {
		int v = 6;
		Graph graph = new Graph(v);
		graph.addEdge( 0, 1, 2);
		graph.addEdge( 0, 2, 8);
		graph.addEdge( 1, 2, 3);
		graph.addEdge( 1, 3, 2);
		graph.addEdge( 1, 4, 1);
		graph.addEdge( 2, 4, 3);
		graph.addEdge( 3, 4, 4);
		graph.addEdge( 3, 5, 5);
		graph.addEdge( 4, 5, 3);
		graph.printGraph();
		List<ShortestPath> spt = graph.shortestPath(0);
		for(int i=0;i<v;i++) {
			System.out.println(spt.get(i));
		}
		
	}
	
	static class Edge{
		int id;
		int weight;
		Edge(int id,int weight){
			this.id=id;
			this.weight=weight;
		}
	} 
	
	static class ShortestPath implements Comparable{
		int vertex;
		int previousNode;
		int distance;
		ShortestPath(int vertex,int previousNode, int distance){
			this.vertex=vertex;
			this.previousNode=previousNode;
			this.distance=distance;
		}
		@Override
		public int compareTo(Object arg0) {
			ShortestPath spt1=(ShortestPath)arg0;
			return this.distance-spt1.distance;
		}
		@Override
		public boolean equals(Object t) {
			return this.vertex==((ShortestPath)t).vertex;
		}
		@Override
		public String toString() {
			return "Vertex:"+vertex+" PreviousNode:"+previousNode+" Distance:"+distance;
		}
	}
	
	 static class Graph{
			int v;
			LinkedList<Edge> [] adjListArray;
			
			Graph(int v){
				this.v=v;
				adjListArray = new LinkedList[v];
				for(int i=0;i<v;i++) {
					adjListArray[i]=new LinkedList<Edge>();
				}
			}
			
			void addEdge(int src, int dest, int weight){
				Edge e = new Edge(dest,weight);
				adjListArray[src].addFirst(e);
				e = new Edge(src,weight);
				adjListArray[dest].addFirst(e);
			}
			
			void printGraph() {
				for(int i=0;i<v;i++) {
					System.out.println("Adjacency List for Vertex "+i);
					for(Edge e : adjListArray[i]) {
						System.out.println(e.id);
					}
				}
			}
			
			List<ShortestPath> shortestPath(int sourceVertex) {
				//List of spanning tree which captures Node, Previous Node and Distance
				List<ShortestPath> spt = new ArrayList<ShortestPath>(v);
				//List of visited nodes
				boolean visited [] = new boolean [v];
				//Initializing all distance to infinity except source
				for(int i=0;i<v;i++) {
					ShortestPath s = new ShortestPath(i, 0, Integer.MAX_VALUE);
					spt.add(i, s);
				}
				spt.get(sourceVertex).distance=0;
				
				//Initializing Priority Queue to iterate
				PriorityQueue<ShortestPath> queue = new PriorityQueue<ShortestPath>(v);
				queue.add(spt.get(sourceVertex));
				//Iterating through priority queue for all the nodes.
				while(!queue.isEmpty()) {
					ShortestPath currentSPT = queue.poll();
					int currentVertex=currentSPT.vertex;
					LinkedList<Edge> currentAdjList= adjListArray[currentVertex];
					for(Edge e:currentAdjList) {
						//For all the neighbouring nodes
						int node = e.id;
						//Verify if already visited
						if(visited[node]==false) {
							visited[node]=true;
							int currentDistance=spt.get(node).distance;
							int calculatedDistance=e.weight+spt.get(currentVertex).distance;
							if(calculatedDistance<currentDistance) {
								spt.get(node).distance=calculatedDistance;
								spt.get(node).previousNode=currentVertex;
								queue.add(spt.get(node));
							}
						}
					}
				}
				
				return spt;
				
			}
		}

}
