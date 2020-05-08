package techQuestions;

/*
Purpose: Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

Author: Erich Meissner
Date: 5/6/20
Time: 2:05 PM
 */


import java.util.HashMap;
import java.util.List;

public class ConstructBinaryTreeInorderPreorder {

    int preOrderIndex = 0;
    int inorderArr[];
    int preorderArr[];
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] preorder) {
        this.inorderArr = inorder;
        this.preorderArr = preorder;
        // we know that the first value in the preorder is
        // the root of this binary tree
//        preOrderIndex = 0;
//        System.out.println(preorderArr[preOrderIndex]);

        // construct a hash map where key = node.val
        // and value = index in inorder array
        int i = 0;
        for (int num: inorderArr) {
            map.put(num, i);
            i++;
        }

        TreeNode root = helper(0, preorderArr.length);
        System.out.println(root.val);
        return root;
    }

    public TreeNode helper(int left, int right) {
        // recursive base case if to check if left has
        // become larger than right
        if (left == right) {
            return null;
        }

        // the preorder index is the root of this
        // current recursion
        TreeNode root = new TreeNode(preorderArr[preOrderIndex]);
//        System.out.println(root.val);

        // now, find the index of this root value in the inorder array
        int in_index = map.get(root.val);
//        System.out.println(in_index);

        //for the next recursion, the new root will be 1 larger
        //than current pre order index
        preOrderIndex++;
        //build left subtree
        root.left = helper(left, in_index);
        //build right subtree
        root.right = helper(in_index+1, right);
        return root;
    }
}

class mainConstruct{
    public static void main(String[] args) {
        int inorder[] = {9,3,15,20,7};
        int preorder[] = {3,9,20,15,7};
        ConstructBinaryTreeInorderPreorder constructTree
                = new ConstructBinaryTreeInorderPreorder();
        TreeNode root = constructTree.buildTree(inorder, preorder);
        List<List<Integer>> levelorder = root.levelOrder(root);
        for (List thisList: levelorder) {
            System.out.println(thisList.toString());
        }
    }
}
