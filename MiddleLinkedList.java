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
		int count = 1;
		ListNode iterator = head;
		
		while (iterator.next != null) {
			iterator = iterator.next;
			count++;
		}
		
		int half = count / 2;
		// this logic is incorrect!
//		if (count % 2 == 0) {
//			half = count / 2 + 1;
//		}
		
		for (int i = 1; i <= half; i++) {
			head = head.next;
		}
		
		return head;
	}

}
