package techQuestions;

import java.util.HashMap;

public class CopyListRandomPointer {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// [[7,null],[13,0],[11,4],[10,2],[1,0]]
		Node node = new Node(7);
		node.random = null;
//		System.out.println(node.val);
		
		node.next = new Node(13);
		node.next.random = node;
//		System.out.println(node.next.random.val);
		
		// second node's existence
		node.next.next = new Node(11);

		node.next.next.next = new Node(10);
		node.next.next.next.random = node.next.next;
//		System.out.println(node.next.next.next.random.val);
		
		node.next.next.next.next = new Node(1);
		node.next.next.next.next.random = node;
//		System.out.println(node.next.next.next.next.random.val);
		
		// second node's random pointer
		node.next.next.random = node.next.next.next.next;
//		System.out.println(node.next.next.random.val);
		
		Node output = copyRandomList(node);
		
//		System.out.println("-----------");
		while (output != null) {
			System.out.println(output.val);
			output = output.next;
		}
	}
	
	static HashMap<Node, Node> visitedHash = new HashMap<>();
	
	public static Node copyRandomList(Node head) {
		// implement recursively and with a hash map!
		
		// first, a recursive program must always have a base case!
		if (head == null) {
			return null;
		}
		
		
		if (visitedHash.containsKey(head)) {
			return visitedHash.get(head);
		}
		
		Node node = new Node(head.val);
		node.next = null;
		node.random = null;
		
		visitedHash.put(head, node);
		
		node.next = copyRandomList(head.next);
		node.random = copyRandomList(head.random);
		
		return node;
	}

}
