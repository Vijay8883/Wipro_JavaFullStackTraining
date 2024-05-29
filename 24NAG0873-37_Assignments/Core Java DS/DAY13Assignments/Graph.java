package DAY13Assignments;

/*Day 13
Task 4:Graph Edge Addition Validation Given a directed graph, write a function that adds an edge between two nodes and then checks if the graph still has no cycles. If a cycle is created, the edge should not be added.


In Java, you can create a function that attempts to add an edge to a directed graph and then checks for cycles using Depth-First Search (DFS). If a cycle is detected, the edge is not added. Here’s a simple implementation:*/


import java.util.*;

public class Graph {
    private Map<Integer, List<Integer>> adjList = new HashMap<>();
    private Set<Integer> visited;
    private Set<Integer> recStack;

    public void addNode(int node) {
        adjList.putIfAbsent(node, new ArrayList<>());
    }

    public boolean addEdge(int start, int end) {
        // Add the edge tentatively
        addNode(start);
        addNode(end);
        adjList.get(start).add(end);

        // Check for cycles
        visited = new HashSet<>();
        recStack = new HashSet<>();

        for (int node : adjList.keySet()) {
            if (dfs(node)) {
                // Cycle detected, remove the edge and return false
                adjList.get(start).remove(Integer.valueOf(end));
                return false;
            }
        }
        // No cycles detected, return true
        return true;
    }

    private boolean dfs(int node) {
        // Node is already in the recursion stack, cycle detected
        if (recStack.contains(node)) {
            return true;
        }
        // If it's already visited (and not in the recStack), no need to visit again
        if (visited.contains(node)) {
            return false;
        }

        visited.add(node);
        recStack.add(node);

        // Visit all the neighbors
        if (adjList.containsKey(node)) {
            for (int neighbor : adjList.get(node)) {
                if (dfs(neighbor)) {
                    return true;
                }
            }
        }

        // Remove the node from the recursion stack before returning
        recStack.remove(node);
        return false;
    }
}

/*
 * This Graph class has a method addEdge that tries to add an edge and checks
 * for cycles. If a cycle is found, it removes the edge and returns false.
 * Otherwise, it returns true, indicating the edge has been successfully added
 * without creating a cycle.
 * 
 */