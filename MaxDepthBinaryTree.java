package techQuestions;

/*
Purpose: Given a binary tree, find its maximum path.
The maximum path is the number of nodes along the longest
path from the root to the farthest leaf node.

Author: Erich Meissner
Date: 5/5/20
Time: 6:22 PM
 */


public class MaxDepthBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(maxDepth(root));
    }

    // standard recursive implementation with 0 returned
    // for null node base case
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left_max = maxDepth(root.left) + 1;
        int right_max = maxDepth(root.right) + 1;
        return Math.max(left_max, right_max);
    }
}
