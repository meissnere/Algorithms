package techQuestions;

public class MinimumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
		
		System.out.println(grid.length + " " + grid[0].length);
		
		System.out.println(minPathSum(grid));
	}
	
	public static int minPathSum(int[][] grid) {
		return minRecurse(grid, 0, 0);
    }
	
	public static int minRecurse(int[][] grid, int i, int j) {
		if (i >= grid.length && j >= grid[0].length) {
			return grid[i][j];
		}
		
		int rightSum;
		if (j+1 < grid[0].length) {
			rightSum = minRecurse(grid, i, j+1);
		} else {
			rightSum = Integer.MAX_VALUE;
		}
		
		int downSum;
		if (i+1 < grid.length) {
			downSum = minRecurse(grid, i+1, j);
		} else {
			downSum = Integer.MAX_VALUE;
		}
		
		return Math.min(rightSum, downSum);
	}

}
