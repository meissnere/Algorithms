package techQuestions;

/*
Purpose: Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

Author: Erich Meissner
Date: 5/6/20
Time: 12:44 PM

Algorithm

Build hashmap value -> its index for inorder traversal.

Return helper function which takes as the arguments the
left and right boundaries for the current subtree in the
inorder traversal. These boundaries are used only to check
if the subtree is empty or not. Here is how it works
helper(in_left = 0, in_right = n - 1):

If in_left > in_right, the subtree is empty, return None.

Pick the last element in postorder traversal as a root.

Root value has index index in the inorder traversal,
elements from in_left to index - 1 belong to the left
subtree, and elements from index + 1 to in_right belong
to the right subtree.

Following the postorder logic, proceed recursively first
to construct the right subtree helper(index + 1, in_right)
and then to construct the left subtree helper(in_left, index - 1).

Return root.
 */


import java.util.HashMap;
import java.util.List;

public class ConstructBinaryTreeInorderPostorder {

    int postOrderIndex;
    int inorderArr[];
    int postorderArr[];
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorderArr = inorder;
        this.postorderArr = postorder;
        // we know that the last value in the postorder is
        // the root of this binary tree
        postOrderIndex = postorderArr.length - 1;
//        System.out.println(postorderArr[postOrderIndex]);

        // construct a hash map where key = node.val
        // and value = index in inorder array
        int i = 0;
        for (int num: inorderArr) {
            map.put(num, i);
            i++;
        }

        return helper(0, postorderArr.length - 1);
    }

    public TreeNode helper(int left, int right) {
        // recursive base case if to check if left has
        // become larger than right
        if (left > right) {
            return null;
        }

        // the postorder index is the root of this
        // current recursion
        TreeNode root = new TreeNode(postorderArr[postOrderIndex]);

        // now, find the index of this root value in the inorder array
        int in_index = map.get(root.val);

        //for the next recursion, the new root will be 1 smaller
        //than current post order index
        postOrderIndex--;
        //build right subtree
        root.right = helper(in_index+1, right);
        //build left subtree
        root.left = helper(left, in_index-1);
        return root;
    }
}

class main{
    public static void main(String[] args) {
        int inorder[] = {9,3,15,20,7};
        int postorder[] = {9,15,7,20,3};
        ConstructBinaryTreeInorderPostorder constructTree
                = new ConstructBinaryTreeInorderPostorder();
        TreeNode root = constructTree.buildTree(inorder, postorder);
        List<List<Integer>> levelorder = root.levelOrder(root);
        for (List thisList: levelorder) {
            System.out.println(thisList.toString());
        }
    }
}
