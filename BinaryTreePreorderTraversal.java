package techQuestions;

import java.util.ArrayList;
import java.util.List;

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
		list.add(root.val);
		if (root.left != null) {
			preorderTraversal(root.left);
		}
		if (root.right != null) {
			preorderTraversal(root.right);
		}
		
		return list;
	}

}
