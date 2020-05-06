package techQuestions;

/*
Purpose: Given a binary tree and a sum, determine if the tree
has a root-to-leaf path such that adding up all the values
along the path equals the given sum.

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1

Sum = 22, return true 5>4>11>2

Author: Erich Meissner
Date: 5/5/20
Time: 7:56 PM
 */


import java.util.List;

public class PathSum {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        int levelOrderArr[] = {5,4,8,11,Integer.MIN_VALUE,13,4,7,2,
//                Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,
//                Integer.MIN_VALUE,Integer.MIN_VALUE,1};
//        root = root.insertLevelOrder(levelOrderArr, root, 0);
//        List<List<Integer>> answer = root.levelOrder(root);
//        for (List<Integer> list: answer) {
//            System.out.println(list.toString());
//        }
//        root = root.setNulls(root);
//        System.out.println(root.left.val);
        TreeNode real = new TreeNode(5);
        real.left = new TreeNode(4);
        real.right = new TreeNode(8);
        real.left.left = new TreeNode(11);
        real.left.left.left = new TreeNode(7);
        real.left.left.right = new TreeNode(2);
        real.right.left = new TreeNode(13);
        real.right.right = new TreeNode(4);
        real.right.right.right = new TreeNode(1);
        System.out.println(hasPathSum(real, 22));
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        // base case if the node we're currently at doesn't exist
        if (root == null) {
            return false;
        }
        // root is not null, recompute sum
        sum = sum - root.val;
        // we reached a child node, check if the sum has been reduced
        // to 0
        if (root.left == null && root.right == null) {
            return sum == 0;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    // iterative solution involves depth first search and using a stack

//    public static boolean computeSum(TreeNode root, int currSum, int targetSum) {
//        // base case -- we hit a leaf, check if equal to target!
//        if (root.right == null && root.left == null && currSum == targetSum) {
//            return true;
//        } else if (root.right == null && root.left == null) {
//            return false;
//        }
//        currSum = root.val + currSum;
//        return computeSum(root.left, currSum, targetSum) ||
//                computeSum(root.right, currSum, targetSum);
//    }

}
