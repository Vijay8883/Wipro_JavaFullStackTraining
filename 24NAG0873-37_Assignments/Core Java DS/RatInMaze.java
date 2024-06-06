package DAY22Assignments;

public class RatInMaze {
    final int N = 6;

    // Function to print the solution matrix
    void printSolution(int[][] solution) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + solution[i][j] + " ");
            System.out.println();
        }
    }

    // Function to check if x, y is valid index for N*N maze
    boolean isSafe(int[][] maze, int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
    }

    // Function to solve the maze using backtracking
    boolean SolveMaze(int[][] maze) {
        int[][] solution = new int[N][N];

        if (!solveMazeUtil(maze, 0, 0, solution)) {
            System.out.println("Solution doesn't exist");
            return false;
        }

        printSolution(solution);
        return true;
    }

    // Utility function to solve the maze
    boolean solveMazeUtil(int[][] maze, int x, int y, int[][] solution) {
        // If (x, y is goal) return true
        if (x == N - 1 && y == N - 1 && maze[x][y] == 1) {
            solution[x][y] = 1;
            return true;
        }

        // Check if maze[x][y] is valid
        if (isSafe(maze, x, y)) {
            // Mark x, y as part of the solution path
            solution[x][y] = 1;

            // Move forward in x direction
            if (solveMazeUtil(maze, x + 1, y, solution))
                return true;

            // If moving in x direction doesn't give solution then move down in y direction
            if (solveMazeUtil(maze, x, y + 1, solution))
                return true;

            // If none of the above movements work then BACKTRACK: unmark x, y as part of solution path
            solution[x][y] = 0;
            return false;
        }

        return false;
    }

    public static void main(String args[]) {
        RatInMaze rat = new RatInMaze();
        int[][] maze = { {1, 0, 0, 0, 0, 0},
                         {1, 1, 1, 1, 1, 1},
                         {0, 1, 0, 0, 0, 0},
                         {1, 1, 1, 1, 1, 1},
                         {1, 1, 1, 1, 1, 1},
                         {1, 1, 1, 1, 1, 1} };
        rat.SolveMaze(maze);
    }
}