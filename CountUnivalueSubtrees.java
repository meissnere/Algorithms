package techQuestions;

/*
Purpose: determining count of univalue subtrees
Author: Erich Meissner
Date: 5/5/20
Time: 9:35 PM
 */


public class CountUnivalueSubtrees {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(5);
        System.out.println(countUnivalSubtrees(root));
    }

    public static int count = 0;

    public static int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        isUnival(root);
        return count;
    }

    public static boolean isUnival(TreeNode root) {
        // base case for child node
        if (root.left == null && root.right == null) {
            count++;
            return true;
        }
        // initialize is univalue boolean to be true
        boolean isUnival = true;

        if (root.left != null) {
            isUnival = isUnival(root.left) && root.val == root.left.val;
        }
        if (root.right != null) {
            isUnival = isUnival(root.right) && isUnival && root.val == root.right.val;
        }

        // if the root at this point is not univalued
        if (!isUnival) {
            return false;
        }
        count++;
        return true;
    }

}
