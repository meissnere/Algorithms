package techquestions;

import java.util.LinkedList;
import java.util.Queue;

public class NumberIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char grid[][] = {{'1','1','1'},{'0','1','0'},{'1','0','0'},{'1','0','1'}};
		
		int r = 5;
		int nc = 4;
		int c = 2;
		
		LRUCache cache = new LRUCache( 2 /* capacity */ );

		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));       // returns 1
		cache.put(3, 3);    // evicts key 2
		System.out.println(cache.get(2));       // returns -1 (not found)
		cache.put(4, 4);    // evicts key 1
		System.out.println(cache.get(1));       // returns -1 (not found)
		System.out.println(cache.get(3));       // returns 3
		System.out.println(cache.get(4));       // returns 4
		
//		System.out.println(bfsNumIslands(grid));
//		System.out.println(numIslands(grid));
	}
	
	public static int numIslands(char[][] grid) {
		// depth first search solution
		if (grid.length == 0 || grid == null) {
			return 0;
		}
		
		int num_columns = grid[0].length;
		int num_rows = grid.length;
		
		int num_islands = 0;
		
		for (int row = 0; row < num_rows; row++) {
			for (int column = 0; column < num_columns; column++) {
				if (grid[row][column] == '1') {
					num_islands++;
					dfs(grid, row, column);
				}
			}
		}
		
		return num_islands;
	}
	
	public static void dfs(char[][] grid, int r, int c) {
		int num_columns = grid[0].length;
		int num_rows = grid.length;
		
		if (r < 0 || c < 0 || r >= num_rows || c >= num_columns || grid[r][c] == '0') {
			return;
		}
		
		// set whatever grid value we're looking at to '0' so we don't perform another DFS on it
		grid[r][c] = '0';
		// look left
		dfs(grid, r, c - 1);
		// loop up
		dfs(grid, r - 1, c);
		// look right
		dfs(grid, r, c + 1);
		// look down, finally
		dfs(grid, r + 1, c);
	}
	
	public static int bfsNumIslands(char[][] grid) {
		if (grid.length == 0 || grid == null) {
			return 0;
		}
		
		int num_columns = grid[0].length;
		int num_rows = grid.length;
		
		int num_islands = 0;
		
		for (int row = 0; row < num_rows; row++) {
			for (int column = 0; column < num_columns; column++) {
				if (grid[row][column] == '1') {
					num_islands++;
					int encoded_value = row * num_columns + column;
					Queue<Integer> BFSqueue = new LinkedList<Integer>();
//					System.out.println("row:" + row + ", column: " + column);
					BFSqueue.add(encoded_value);
					grid[row][column] = '0';
					while(BFSqueue.isEmpty() == false) {
//						System.out.println(BFSqueue.isEmpty());
						int id = BFSqueue.remove();
						int row_here = id / num_columns;
						int column_here = id % num_columns;
						// look left
						if (column_here > 0 && grid[row_here][column_here-1] == '1') {
							int new_encoded = row_here * num_columns + (column_here-1);
							BFSqueue.add(new_encoded);
							grid[row_here][column_here-1] = '0';
						}
						// look up
						if (row_here > 0 && grid[row_here-1][column_here] == '1') {
							int new_encoded = (row_here-1) * num_columns + column_here;
							BFSqueue.add(new_encoded);
							grid[row_here-1][column_here] = '0';
						}
						// look right
						if (column_here < num_columns - 1 && grid[row_here][column_here+1] == '1') {
							int new_encoded = row_here * num_columns + (column_here+1);
							BFSqueue.add(new_encoded);
							grid[row_here][column_here+1] = '0';
						}
						// look down
						if (row_here < num_rows - 1 && grid[row_here+1][column_here] == '1') {
							int new_encoded = (row_here+1) * num_columns + column_here;
							BFSqueue.add(new_encoded);
							grid[row_here+1][column_here] = '0';
						}
//						System.out.println(id);
					}
				}
			}
		}
		
		return num_islands;
	}

}
