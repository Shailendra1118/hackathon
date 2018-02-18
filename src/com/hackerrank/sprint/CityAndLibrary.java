package com.hackerrank.sprint;

import java.util.Iterator;
import java.util.LinkedList;

public class CityAndLibrary {

	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3); 
        System.out.println("Following is Depth First Traversal "+
                           "(starting from vertex 2)");
 
        g.DFS(2);

	}
	
	static class Graph{
		private int V;
		private LinkedList<Integer> adj[];
		
		@SuppressWarnings("unchecked")
		public Graph(int v){
			this.V = v;
			adj = new LinkedList[this.V];
			for (int i = 0; i < V; i++) {
				adj[i] = new LinkedList<>();
			}
		}
		
		public void addEdge(int u, int w){
			adj[u].add(w);
			adj[w].add(u);
		}
		
		public void DFS(int v){
			// v starting node
			boolean visited[] = new boolean[2*v];
			DFSUtil(v, visited);
		}

		private void DFSUtil(int v, boolean[] visited) {
			//visited true
			visited[v] = true;
			System.out.println("visited :"+v);
			
			Iterator<Integer> iter = this.adj[v].listIterator();
			while(iter.hasNext()){
				int n = iter.next();
				if(! visited[n]){
					DFSUtil(n, visited);
				}
			}
			
		}
	}

}
