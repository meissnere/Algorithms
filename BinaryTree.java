package techQuestions;

import java.util.Iterator;
import java.util.LinkedList;

//Erich's binary tree implementation!
class BinaryTree {
	BinaryTree left, right;
	int data;
	public BinaryTree(int data) {
		this.data = data;
	}
	
	// insert value into binary tree by the rules of binary tree
	public void insert(int value) {
		//if the value to be inserted is less than the current node data
		if (value <= data) {
			// if left node doesn't exist yet, just place new value there
			if (left == null) {
				left = new BinaryTree(value);
				// else, look to insert new value underneath left node
			} else {
				left.insert(value);
			}
		}
		// if value is bigger than current node
		if (value > data) {
			if (right == null) {
				// if no right node, then value is new right node
				right = new BinaryTree(value);
			} else {
				right.insert(value);
			}
		}
	}

	public int maxDepth(BinaryTree root) {
		if (root == null) {
			return 0;
		} else {
			int leftMax = maxDepth(root.left);
			int rightMax = maxDepth(root.right);
			return Math.max(leftMax, rightMax) + 1;
		}
	}
	
	public int maxDepthIterative(BinaryTree root) {
		LinkedList<BinaryTree> stack = new LinkedList<>();
		LinkedList<Integer> depths = new LinkedList<>();
		if (root == null ) {
			return 0;
		}
		
		stack.add(root);
		depths.add(1);
		
		int i = 0;
		int depth = 0, currentDepth = 0;
		while(!stack.isEmpty()) {
//			System.out.println("while loop number: " + i);
			// new root node is the most recent element to be added to this stack
			root = stack.pollLast();
			// new depth is most recent element to be added to depths stack
			currentDepth = depths.pollLast();
			if (root != null) {
//				System.out.println("current root is: " + root.data);
//				System.out.println("currentDepth is: " + currentDepth);
				depth = Math.max(currentDepth, depth);
				stack.add(root.left);
				stack.add(root.right);
				depths.add(currentDepth + 1);
				depths.add(currentDepth + 1);
//				System.out.println("depths: " + depths.toString());
				Iterator<BinaryTree> stackIterator = stack.iterator();
//				System.out.println("here comes stack elements!!!");
				while (stackIterator.hasNext()) {
					BinaryTree current = stackIterator.next();
					if (current != null) {
//						System.out.print(current.data + ", ");
					} else {
//						System.out.print("NULL!, ");
					}
				}
//				System.out.println();
				} else {
//				System.out.println("ROOT WAS NULL!");
//				System.out.println("depths: " + depths.toString());
				Iterator<BinaryTree> stackIterator = stack.iterator();
//				System.out.println("here comes stack elements!!!");
				while (stackIterator.hasNext()) {
					BinaryTree current = stackIterator.next();
					if (current != null) {
//						System.out.print(current.data + ", ");
					} else {
//						System.out.print("NULL!, ");
					}
				}
				
			}
			i++;
		}
		
		return depth;
	}
	
	public void printInOrder() {
		// print left first by recursing down left side
		if (left != null) {
			left.printInOrder();
		}
		// then print root node
		System.out.println(data);
		// finally, recurse down right side
		if (right != null) {
			right.printInOrder();
		}
	}
}

