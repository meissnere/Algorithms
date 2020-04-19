package techQuestions;

import java.util.Arrays;

public class MinimumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
		System.out.println(minPathSum(grid));
	}
	
	public static int minPathSum(int[][] grid) {
		// brute force method is to traverse every path possible
		// best way to do this is probably recursion
//		if (grid.length == 0) {
//			return 0;
//		}
//		return pathRecurse(grid, 0, 0);

		// let's attempt dynamic programming method
		// we start at the grid at the bottom right
		for (int i = grid.length - 1; i >= 0; i--) {
			for (int j = grid[0].length - 1; j >= 0; j--) {
				if (i == grid.length - 1) {
					if (j == 0) {
						continue;
					}
					grid[i][j - 1] += grid[i][j];
				} else if (j == grid[0].length - 1 && i != grid.length - 1) {
					grid[i][j] += grid[i+1][j];
				} else {
					grid[i][j] += Math.min(grid[i+1][j],grid[i][j+1]);
				}
			}
		}
		return grid[0][0];
    }
    public static int pathRecurse(int[][] grid, int i, int j) {
		int thisValue = grid[i][j];
		// base case is when we reach bottom of grid
		if (i == grid.length - 1 && j == grid[0].length - 1) {
			return thisValue;
		}
		if (i < grid.length - 1 && j < grid[0].length - 1) {
			return thisValue + Math.min(pathRecurse(grid, i + 1, j),
					pathRecurse(grid, i, j + 1));
		} else if (i == grid.length - 1) {
			return thisValue + pathRecurse(grid, i, j+1);
		} else if (j == grid[0].length - 1) {
			return thisValue + pathRecurse(grid, i+1, j);
		}
		return 0;
	}

}
