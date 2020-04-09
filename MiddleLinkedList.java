package techQuestions;

public class MiddleLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);
		
		System.out.println(middleNode(node).val);
	}
	
	public static ListNode middleNode(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}

}
