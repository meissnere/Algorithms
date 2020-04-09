package techQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		
		List<Integer> output = preorderTraversalIterative(root);
		
		System.out.println(output.toString());
	}
	
	private static List<Integer> list = new ArrayList<>();
	
	public static List<Integer> preorderTraversal(TreeNode root) {
		if (root == null) {
			return new ArrayList<Integer>();
		}		
		list.add(root.val);
		if (root.left != null) {
			preorderTraversal(root.left);
		}
		if (root.right != null) {
			preorderTraversal(root.right);
		}
		
		return list;
	}
	
	public static List<Integer> preorderTraversalIterative(TreeNode root) {
		if (root == null) {
			return new ArrayList<Integer>();
		}
		
		// the recursive method is trivial. what about iterative?
		// we use a stack data structure. pop the current node into the list,
		// and then add its two child nodes
		
		Stack<TreeNode> stack = new Stack<>();
		
		stack.add(root);
		// stack initialized with the root TreeNode
		while (!stack.isEmpty()) {
			TreeNode currNode = stack.pop();
			list.add(currNode.val);
			// add right node to stack first since it will get pushed down
			// if there exists a left node
			if (currNode.right != null) {
				stack.add(currNode.right);
			}
			// now add left node so that it will be at the top of the stack
			if (currNode.left != null) {
				stack.add(currNode.left);
			}
			// stack, if the tree is not only one root node, should have more elements
		}
 		
		return list;
	}

}
