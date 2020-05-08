package techQuestions;

/*
Purpose: In a binary tree, the root node is at depth 0, and
children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same
depth, but have different parents.

We are given the root of a binary tree with unique values,
and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the
values x and y are cousins.

Author: Erich Meissner
Date: 5/7/20
Time: 1:00 PM
 */


public class CousinsBinaryTree {

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null || root.val == x || root.val == y) {
            return false;
        }
        if (root.left.val == x || root.right.val == y) {
            return false;
        }
        // need a recursive function now
        depthFirstSearch(root, 0, x, y);
        return isCousin;
    }

    int depthAtNode = -1;
    boolean isCousin = false;

    public boolean depthFirstSearch(TreeNode curr_node, int depth, int x, int y) {
        //base case for recursion
        if (curr_node == null) {
            return false;
        }
        // the depth at node is initialized to -1
        // if it isnt that value, then we know we have found the depth
        // of either x or y. stop recursion if we're too deep
        if (this.depthAtNode != -1 && depth > this.depthAtNode) {
            // we went too deep!
            return false;
        }
        // check if the current node we're at is equal to x or y
        if (curr_node.val == x || curr_node.val == y) {
            if (this.depthAtNode == -1) {
                this.depthAtNode = depth;
            }
            // will return false if the two nodes
            // are not at the same level
            // we are checking even if we only found one node
            return this.depthAtNode == depth;
        }

        //depth first on left node
        boolean left = depthFirstSearch(curr_node.left, depth+1, x, y);
        // then recurse on right node
        boolean right = depthFirstSearch(curr_node.right, depth+1, x, y);

        // this.recordedDepth != depth + 1 would ensure node x and y are not
        // immediate child nodes, otherwise they would become siblings.
        if (left && right && this.depthAtNode != depth+1) {
            this.isCousin = true;
        }
        return left || right;
    }

}

class cousinsMain {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        CousinsBinaryTree cousins = new CousinsBinaryTree();
        boolean cousinsBool = cousins.isCousins(root, 4, 5);
        System.out.println(cousinsBool);
    }
}
