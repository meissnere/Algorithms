package techQuestions;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.ConcurrentModificationException;
import java.util.HashMap;

public class CherryPickup {	
	
	public static void main(String[] args) {
		int[][] grid = {{0,1,-1},{1,0,-1},{1,1,1}};
		System.out.println(Arrays.deepToString(grid).replace("], ", "]\n"));
		System.out.println(cherryField(grid));
		}
	
	public static int cherryField(int[][] grid) {
		
		int cherriesCollected = 0;
		
		int rows = grid.length;
		int columns = grid[0].length;
		
		Queue<int []> cherries = new LinkedList<>();
		HashMap<Integer, Integer> thorns = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (grid[i][j] == -1) {
					thorns.put(i, j);
				} else if (grid[i][j] == 1) {
					cherries.add(new int[] {i, j});
				}
			}
		}
		
//		for (Map.Entry<Integer, Integer> entry : thorns.entrySet()) {
//			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
//		}
//
//		// using Iterator to iterate through Queue
//		Iterator<int[]> itr = cherries.iterator();
//
//		// hasNext() returns true if the queue has more elements
//		while (itr.hasNext()) 
//		{
//			// next() returns the next element in the iteration
//			int[] cherry_coordinates = itr.next();
//			// print x and y coordinates of each cherry location
//			System.out.println(cherry_coordinates[0] + ", " + cherry_coordinates[1]);
//		}
		
		int[][] dirs = {{1,0},{0,1}};	
		System.out.println("-----");
		
		int i = 0, j = 0;
		while (i < rows && j < columns) {
			try {
				if (grid[i][j+1] == 1 && isValidMove(rows, i, j, "right") == true) {
					// if right move has cherry, move right
					grid[i][j+1] = 0;
					j++;
					cherriesCollected++;
				} else if (grid[i+1][j] == 1 && isValidMove(rows, i, j, "down") == true) {
					// else if down move has cherry, move down
					grid[i+1][j] = 0;
					i++;
					cherriesCollected++;
				} else if (grid[i][j+1] == -1 && grid[i+1][j] == -1) {
					// else if both right and down are thorns, return error
					return 999;
				} else if  (grid[i][j+1] == -1) {
					// else if right move have thorn, move down
					i++;
					if (grid[i][j] == 1) {
						cherriesCollected++;
						grid[i][j] = 0;
					}
				} else {
					// choose right move over down move if both are 0
					j++;
					if (grid[i][j] == 1) {
						cherriesCollected++;
						grid[i][j] = 0;
					}
				}
				// print new grid at every turn
				System.out.println(Arrays.deepToString(grid).replace("], ", "]\n"));
				System.out.println("i is: " + i + " ----- j is:" + j + "  ---- count is: " + cherriesCollected);
			} catch (ArrayIndexOutOfBoundsException exception) {
				System.out.println("we have reached the bottom right");
				break;
			}
		}
		System.out.println("we have reached the bottom right");
		i = rows - 1;
		j = columns - 1;
		while (i >= 0 && j >= 0) {
			try {
				// if we are at the far left, can only move up!
				if (j == 0) {
					if (grid[i-1][j] == -1) {
						// thorn above! return error!
						return 999;
					}
					i--;
					if (grid[i][j] == 1) {
						cherriesCollected++;
						grid[i][j] = 0;
					}	
				// if we are at the top, can only move left
				} else if (i == 0) {
					if (grid[i][j-1] == -1) {
						// thorn above! return error!
						return 999;
					}
					j--;
					if (grid[i][j] == 1) {
						cherriesCollected++;
						grid[i][j] = 0;
					}	
				}
				else if (grid[i][j-1] == 1 && isValidMove(rows, i, j, "left") == true) {
					// if left move has cherry, move left
					grid[i][j-1] = 0;
					j--;
					cherriesCollected++;
				} else if (grid[i-1][j] == 1 && isValidMove(rows, i, j, "up") == true) {
					// else if up move has cherry, move up
					grid[i-1][j] = 0;
					i--;
					cherriesCollected++;
				} else if (grid[i][j-1] == -1 && grid[i-1][j] == -1) {
					// else if both left and up are thorns, return error
					return 999;
				} else if  (grid[i][j-1] == -1 && isValidMove(rows, i, j, "up") == true) {
					// else if left move has thorn, move up
					i--;
					if (grid[i][j] == 1) {
						cherriesCollected++;
						grid[i][j] = 0;
					}
				} else if (j == 0 && isValidMove(rows, i, j, "up") == true) {
					// hit left most bound, only move up now
					if (grid[i-1][j] == -1) {
						return 999;
					}
					i--;
					if (grid[i][j] == 1) {
						cherriesCollected++;
						grid[i][j] = 0;
					}
				} else if (isValidMove(rows, i, j, "left") == true) {
					// choose left move over up move if both are 0
					j--;
					if (grid[i][j] == 1) {
						cherriesCollected++;
						grid[i][j] = 0;
					}
				}
				// print new grid at every turn
				System.out.println(Arrays.deepToString(grid).replace("], ", "]\n"));
				System.out.println("i is: " + i + " ----- j is:" + j + "  ---- count is: " + cherriesCollected);
			} catch (ArrayIndexOutOfBoundsException exception) {
				System.out.println("we have reached the top left");
				break;
			}
		}
		System.out.println("we have reached the top left");

		
//		System.out.println(cherries.iterator());
//		System.out.println(thorns.iterator());

		return cherriesCollected;
	}
	
	public static boolean isValidMove(int N, int row, int column, String move) {
		System.out.println("is Valid has been called! input is: " + N + row + column + move);
		if (row == 0 && move == "up") {
			System.out.println("at row = 0 and trying to move up!");
			return false;
		} else if (column == 0 && move == "left") {
			System.out.println("at column = 0 and trying to move left!");
			return false;
		} else if (row == N && move == "down") {
			System.out.println("at row = nax and trying to move down!");
			return false;
		} else if (column == N && move == "right") {
			System.out.println("at column = max and trying to move right!");
			return false;
		} else {
			return true;
		}
	}
}
