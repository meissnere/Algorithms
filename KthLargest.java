package techQuestions;

import java.util.PriorityQueue;

public class KthLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 3;
		int[] arr = {4,5,8,2};
		KthLargest obj = new KthLargest(k, arr);
		System.out.println("all elements of object constructed.  now ADD!");
		System.out.println(obj.add(3));   // returns 4
		System.out.println(obj.add(5));   // returns 5
		System.out.println(obj.add(10));  // returns 5
		System.out.println(obj.add(9));   // returns 8
		System.out.println(obj.add(4));   // returns 8
	}
	
	final PriorityQueue<Integer> q;
    final int k;

    public KthLargest(int k, int[] a) {
        this.k = k;
        System.out.println("k here: " + k);
        q = new PriorityQueue<>(k);
        for (int n : a) {
            add(n);
        }
        
    }

    public int add(int n) {
    	System.out.println("size: " + q.size() + ", and k is: " + k);
        if (q.size() < k) {
        	System.out.println("to be added: " + n);
            q.offer(n);
        } else if (q.peek() < n) {
            q.poll();
        	System.out.println("to be added here: " + n);
            q.offer(n);
        }
        for (Integer item: q) {
        	System.out.print(item);
        }
        System.out.println();
        return q.peek();
    }

}
