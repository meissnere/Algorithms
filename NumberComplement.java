package techQuestions;

/*
Purpose: Given a positive integer, output its complement number.
The complement strategy is to flip the bits of its binary
representation.

Author: Erich Meissner
Date: 5/4/20
Time: 5:30 PM
 */

public class NumberComplement {
    public static void main(String[] args) {
        System.out.println(findComplement(5));
    }

    public static int findComplement(int num) {
        if (num == 0) {
            return 1;
        }
        int currBit = 1;
        int rightShift = num;
        while (rightShift != 0) {
            num = num ^ currBit;
            currBit = currBit << 1;
            rightShift = rightShift >> 1;
        }
        return num;
    }
}
