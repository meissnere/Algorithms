package techQuestions;

/*
Purpose: Given a rectangular cake with height h and width w, and two arrays of integers horizontalCuts
and verticalCuts where horizontalCuts[i] is the distance from the top of the rectangular cake to the ith
horizontal cut and similarly, verticalCuts[j] is the distance from the left of the rectangular cake to the jth vertical cut.

Return the maximum area of a piece of cake after you cut at each horizontal and vertical position provided
in the arrays horizontalCuts and verticalCuts. Since the answer can be a huge number, return this modulo 10^9 + 7.

Author: Erich Meissner
Date: 5/30/2020
Time: 10:37 PM
*/

import java.util.Arrays;

public class MaxAreaCakeHorizVertCuts {
    public static void main(String[] args) {
        int h = 5;
        int w = 4;
        int[] horCuts = {3};
        int[] vertCuts = {3};
        System.out.println(maxArea(h,w,horCuts,vertCuts));
    }

    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxHor = horizontalCuts[0] - 0;
        int maxVert = verticalCuts[0] - 0;
        for (int i = 1; i < horizontalCuts.length; i++) {
           maxHor = Math.max(maxHor, horizontalCuts[i] - horizontalCuts[i-1]);
        }
        for (int j = 1; j < verticalCuts.length; j++) {
            maxVert = Math.max(maxVert, verticalCuts[j] - verticalCuts[j-1]);
        }
        maxHor = Math.max(maxHor, h - horizontalCuts[horizontalCuts.length-1]);
        maxVert = Math.max(maxVert, w - verticalCuts[verticalCuts.length-1]);
        return maxHor * maxVert;
    }


}
