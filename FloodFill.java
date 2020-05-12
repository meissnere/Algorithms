package techQuestions;

/*
Purpose: An image is represented by a 2-D array of integers,
each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column)
of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel,
plus any pixels connected 4-directionally to the starting pixel
of the same color as the starting pixel, plus any pixels connected
4-directionally to those pixels (also with the same color as
the starting pixel), and so on. Replace the color of all of
the aforementioned pixels with the newColor.

At the end, return the modified image.

Example 1:
Input:
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation:
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.

Author: Erich Meissner
Date: 5/11/20
Time: 6:22 PM
 */


import java.util.*;

public class FloodFill {

    public static void main(String[] args) {
        int[][] image = {{0,0,0},{0,1,1}};
        int sr = 1;
        int sc = 1;
        int newColor = 1;
        System.out.println(Arrays.deepToString(floodFill(image, sr, sc, newColor)));
    }

//    static Set<String> visited = new HashSet<String>();
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
//        int[][] newImage = new int[image.length][image[0].length];
        if (image == null) {
            return null;
        }
        if (image.length == 0) {
            return image;
        }
        Queue<String> queue = new LinkedList<String>();
        queue.add("" + sr + sc);
        int existingColor = image[sr][sc];
        image[sr][sc] = newColor;
//        visited.add("" + sr + sc);
        System.out.println("" + sr + sc);
        boolean [][] visited = new boolean [image.length][image[0].length];
        // Good practice to have dirs array to avoid
        int [][] dirs = new int [][]{{0,1},{1,0}, {-1,0},{0,-1}};
        while (!queue.isEmpty()) {
            String top = queue.poll();
            image[top.charAt(0) - '0'][top.charAt(1) - '0'] = newColor;
            for (int[] dir: dirs) {
                int row = dir[0] + top.charAt(0) - '0';
                int column = dir[1] + top.charAt(1) - '0';
                if (row>= 0 && row < image.length &&
                        column >=0 && column < image[0].length
                        && image[row][column] == existingColor
                        && !visited[row][column]) {
//                    image[row-1][column] = newColor;
                    queue.add("" + row + column);
                    visited[row][column] = true;
                }
            }
//            int row = top.charAt(0) - '0';
//            int column = top.charAt(1) - '0';
//            System.out.println(row + " " + column);
//            // check up first
//            if (row-1 >= 0 && image[row-1][column] == existingColor
//                    && !visited.contains("" + (row-1) + column)) {
//                image[row-1][column] = newColor;
//                queue.add("" + (row-1) + column);
//                visited.add("" + (row-1) + column);
//            }
//            // now right
//            if (column+1 < image[0].length && image[row][column+1] == existingColor
//                    && !visited.contains("" + row + (column+1))) {
//                image[row][column+1] = newColor;
//                queue.add("" + row + (column+1));
//                visited.add("" + row + (column+1));
//            }
//            // now down
//            if (row+1 < image.length && image[row+1][column] == existingColor
//                    && !visited.contains("" + (row+1) + column)) {
//                image[row+1][column] = newColor;
//                queue.add("" + (row+1) + column);
//                visited.add("" + (row+1) + column);
//            }
//            // now left
//            if (column-1 >= 0 && image[row][column-1] == existingColor
//                    && !visited.contains("" + row + (column-1))) {
//                image[row][column-1] = newColor;
//                queue.add("" + row + (column-1));
//                visited.add("" + row + (column-1));
//            }
        }
        return image;
    }
}
