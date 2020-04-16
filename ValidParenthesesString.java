package techQuestions;

import java.util.Stack;

public class ValidParenthesesString {
    public static void main(String[] args) {
        String s = "(*))";
//        String s = ")(";
//        String s = "(*))";
        // String s = "(*)";
        System.out.println(checkValidString(s));
    }

    static boolean ans = false;

    public static boolean checkValidString(String s) {
//        solve(new StringBuilder(s), 0);
        int low = 0;
        int high = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                high++;
                low++;
            } else if (s.charAt(i) == ')') {
                high--;
                low--;
            } else {
                high++;
                low--;
            }
            if (high < 0) {
                return false;
            }
            // if the low is negative, return its value to 0
            low = Math.max(0, low);
        }
        return low == 0;
    }

    public static void solve(StringBuilder sb, int i) {
//        System.out.println(sb.toString());
        // base case for recursion is checking if i has reached the end of string
        if (i == sb.length()) {
            // answer = answer OR valid(sb)
            ans |= valid(sb);
        } else if (sb.charAt(i) == '*') {
            for (char c: "() ".toCharArray()) {
                System.out.println(c);
                // try open paren, closed paren, empty char
                sb.setCharAt(i, c);
                // for the rest of the string, try to validate if this * was this char c
                solve(sb, i+1);
                if (ans) return;
            }
            sb.setCharAt(i, '*');
        } else
            // if the charAt i is not a star, continue solving the string
            solve(sb, i + 1);
    }

    public static boolean valid(StringBuilder sb) {
        int bal = 0;
        // check the entire sb passed...
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(') bal++;
            if (c == ')') bal--;
            // if there are ever more closed parens, break and return false
            if (bal < 0) break;
        }
        return bal == 0;
    }
}
