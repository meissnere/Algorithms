package techQuestions;

import java.util.LinkedList;

public class DeleteMiddleNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> list = new LinkedList<>();
		
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(10);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(11);
		list.add(77);
		list.add(12);
		list.add(55);
		
		LinkedListNode n = new LinkedListNode();
		
		n.data = list.poll();
		n.prev = null;
		while (!list.isEmpty()) {
//			LinkedListNode next = new LinkedListNode();
//			n.setNext(next);
			n.next = new LinkedListNode();
			n.next.data = list.poll();
			n = n.next;
		}
		
		while(n.prev != null) {
			System.out.println(n.data);
			n = n.prev;
		}
	}

}
