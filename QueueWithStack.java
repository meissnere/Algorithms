package techquestions;

import java.util.Stack;

public class QueueWithStack {
	
	private final Stack<Integer> queue = new Stack();
	private final Stack<Integer> stack = new Stack();

	/** Initialize your data structure here. */

	private int front;
	/** Push element x to the back of queue. */
	public void push(int x) {
		// if the queue is empty, there will be no "back" to push an element to
		if (queue.empty()) {
			front = x;
		}
		// empty the entire queue and add its elements to stack
		while (!queue.isEmpty()) {
			// stack now has elements in LIFO order
			stack.push(queue.pop());
		}
		// push the element x into the empty queue
		queue.push(x);
		// while the stack is not empty, remove all its elements into queue
		while (!stack.isEmpty()) {
			// queue now has elements in FIFO order
			queue.push(stack.pop());
		}
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		int top = queue.pop();
		if (!queue.empty()) {
			front = queue.peek();
		}
		return top;
	}

	/** Get the front element. */
	public int peek() {
		return front;
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return queue.isEmpty();
	}
}

	/**
	 * Your MyQueue object will be instantiated and called as such:
	 * MyQueue obj = new MyQueue();
	 * obj.push(x);
	 * int param_2 = obj.pop();
	 * int param_3 = obj.peek();
	 * boolean param_4 = obj.empty();
	 */
