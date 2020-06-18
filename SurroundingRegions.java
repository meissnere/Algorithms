package techQuestions;

/*
Purpose: Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board
are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the
border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.

Author: Erich Meissner
Date: 6/17/20
Time: 1:52 PM
 */

import java.util.Arrays;

public class SurroundingRegions {
    public static void main(String[] args) {
        char[][] board = {{'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'},{'X','O','X','O','X', 'O'},
                {'O','X','O','X','O','X'}};
        solve(board);
    }

    public static void solve(char[][] board) {
        // if there are no rows or no columns or null
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        // create visited array and fill completely
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                visited[i][j] = false;
            }
        }
        // check top row -- keep row @ 0 and move right
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                visited = dfs(board, visited, 0, i);
            }
        }
        // check bottom row -- keep row @ length-1 and move right
        for (int i = 0; i < board[0].length; i++) {
            if (board[board.length-1][i] == 'O') {
                visited = dfs(board, visited, board.length-1, i);
            }
        }
        // check leftmost column -- keep column at 0, start row @ 1 and move down
        for (int i = 1; i < board.length - 1; i++) {
            if (board[i][0] == 'O') {
                visited = dfs(board, visited, i, 0);
            }
        }
        // check rightmost column -- keep column @ length[0]-1, start row @ 1
        for (int i = 1; i < board.length - 1; i++) {
            if (board[i][board.length-1] == 'O') {
                visited = dfs(board, visited, i, board[0].length-1);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && visited[i][j] == false) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    public static boolean[][] dfs(char[][] board, boolean[][] visited, int row, int column) {
        // what is base case for recursion? if we visited, then move along
        if (visited[row][column] == true) {
            return visited;
        }
        // mark this grid as visited
        visited[row][column] = true;
        // traverse left
        if (column != 0 && board[row][column-1] == 'O') {
            visited = dfs(board, visited, row, column-1);
        }
        // traverse right
        if (column != board[0].length - 1 && board[row][column+1] == 'O') {
            visited = dfs(board, visited, row, column+1);
        }
        // traverse up
        if (row != 0 && board[row-1][column] == 'O') {
            visited = dfs(board, visited, row-1, column);
        }
        // traverse down
        if (row != board.length - 1 && board[row+1][column] == 'O') {
            visited = dfs(board, visited, row+1, column);
        }
        // visited boolean grid should have set all grids that must be changed
        return visited;
    }
}
