package techQuestions;

/*
Purpose: Given a positive integer num, write a
function which returns True if num is a perfect
 square else False.

Note: Do not use any built-in library function
such as sqrt.

Example 1:

Input: 16
Output: true
Example 2:

Input: 14
Output: false

Author: Erich Meissner
Date: 5/10/20
Time: 2:44 AM
 */


public class ValidPerfectSquare {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
    }
    public static boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }
        long left = 2;
        long right = num/2;
        while (left <= right) {
            long midPoint = left + (right - left) / 2;
            long square = midPoint * midPoint;
            if (square == num) {
                return true;
            } else if (square < num) {
                left = midPoint + 1;
            } else {
                right = midPoint - 1;
            }
        }
        return false;
    }
}
