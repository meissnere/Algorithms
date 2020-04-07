package techquestions;

public class MergeTwoSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListNode L1 = new LinkedListNode();
		L1.data = 1;
		L1.next = new LinkedListNode();
		L1.next.data = 2;
		L1.next.next = new LinkedListNode();
		L1.next.next.data = 4;
		System.out.println(L1.data);
		LinkedListNode temp = L1;
		while (temp.next != null) {
			System.out.println(temp.next.data);
			temp = temp.next;
		}
		
		
		LinkedListNode L2 = new LinkedListNode();
		L2.data = 1;
		L2.next = new LinkedListNode();
		L2.next.data = 3;
		L2.next.next = new LinkedListNode();
		L2.next.next.data = 4;
		System.out.println();
		System.out.println(L2.data);
		LinkedListNode temp2 = L2;
		while (temp2.next != null) {
			System.out.println(temp2.next.data);
			temp2 = temp2.next;
		}
		
//		LinkedListNode out = mergeTwoLists(L1, L2);
//		System.out.println();
//		System.out.println(out.data);
//		LinkedListNode temp3 = out;
//		while (temp3.next != null) {
//			System.out.println(temp3.next.data);
//			temp3 = temp3.next;
//		}
		
		LinkedListNode out = mergeTwoListsRecursive(L1, L2);
		System.out.println();
		System.out.println(out.data);
		LinkedListNode temp3 = out;
		while (temp3.next != null) {
			System.out.println(temp3.next.data);
			temp3 = temp3.next;
		}

	}
	
	public static LinkedListNode mergeTwoLists(LinkedListNode l1, LinkedListNode l2) {
		LinkedListNode prehead = new LinkedListNode(-1);
		// null right here!
		System.out.println(prehead.next);
		LinkedListNode prev = prehead;
		while (l1 != null && l2 != null) {
			if (l1.data <= l2.data) {
				prev.next = l1;
				l1 = l1.next;
			} else {
				prev.next = l2;
				l2 = l2.next;
			}
			prev = prev.next;
		}

		// exactly one of l1 and l2 can be non-null at this point, so connect
		// the non-null list to the end of the merged list.
		prev.next = l1 == null ? l2 : l1;

		return prehead.next;
	}
	
	public static LinkedListNode mergeTwoListsRecursive(LinkedListNode l1, LinkedListNode l2) {
		// all within else if blocks to catch ALL cases with final else since all return values are
		// within these conditional blocks
		if (l1 == null) {
			System.out.println("l2 is: " + l2.data);
			return l2;
		}
		else if (l2 == null) {
			System.out.println("l1 is: " + l1.data);
			return l1;
		}
		else if (l1.data <= l2.data) {
			l1.next = mergeTwoListsRecursive(l1.next, l2);
			System.out.println("l1 is: " + l1.data);
			return l1;
		}
		// l1 data must be greater than or equal to l2 data
		else {
			l2.next = mergeTwoListsRecursive(l1, l2.next);
			System.out.println("l2 is: " + l2.data);
			return l2;
		}
	}
 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
