package techQuestions;

/*
Purpose: You're given strings J representing the types
of stones that are jewels, and S representing the stones
you have. Each character in S is a type of stone you have.
You want to know how many of the stones you have are also
jewels.



Author: Erich Meissner
Date: 5/2/2020
Time: 10:12 PM
*/


import java.util.HashSet;
import java.util.Set;

public class JewelsStones {
    public static void main(String[] args) {
        String J = "z";
        String S = "ZZ";

        System.out.println(numJewelsInStones(J, S));
    }

    public static int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<Character>();
        for (char c: J.toCharArray()) {
            set.add(c);
        }
        int count = 0;
        for (char c: S.toCharArray()) {
            if (set.contains(c)) {
                count++;
            }
        }
        return count;
    }
}
