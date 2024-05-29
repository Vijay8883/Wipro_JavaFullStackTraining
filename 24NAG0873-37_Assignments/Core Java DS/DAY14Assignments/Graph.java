package DAY14Assignments;


import java.util.*;
class Graph {
 private int vertices; // Number of vertices
 private LinkedList<Integer> adjList[]; // Adjacency List
 // Constructor
 Graph(int v) {
 vertices = v;
 adjList = new LinkedList[v];
 for (int i = 0; i < v; ++i) {
 adjList[i] = new LinkedList();
 }
 }
 // Method to add an edge to the graph
 void addEdge(int v, int w) {
 adjList[v].add(w); // Add w to v's list
 adjList[w].add(v); // Since the graph is undirected, also add v to 
//w's list
 }
 // BFS traversal from a given source s
 void BFS(int s) {
 // Mark all the vertices as not visited (by default set as false)
 boolean visited[] = new boolean[vertices];
 // Create a queue for BFS
 LinkedList<Integer> queue = new LinkedList<>();
 // Mark the current node as visited and enqueue it
 visited[s] = true;
 queue.add(s);
 while (queue.size() != 0) {
 // Dequeue a vertex from queue and print it
 s = queue.poll();
 System.out.print(s + " ");
 // Get all adjacent vertices of the dequeued vertex s
 // If an adjacent has not been visited, then mark it visited 
//and enqueue it
 Iterator<Integer> i = adjList[s].listIterator();
 while (i.hasNext()) {
 int n = i.next();
 if (!visited[n]) {
 visited[n] = true;
		 queue.add(n);
		 }
		 }
		 }
		 }
		 // Driver method to test the BFS method
		 public static void main(String args[]) {
		 Graph g = new Graph(6);
		 g.addEdge(0, 1);
		 g.addEdge(0, 2);
		 g.addEdge(1, 3);
		 g.addEdge(1, 4);
		 g.addEdge(2, 4);
		 g.addEdge(3, 4);
		 g.addEdge(3, 5);
		 g.addEdge(4, 5);
		 System.out.println("Breadth First Traversal starting from vertex 0:");
		 g.BFS(0);
		 }
}