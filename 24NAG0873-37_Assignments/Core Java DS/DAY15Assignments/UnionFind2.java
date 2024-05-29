package DAY15Assignments;
import java.util.Arrays;
class UnionFind {
    private int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        Arrays.fill(parent, -1);
    }

    public int find(int x) {
        if (parent[x] == -1)
            return x;
        return parent[x] = find(parent[x]); // Path compression
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY)
            parent[rootX] = rootY;
    }

    public boolean hasCycle(int[][] edges) {
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (find(u) == find(v))
                return true; // Cycle detected
            union(u, v);
        }
        return false; // No cycle found
    }
}

// Usage example
public class UnionFind2 {
    public static void main(String[] args) {
        int n = 4; // Number of nodes
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 0}}; // Example edges
        UnionFind uf = new UnionFind(n);
        boolean hasCycle = uf.hasCycle(edges);
        System.out.println("Graph has cycle: " + hasCycle);
    }
}