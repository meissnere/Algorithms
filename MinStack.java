package techQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MinStack {
	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin()); // should return -3
		minStack.pop();
		System.out.println(minStack.top()); // should return 0
		System.out.println(minStack.getMin()); // should return -2  
    }
	/** initialize your data structure here. */
	List<Integer> list = new ArrayList<Integer>();
	LinkedList<Integer> linked = new LinkedList<>();
	
    public MinStack() {
    }
    
    public void push(int x) {
        linked.addFirst(x);
        list.add(x);
        Collections.sort(list);
    }
    
    public void pop() {
        int removedInt = linked.get(0);
        linked.remove();
        int listIndex = list.indexOf(removedInt);
        list.remove(listIndex);
    }
    
    public int top() {
        return linked.getFirst();
    }
    
    public int getMin() {
       return list.get(0); 
    }
}
