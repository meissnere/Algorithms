package techQuestions;

import java.util.HashSet;
import java.util.LinkedList;

public class RemoveDupsLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> list = new LinkedList<>();
		
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(3);
		
		LinkedListNode n = new LinkedListNode();
		
		n.data = list.poll();
//		System.out.println(n.data);
		n.prev = null;
		while (!list.isEmpty()) {
			LinkedListNode next = new LinkedListNode();
			n.setNext(next);
			n.next.data = list.poll();
//			System.out.println(n.next.data);
			n = n.next;
		}
		
		while(n.prev != null) {
			n = n.prev;
		}
				
		deleteDups(n);
		
		while (n != null) {
			System.out.println(n.data);
			n = n.next;
		}
	}
	
	public static void deleteDups(LinkedListNode n) {
		HashSet<Integer> set = new HashSet<>();
		
		System.out.println(n.data);

				
		LinkedListNode previous = null;
		while (n != null) {
			System.out.println("we are at: " + n.data + ", set contains n.data? " + set.contains(n.data));
			if (set.contains(n.data)) {
				previous.next = n.next;
			} else {
				set.add(n.data);
				previous = n;
				System.out.println("previous data is: " + previous.data);
			}
			if (n.next != null) {
				System.out.println("next data is: " + n.next.data);
			}
			n = n.next;
		}
		
//		System.out.println(previous.data);
		
//		while(n.prev != null) {
//			n = n.prev;
//		}
//		while (n != null) {
//			System.out.println(n.data);
//			n = n.next;
//		}
	}
	
	
	// what if there is no buffer allowed?
	
	public static void deleteDupsNoBuffer(LinkedListNode head) {
		// use current and runner technique
		LinkedListNode current = head;
		
		while (current != null) {
			LinkedListNode runner = current;
			while (runner.next != null) {
				if (runner.next.data == current.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
