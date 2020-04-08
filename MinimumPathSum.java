package techQuestions;

import java.util.Arrays;

public class MinimumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{1,3,1},{1,5,1},{4,2,1},{1,1,1}};
		
		System.out.println(grid.length + " " + grid[0].length);
		
		System.out.println(minPathSum(grid));
	}
	
	public static int minPathSum(int[][] grid) {
		//dynamic programming approach
		
		// first create new grid of same size
		int rows = grid.length;
		int columns = grid[0].length;
//		int[][] dp = new int[rows][columns];
		
		for (int i = rows - 1; i >= 0; i--) {
			for (int j = columns - 1; j >= 0; j--) {
				// we are at the bottom right to begin with; initializing step:
//				if (j == columns - 1 && i == rows-1) {
//					dp[i][j] = grid[rows-1][columns-1];
//				}
				// if we are at the furthest down, dp[i][j] equals what is right
				if (i == rows-1 && j < columns-1) {
					grid[i][j] = grid[i][j+1] + grid[i][j];
				}
				// if we are at the furthest right, dp[i][j] equals what is below
				if (j == columns-1 && i < rows-1) {
					grid[i][j] = grid[i+1][j] + grid[i][j];
				}
				// if we can compare right and left path
				if (i < rows-1 && j < columns-1) {
					grid[i][j] = Math.min(grid[i+1][j], grid[i][j+1]) + grid[i][j];
				}
			}
		}
		
//		for (int i = 0; i < dp.length; i++) {
//			System.out.println(Arrays.deedp[i].toString());
//		}
		
//		System.out.println(Arrays.deepToString(dp));
		return grid[0][0];
    }

}
