package techQuestions;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxPointsCards {
//   There are several cards arranged in a row, and
//   each card has an associated number of points. The
//   points are given in the integer array cardPoints.
//
//   In one step, you can take one card from the beginning
//   or from the end of the row. You have to take exactly k cards.
//
//   Your score is the sum of the points of the cards you have taken.
//
//   Given the integer array cardPoints and the integer k, return
//   the maximum score you can obtain.
    public static void main(String[] args) {
        int[] cardPoints = {1,2,3,4,5,6,1};
        int k = 3;
        System.out.println(maxScore(cardPoints, k));
    }
    // brute force approach: based on the number of cards we are allowed
    // to draw, try every combination of drawing!
    public static int maxScore(int[] cardPoints, int k) {
        if (cardPoints.length == 0) {
            return 0;
        }
        Deque<Integer> deque = new ArrayDeque<Integer>();
        for (int point: cardPoints) {
            deque.addLast(point);
        }
        System.out.println(deque.toString());
        // start recursion with left pick first
        int leftFirst = calcMax(cardPoints, k, true);
        // start recursion with right pick first
        int rightFirst = calcMax(cardPoints, k, false);

        return Math.max(leftFirst, rightFirst);
    }

    private static int leftTurns = -1;
    private static int rightTurns = -1;

    private static int leftChoice = 0;
    private static int rightChoice = 0;

    public static int calcMax(int[] cardPoints, int draws, boolean leftDraw) {
        // base case for recursion: if there are no more
        // draws left, then return up stack 0
        if (draws == 0) {
            return 0;
        }
        if (leftDraw) {
            leftTurns++;
            leftChoice = leftChoice + cardPoints[leftTurns] + calcMax(cardPoints, draws-1, true);
        }
        rightTurns++;
        rightChoice = rightChoice + cardPoints[cardPoints.length - 1 - rightTurns] + calcMax(cardPoints, draws - 1, true);
        return Math.max(leftChoice, rightChoice);
    }
}
