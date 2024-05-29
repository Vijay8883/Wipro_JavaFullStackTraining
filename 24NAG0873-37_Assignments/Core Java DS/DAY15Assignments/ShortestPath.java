package DAY15Assignments;

/*
 * Task 1: Dijkstra’s Shortest Path Finder Code Dijkstra’s algorithm to find the
 * shortest path from a start node to every other node in a weighted graph with
 * positive weights
 */

import java.util.*;

class ShortestPath {
    static final int V = 5; // Number of vertices in the graph

    int minDistance(int dist[], Boolean sptSet[]) {
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int v = 0; v < V; v++) {
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        }
        return min_index;
    }

    void printSolution(int dist[], int n) {
        System.out.println("Vertex\tDistance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t" + dist[i]);
        }
    }

    void dijkstra(int graph[][], int src) {
        int dist[] = new int[V];
        Boolean sptSet[] = new Boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        printSolution(dist, V);
    }

    public static void main(String[] args) {
        // Example graph (replace with your own graph)
        int graph[][] = new int[][] {
            {0,6,0,5,9},
            {6,0,5,0,0},
            {0,5,0,5,0},
            {5,0,5,0,3},
            {9,0,0,3,0}
            
        };

        int sourceVertex = 0; // Replace with your desired source vertex
        ShortestPath sp = new ShortestPath();
        sp.dijkstra(graph, sourceVertex);
    }
}