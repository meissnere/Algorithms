package techquestions;

import java.util.ArrayList;

public class addTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListNode l1 = new LinkedListNode();
		l1.data = 2;
		l1.next = new LinkedListNode();
		l1.next.data = 4;
		l1.next.next = new LinkedListNode();
		l1.next.next.data = 3;
		
		
		LinkedListNode l2 = new LinkedListNode();
		l2.data = 5;
		l2.next = new LinkedListNode();
		l2.next.data = 6;
		l2.next.next = new LinkedListNode();
		l2.next.next.data = 4;
		
		LinkedListNode outputAdd = addTwoNumbers(l1, l2);
		
		while (outputAdd != null) {
			System.out.println(outputAdd.data);
			outputAdd = outputAdd.next;
		}
	}

	
	public static LinkedListNode addTwoNumbers(LinkedListNode l1, LinkedListNode l2) {

		LinkedListNode dummyHead = new LinkedListNode(0);
		LinkedListNode curr = dummyHead;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int x = (l1 != null) ? l1.data : 0;
			int y = (l2 != null) ? l2.data : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			curr.next = new LinkedListNode(sum % 10);
			curr = curr.next;
			if (l1 != null) l1 = l1.next;
			if (l2 != null) l2 = l2.next;
		}
		
		if (carry != 0) {
			curr.next = new LinkedListNode();
			curr.next.data = carry;
		}
		
		return dummyHead.next;
		
		
		
		//		int num1 = 0;
//		int num2 = 0;
//		int i = 0;
//		int j = 0;
//		
//		while (l1 != null) {
////			System.out.println(l1.data);
//			num1 = (int) (num1 + (l1.data * Math.pow(10, i)));
////			System.out.println(num1);
//			i++;
//			l1 = l1.next;
//		}
//		
//		while (l2 != null) {
////			System.out.println(l2.data);
//			num2 = (int) (num2 + (l2.data * Math.pow(10, j)));
//			j++;
//			l2 = l2.next;
//		}
//		
////		System.out.println(num1 + " " + num2);
//		
//		int num3 = num1 + num2;
//		
//		String output = num3 + "";
//		
////		System.out.println(output);
//		
//		LinkedListNode finalList = new LinkedListNode();
//		int k = output.length() - 1;
//		int z = Integer.parseInt(String.valueOf(output.charAt(k)));
//		finalList.data = z;
//
//
//		LinkedListNode temp = finalList;
//		for (int y = output.length() - 2; y >= 0; y--) {
//			int a = Integer.parseInt(String.valueOf(output.charAt(y)));
////			System.out.println(a);
//			finalList.next = new LinkedListNode();
//			finalList.next.data = a;
//			finalList = finalList.next;
//		}
////		System.out.println("here!" + temp.next.data);
//		return temp;
		
	}
}
