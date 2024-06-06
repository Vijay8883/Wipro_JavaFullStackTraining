package DAY21Assignments;
public class KnightsTour {
	 private static final int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
	    private static final int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
	    private static final int N = 8;

	    public static void main(String[] args) {
	        solveKnightsTour();
	    }

	    private static void solveKnightsTour() {
	        int[][] board = new int[N][N];

	        // Initialize the board with -1 indicating unvisited squares
	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < N; j++) {
	                board[i][j] = -1;
	            }
	        }

	        // Knight starts at the first block
	        board[0][0] = 0;

	        if (solveKTUtil(0, 0, 1, board)) {
	            printSolution(board);
	        } else {
	            System.out.println("Solution does not exist");
	        }
	    }

	    private static boolean solveKTUtil(int x, int y, int movei, int[][] board) {
	        if (movei == N * N) {
	            return true;
	        }

	        for (int k = 0; k < 8; k++) {
	            int nextX = x + dx[k];
	            int nextY = y + dy[k];
	            if (isSafe(nextX, nextY, board)) {
	                board[nextX][nextY] = movei;
	                if (solveKTUtil(nextX, nextY, movei + 1, board)) {
	                    return true;
	                } else {
	                    board[nextX][nextY] = -1; // backtracking
	                }
	            }
	        }
	        return false;
	    }
	    
	    private static boolean isSafe(int x, int y, int[][] board) {
	        return (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1);
	    }
 
	    private static void printSolution(int[][] board) {
	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < N; j++) {
	                System.out.printf("%2d ", board[i][j]);
	            }
	            System.out.println();
	        }
	    }
}
