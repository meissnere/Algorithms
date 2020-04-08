package techQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<LinkedListNode> lists = new ArrayList<>();
		
		LinkedListNode first = new LinkedListNode(1);
		first.next = new LinkedListNode(4);
		first.next.next = new LinkedListNode(5);
		
		lists.add(first);
		
		LinkedListNode second = new LinkedListNode(1);
		second.next = new LinkedListNode(3);
		second.next.next = new LinkedListNode(4);
		
		lists.add(second);
		
		LinkedListNode third = new LinkedListNode(2);
		third.next = new LinkedListNode(6);
		
		lists.add(third);
		
		System.out.println("hahhah" + lists.size());
		
		LinkedListNode finalList = mergeKLists(lists);
		
		while (finalList != null) {
			System.out.print(finalList.data + ", ");
			finalList = finalList.next;
		}
	}
	
	public static LinkedListNode mergeKLists(List<LinkedListNode> lists) {
		
		Comparator<LinkedListNode> cmp;
        cmp = new Comparator<LinkedListNode>() {  
        @Override
        public int compare(LinkedListNode o1, LinkedListNode o2) {
            // TODO Auto-generated method stub
            return o1.data-o2.data;
        }
        };
 
        // comparator interface implemented in priority queue instills above
        // compare function while adding below
        Queue<LinkedListNode> q = new PriorityQueue<LinkedListNode>(cmp);
        for(LinkedListNode l : lists){
            if(l!=null){
            	System.out.println(l.data);
                q.add(l);
            }        
        }
        // priority queue q now has the heads of all linked lists
        
        LinkedListNode head = new LinkedListNode(0);
        LinkedListNode point = head;
        // while the queue is not empty
        while(!q.isEmpty()){ 
            point.next = q.poll();
            System.out.println("data at this point: " + point.next.data);
            point = point.next; 
            LinkedListNode next = point.next;
            if(next!=null){
                System.out.println(next.data);
                q.add(next);
            }
        }
        return head.next;
			
	}

}
