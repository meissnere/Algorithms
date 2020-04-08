package techQuestions;

import java.util.LinkedList;

public class KthToLast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> list = new LinkedList<>();
		
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		
		LinkedListNode n = new LinkedListNode();
		
		n.data = list.poll();
		n.prev = null;
		while (!list.isEmpty()) {
			LinkedListNode next = new LinkedListNode();
			n.setNext(next);
			n.next.data = list.poll();
			n = n.next;
		}
		
		while(n.prev != null) {
			n = n.prev;
		}
		
		
		int ans = kthToLast(n, 3);
		
		System.out.println(ans);
	}
	
	public static int kthToLast(LinkedListNode n, int k) {
		// iterative solution!
		LinkedListNode p2 = n;
		
		int i = 0;
		while (i < k) {
			p2 = p2.next;
			System.out.println(p2.data + " is p2 data");
			i++;
		}
		
		System.out.println(p2.data);

		while (p2 != null) {
			n = n.next;
			System.out.println(n.data + " and p2 is: " + p2.data);
			p2 = p2.next;
		}
		
		return n.data;
		
	}

}
