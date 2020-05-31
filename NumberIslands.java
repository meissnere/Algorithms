package techQuestions;

/*
Purpose: Given a 2d grid map of '1's (land) and '0's (water),
count the number of islands. An island is surrounded by water
and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
Author: Erich Meissner
Date: 5/12/20
Time: 2:22 AM
 */


import java.util.*;

public class NumberIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char grid[][] = {{'1','1','0','0','0'},{'1','1','0','0','0'},
				{'0','0','1','0','0'},{'0','0','0','1','1'}};

		System.out.println(numIslandsNew(grid));
		
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

	static int islandCount = 0;

	public static int numIslandsNew(char[][] grid) {
		if (grid.length == 0) {
			return 0;
		}
		// depth first search attempt
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					// finding all adjacent land masses
					// and setting them to 0
					dfsNew(grid, i, j);
					islandCount++;
				}
			}
		}
		return islandCount;
	}

	public static void dfsNew(char[][] grid, int row, int column) {
		// base case for recursion
		if (row >= grid.length || column >= grid[0].length
			|| row < 0 || column < 0) {
			return;
		}
		if (grid[row][column] == '1') {
			grid[row][column] = 0;
			// look down
			dfsNew(grid, row+1, column);
			// look up
			dfsNew(grid, row-1, column);
			// look right
			dfsNew(grid, row, column+1);
			// look left
			dfsNew(grid, row, column-1);
		} else {
			return;
		}
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
