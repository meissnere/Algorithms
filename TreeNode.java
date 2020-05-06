package techQuestions;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }

	public TreeNode insertLevelOrder(int[] arr, TreeNode root,
								 int i)
	{
		// Base case for recursion
		if (i < arr.length) {
//			System.out.println(arr[i]);
			TreeNode temp = new TreeNode(arr[i]);
			root = temp;

			// insert left child
			root.left = insertLevelOrder(arr, root.left,
					2 * i + 1);

			// insert right child
			root.right = insertLevelOrder(arr, root.right,
					2 * i + 2);
		}
		return root;
	}

	public TreeNode setNulls(TreeNode root) {
		if (root == null) {
			return null;
		}
		if (root.val == Integer.MIN_VALUE) {
			root = null;
		}
		System.out.println(root.val);
		setNulls(root.left);
		setNulls(root.right);
		return root;
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		if (root != null) {
			q.offer(root);
		}
		TreeNode cur;
		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> subAns = new LinkedList<Integer>();
			for (int i = 0; i < size; ++i) {        // traverse nodes in the same level
				cur = q.poll();
				subAns.add(cur.val);                // visit the root
				if (cur.left != null) {
					q.offer(cur.left);              // push left child to queue if it is not null
				}
				if (cur.right != null) {
					q.offer(cur.right);             // push right child to queue if it is not null
				}
			}
			ans.add(subAns);
		}
		return ans;
	}
}
