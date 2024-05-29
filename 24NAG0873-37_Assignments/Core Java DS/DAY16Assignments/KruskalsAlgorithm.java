package DAY16Assignments;
import java.util.Arrays;
 
public class KruskalsAlgorithm {
	
	class Edge implements Comparable<Edge> {
        int src, dest, weight;
 
        // Comparator function used for sorting edges
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }
 
    class Subset {
        int parent, rank;
    }
 
    int V, E; // Number of vertices and edges
    Edge edge[]; // Array of all edges
 
    // Create a graph with V vertices and E edges
    KruskalsAlgorithm(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }
 
    // Find set of an element i (uses path compression)
    int find(Subset subsets[], int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }
 
    // Union of two sets x and y (uses union by rank)
    void union(Subset subsets[], int x, int y) {
        int rootX = find(subsets, x);
        int rootY = find(subsets, y);
 
        if (subsets[rootX].rank < subsets[rootY].rank)
            subsets[rootX].parent = rootY;
        else if (subsets[rootX].rank > subsets[rootY].rank)
            subsets[rootY].parent = rootX;
        else {
            subsets[rootY].parent = rootX;
            subsets[rootX].rank++;
        }
    }
 
    // The main function to construct MST using Kruskal's algorithm
    void KruskalMST() {
        Edge result[] = new Edge[V]; // Store the resultant MST
        int e = 0; // Index used for result[]
        int i = 0; // Index used to sort edges
        for (i = 0; i < V; ++i)
            result[i] = new Edge();
 
        // Step 1: Sort all the edges in non-decreasing order of their weight
        Arrays.sort(edge);
 
        // Allocate memory for creating V subsets
        Subset subsets[] = new Subset[V];
        for (i = 0; i < V; ++i)
            subsets[i] = new Subset();
 
        // Create V subsets with single elements
        for (int v = 0; v < V; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
 
        i = 0; // Index used to pick the smallest edge
        while (e < V - 1) {
            // Step 2: Pick the smallest edge and increment the index for next iteration
            Edge nextEdge = new Edge();
            nextEdge = edge[i++];
 
            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);
 
            // If including this edge does not cause cycle, include it in result
            // and increment the index of result for next edge
            if (x != y) {
                result[e++] = nextEdge;
                union(subsets, x, y);
            }
            // Else discard the nextEdge
        }
 
        // Print the contents of result[] to display the built MST
        System.out.println("Following are the edges in the constructed MST");
        for (i = 0; i < e; ++i)
            System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
    }
	public static void main(String[] args) {
		 int V = 4; // Number of vertices in graph
	        int E = 5; // Number of edges in graph
	        KruskalsAlgorithm graph = new KruskalsAlgorithm(V, E);
 
	        // add edge 0-1
	        graph.edge[0].src = 0;
	        graph.edge[0].dest = 1;
	        graph.edge[0].weight = 10;
 
	        // add edge 0-2
	        graph.edge[1].src = 0;
	        graph.edge[1].dest = 2;
	        graph.edge[1].weight = 6;
 
	        // add edge 0-3
	        graph.edge[2].src = 0;
	        graph.edge[2].dest = 3;
	        graph.edge[2].weight = 5;
 
	        // add edge 1-3
	        graph.edge[3].src = 1;
	        graph.edge[3].dest = 3;
	        graph.edge[3].weight = 15;
 
	        // add edge 2-3
	        graph.edge[4].src = 2;
	        graph.edge[4].dest = 3;
	        graph.edge[4].weight = 4;
 
	        graph.KruskalMST();
	    }
 
}