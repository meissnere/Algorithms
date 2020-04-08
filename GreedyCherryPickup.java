package techQuestions;

import java.util.Arrays;

public class GreedyCherryPickup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[][] grid = {{0,-1},{0,1}};
		int[][] grid = {{0,1,-1},{1,0,-1},{1,1,1}};
		System.out.println(Arrays.deepToString(grid).replace("], ", "]\n"));
		System.out.println(GreedyPickup(grid));

	}
	
	public static int GreedyPickup(int[][] grid) {
		int cherriesCollected = 0;
		
		int[][] path = bestPath(grid);
		// remember we return null from bestPath if there is nowhere to go
		if (path == null) return 0;
		for (int[] step: path) {
			// if there is a value of 1 in the path, then cherriesCollected++
			cherriesCollected += grid[step[0]][step[1]];
			// set that grid to equal 0 now that cherry is picked up
            grid[step[0]][step[1]] = 0;
        }

		System.out.println("NEW GRID INCOMING!");
		System.out.println(Arrays.deepToString(grid).replace("], ", "]\n"));
		// there is a new grid now! send that grid to best path 
        for (int[] step: bestPath(grid))
        	cherriesCollected += grid[step[0]][step[1]];

        return cherriesCollected;
	}
	
	public static int[][] bestPath (int[][] grid) {
		int N = grid.length;
		int[][] dp = new int[N][N];

        // fill every grid with minimum integer value
        for (int[] row: dp) Arrays.fill(row, Integer.MIN_VALUE);
        
		// fill bottom right grid with value of original input
		dp[N-1][N-1] = grid[N-1][N-1];
		
		// starting at bottom row
		for (int i = N-1; i >=0; i--) {
			// starting at far right column
			for (int j = N-1; j >= 0; j--) {
				dp[i][j] = Math.max(i+1 < N ? grid[i+1][j] : Integer.MIN_VALUE,
						j+1 < N ? grid[i][j+1] : Integer.MIN_VALUE);
				System.out.println("max value at: " + i + ", " + j + ": " + dp[i][j]);
				// dp grid equals the max value between next two possible steps plus existing grid value
				dp[i][j] += grid[i][j];
			}
		}
		System.out.println(Arrays.deepToString(dp).replace("], ", "]\n"));
		
		// if the first grid of dp is negative, then there must be nowhere to go
		if (dp[0][0] < 0) return null;

        int[][] ans = new int[2*N - 1][2];
		int i = 0, j = 0, t = 0;
		// while i does not equal down border and j does not equal right border
		// loop stops when i and j are at bottom right border
        while (i != N-1 || j != N-1) {
        	// if moving right hits right border, then move down
        	// if moving down does not hit border, 
        	// AND the down move is a better or equal path to the right move, then move down
            if (j+1 == N || i+1 < N && dp[i+1][j] >= dp[i][j+1]) i++;
            // if right move does not hit right border AND
            // (down move hits down border OR right move is better than down move), then move right
            else j++;

            System.out.println("loop: " + (t+1) + "  i, j: " + i + ", " + j);
            ans[t][0] = i;
            ans[t][1] = j;
            t++;
        }
        
		System.out.println(Arrays.deepToString(ans).replace("], ", "]\n"));
		

		return ans;
	}

}
