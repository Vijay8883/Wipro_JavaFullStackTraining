package com.graph;

public class UnionFind {
	int[] parent, rank;
 
    // Initialize the parent and rank arrays
    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
 
    // Find the root of the set containing x
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);  // Path compression
        }
        return parent[x];
    }
 
    // Union by rank of the sets containing x and y
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
 
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
 
    // Method to detect cycle in an undirected graph
    public boolean hasCycle(int[][] edges) {
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
 
            int rootU = find(u);
            int rootV = find(v);
 
            if (rootU == rootV) {
                return true;
            }
 
            union(u, v);
        }
        return false;
    }
	public static void main(String[] args) {
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 0 } };  // Example graph with a cycle
        UnionFind uf = new UnionFind(3);
 
        if (uf.hasCycle(edges)) {
            System.out.println("Graph contains a cycle");
        } else {
            System.out.println("Graph does not contain a cycle");
        }
 
	}
 
}