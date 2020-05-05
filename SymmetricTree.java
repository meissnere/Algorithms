package techQuestions;

/*
Purpose: given a binary tree, check whether it is
a mirror of itself

    1
   / \
  2   2
 / \ / \
3  4 4  3
is true....

    1
   / \
  2   2
   \   \
   3    3
is not true

Author: Erich Meissner
Date: 5/5/20
Time: 6:56 PM
 */


import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
//        System.out.println(isSymmetric(null));
        System.out.println(isSymmetricRecursive(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        // initialize a queue implemented via linkedList
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // add left and right nodes of root to queue
        queue.add(root.left);
        queue.add(root.right);
        TreeNode currNodeLeft;
        TreeNode currNodeRight;
        while (!queue.isEmpty()) {
//            System.out.println(queue.toString());
            // retrieve first element of queue
            currNodeLeft = queue.poll();
            currNodeRight = queue.poll();
            if (currNodeLeft == null && currNodeRight == null) {
//                System.out.println("continuing!");
                continue;
            }
            if (currNodeLeft == null ^ currNodeRight == null) {
//                System.out.println("wrong!");
                return false;
            }
            if (currNodeLeft.val != currNodeRight.val) {
                return false;
            }
            queue.add(currNodeLeft.left);
            queue.add(currNodeRight.right);
            queue.add(currNodeLeft.right);
            queue.add(currNodeRight.left);
        }
        return true;
    }

    public static boolean isSymmetricRecursive(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricRecurseHelper(root.left, root.right);
    }

    public static boolean isSymmetricRecurseHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null ^ right == null) {
            return false;
        }
        return (left.val == right.val) && isSymmetricRecurseHelper(left.left, right.right)
                && isSymmetricRecurseHelper(left.right, right.left);
    }
}
