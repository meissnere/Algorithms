package techQuestions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NumberIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char grid[][] = {{'1','1','0','0','0'},{'1','1','0','0','0'},
				{'0','0','1','0','0'},{'0','0','0','1','1'}};

		System.out.println(numIslands(grid));
		
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
		return 1;
	}

}
