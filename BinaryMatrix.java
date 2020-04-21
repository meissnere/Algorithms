package techQuestions;

import java.util.ArrayList;
import java.util.List;

interface BinaryMatrix {
    public int get(int x, int y);
    public List<Integer> dimensions();
};

class Solution implements BinaryMatrix {
    int grid[][] = {{0,0,0,1},{0,0,1,1},{0,1,1,1}};
    public int get(int x, int y) {
        return grid[x][y];
    }

    public List<Integer> dimensions() {
        List<Integer> dimensions = new ArrayList<>();
        dimensions.add(grid.length);
        dimensions.add(grid[0].length);
        return dimensions;
    }

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
//        System.out.println(dimensions().toString());
//        System.out.println(dimensions().get(0));

        // initialize a pointer p that starts at top-right corner
        int p = binaryMatrix.dimensions().get(1) - 1; // far right column
        int i = 0; // top row
        int leftMostCol = Integer.MAX_VALUE;
        while (p >= 0) {
//            System.out.println("i is: " + i + ", p is: " + p);
//            System.out.println("value here is: " + binaryMatrix.get(i, p));
            if (binaryMatrix.get(i,p) == 0) {
                // move down to next row if we find a 0
                i++;
                if (i == binaryMatrix.dimensions().get(0)) {
                    break;
                }
                continue;
            } else {
                // we found a one! update the leftMostColumn
                leftMostCol = Math.min(p, leftMostCol);
                p--;
            }
        }
        // if we never found a 0, leftMost will still be huge
        if (leftMostCol == Integer.MAX_VALUE) {
            return -1;
        }
        return leftMostCol;
    }
}

class MyMainClass {
    public static void main(String[] args) {
        Solution myMat = new Solution();
        System.out.println(myMat.leftMostColumnWithOne(myMat));
    }
}
