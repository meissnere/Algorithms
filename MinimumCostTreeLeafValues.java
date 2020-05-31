package techQuestions;

/*
Purpose: Given an array arr of positive integers, consider
all binary trees such that:

Each node has either 0 or 2 children;
The values of arr correspond to the values of each leaf in
an in-order traversal of the tree.  (Recall that a node
is a leaf if and only if it has 0 children.)
The value of each non-leaf node is equal to the product
of the largest leaf value in its left and right subtree respectively.
Among all possible binary trees considered, return the
smallest possible sum of the values of each non-leaf node.
It is guaranteed this sum fits into a 32-bit integer.

Input: arr = [6,2,4]
Output: 32
Explanation:
There are two possible trees.  The first has non-leaf node sum 36,
and the second has non-leaf node sum 32.

    24            24
   /  \          /  \
  12   4        6    8
 /  \               / \
6    2             2   4

Author: Erich Meissner
Date: 5/6/20
Time: 11:46 AM
 */


import java.util.Stack;

public class MinimumCostTreeLeafValues {
    public static void main(String[] args) {
        int arr[] = {6,2,4};
        System.out.println(mctFromLeafValues(arr));
    }
    public static int mctFromLeafValues(int[] A) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        for (int a : A) {
//            System.out.println("top of LIFO stack: " + stack.peek()
//            + ", and a is: " + a);
            while (stack.peek() <= a) {
                int mid = stack.pop();
                res += mid * Math.min(stack.peek(), a);
            }
//            System.out.println("res is: " + res);
            stack.push(a);
        }
        while (stack.size() > 2) {
//            System.out.println("res is: " + res + ", and stack size is: " + stack.size());
            res += stack.pop() * stack.peek();
        }
        return res;
    }
}
