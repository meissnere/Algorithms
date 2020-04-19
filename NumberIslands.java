package techQuestions;

import java.util.*;

public class NumberIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char grid[][] = {{'1','1','0','0','0'},{'1','1','0','0','0'},
				{'0','0','1','0','0'},{'0','0','0','1','1'}};

		System.out.println(bfsNumIslands(grid));
		
//		int r = 5;
//		int nc = 4;
//		int c = 2;
		
//		LRUCache cache = new LRUCache( 2 /* capacity */ );
//
//		cache.put(1, 1);
//		cache.put(2, 2);
//		System.out.println(cache.get(1));       // returns 1
//		cache.put(3, 3);    // evicts key 2
//		System.out.println(cache.get(2));       // returns -1 (not found)
//		cache.put(4, 4);    // evicts key 1
//		System.out.println(cache.get(1));       // returns -1 (not found)
//		System.out.println(cache.get(3));       // returns 3
//		System.out.println(cache.get(4));       // returns 4
		
//		System.out.println(bfsNumIslands(grid));
//		System.out.println(numIslands(grid));
	}
	
	public static int numIslands(char[][] grid) {
		if (grid.length == 0) {
			return 0;
		}
		// count for num of islands
		int numIslands = 0;
		// depth first search solution
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					dfs(grid, i, j);
					numIslands++;
				}
			}
		}
		return numIslands;
	}
	
	public static void dfs(char[][] grid, int r, int c) {
		// base case for dfs recursion?
		if (grid[r][c] == '0' || r >= grid.length ||
				c >= grid[0].length || c < 0 || r < 0) {
			return;
		}
		// set incoming grid value to equal zero since we have traversed it
		grid[r][c] = '0';
		// look right and if 1, recurse on right value
		if (c + 1 < grid[0].length && grid[r][c+1] == '1') {
			dfs(grid, r, c+1);
		}
		// look down and if 1, recurse on down value
		if (r + 1 < grid.length && grid[r+1][c] == '1') {
			dfs(grid, r+1, c);
		}
		// look left and if 1, recurse on left value
		if (c - 1 >= 0 && grid[r][c-1] == '1') {
			dfs(grid, r, c-1);
		}
		// look up and if 1, recurse on up value
		if (r - 1 >= 0 && grid[r-1][c] == '1') {
			dfs(grid, r-1, c);
		}
		return;
	}
	
	public static int bfsNumIslands(char[][] grid) {
		if (grid.length == 0) {
			return 0;
		}
		int numColumns = grid[0].length;
		int numRows = grid.length;
		int numIslands = 0;
		// we no longer want to recurse deeper into the grid, rather
		// we want to look at all adjacent grids first, and then
		// recurse deeper. We can use a queue data structure to add
		// all adjacent elements and then view their adjacent elements
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					// create an id for a grid element
					queue.add(1);
					// we have visited this grid
					grid[i][j] = '0';
					System.out.println("time for new island starting at: " + i + " " + j);
					// now that we have looked through this whole queue, we
					// must add the island we have finished checking out
					numIslands++;
				}
				// now that we have found a land mass, time to iterate on it:
				// as long as the queue has not emptied
				int row = i;
				int column = j;
				while (!queue.isEmpty()) {
					System.out.println(queue.size());
					// look up
					if (row - 1 >= 0 && grid[row - 1][j] == '1') {
						queue.add(1);
						grid[row - 1][j] = '0';
					}
					// look right
					if (j + 1 < numColumns && grid[i][j + 1] == '1') {
						queue.add(1);
						grid[i][j + 1] = '0';
					}
					// look down
					if (i + 1 < numRows && grid[i + 1][j] == '1') {
						queue.add(1);
						grid[i + 1][j] = '0';
					}
					// look left
					if (j - 1 >= 0 && grid[i][j - 1] == '1') {
						queue.add(1);
						grid[i][j - 1] = '0';
					}
					// after we have looked at this grid element that we have
					// just checked all adjacent elements for, we can remove it from
					// the queue.
					queue.poll();
				}
			}
		}
		return numIslands;
	}

}
