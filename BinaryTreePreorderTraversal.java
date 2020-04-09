package techQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		List<List<Integer>> output = levelOrder(root);
		
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
	
	public static List<Integer> inorderTraversal(TreeNode root) {
		if (root == null) {
			return new ArrayList<Integer>();
		}
		
		// keep looking left until there isn't a node there
		if (root.left != null) {
			inorderTraversal(root.left);
		}
		// there is no left node, print the root we're currently at
		list.add(root.val);
		// after left and root has been added to list, then add right
		if (root.right != null) {
			inorderTraversal(root.right);
		}
		
		return list;		
	}
	
	public static List<Integer> inorderTraversalIterative(TreeNode root) {
		if (root == null) {
			return new ArrayList<Integer>();
		}
		// again, the recursive method is trivial. what about iterative?
		// we use a stack data structure. pop the current node into the list,
		// and then add its root and right nodes
		Stack<TreeNode> stack = new Stack<>();
		
		TreeNode leftMost = root;
		while (leftMost != null || !stack.isEmpty()) {
			while (leftMost != null) {
				stack.add(leftMost);
				leftMost = leftMost.left;
			}
			leftMost = stack.pop();
			list.add(leftMost.val);
			leftMost = leftMost.right;
		}
		return list;
	}
	
	public static List<Integer> postorderTraversal(TreeNode root) {
		if (root == null) {
			return new ArrayList<Integer>();
		}
		
		// keep looking left until there isn't a node there
		if (root.left != null) {
			inorderTraversal(root.left);
		}
		// after left has been added to list, then add right
		if (root.right != null) {
			inorderTraversal(root.right);
		}
		// there is no left or right node, print the root we're currently at
		list.add(root.val);
		
		return list;	
	}

	public static List<Integer> postorderTraversalIterative(TreeNode root) {
		if (root == null) {
			return new ArrayList<Integer>();
		}
		// again, the recursive method is trivial. what about iterative?
		// we use a stack data structure. pop the current node into the list,
		// and then add its root and right nodes
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode currNode = stack.pop();
			list.add(0, currNode.val);
			if (currNode.left != null) {
				stack.add(currNode.left);
			}
			if (currNode.right != null) {
				stack.add(currNode.right);
			}
		}
		
		return list;
	}
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null) {
			return new ArrayList<List<Integer>>();
		}
		
	}
	
	private static List<List<Integer>> doubleList = new ArrayList<List<Integer>>();

	public static void levelOrderHelper(TreeNode node, int level) {
		// using BFS to do level order traversal
				List<Integer> queue = new ArrayList<>();
				queue.add(root.val);
				doubleList.add(queue);
				queue = new ArrayList<>();
				while (root.left != null || root.right != null) {
					queue = new ArrayList<>();
					if (root.left != null) {
						queue.add(root.left.val);
					}
					if (root.right != null) {
						queue.add(root.right.val);
					}
					doubleList.add(queue);
				}
				
				return doubleList;
	}
}
