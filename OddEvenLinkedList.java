package techQuestions;

/*
Purpose: Given a singly linked list, group all odd nodes together followed by the even nodes.
Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes)
time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
Example 2:

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
Note:

The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ...

Author: Erich Meissner
Date: 5/17/20
Time: 8:09 PM
 */


import java.util.List;

public class OddEvenLinkedList {
    public static void main(String[] args){
        ListNode root = new ListNode(1);
        int i = 4;
        int val = 2;
        ListNode temp = root;
        while (i > 0) {
            temp.next = new ListNode(val);
            val++;
            i--;
            temp = temp.next;
        }
        System.out.println(oddEvenList(root).val);
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        //input is 1,2,3,4,5
        // output should be 1,3,5,2,4
        // caveat is you must do the problem in 0(1) space complexity
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            // kind of like a slow pointer and fast pointer approach
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
