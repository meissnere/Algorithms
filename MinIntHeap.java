package techQuestions;

import java.util.Arrays;

public class MinIntHeap {
	private int capacity = 10;
	private int size = 0;
	
	// items integer array initialized to the size set by capacity
	int[] items = new int[capacity];
	
	// methods to get parent right or left index
	private int getParentIndex(int index) { return (index-2)/2; }
	private int getRightIndex(int index) {return (index*2) + 2; }
	private int getLeftIndex(int index) {return (index*2) + 1; }
	
	// methods to check if index even exists!
	private boolean hasParent(int index) {return getParentIndex(index) >= 0; }
	private boolean hasLeft(int index) {return getLeftIndex(index) < size; }
	private boolean hasRight(int index) {return getRightIndex(index) < size; }
	
	// methods to retrieve integer values from an index
	private int parentValue(int index) {return items[getParentIndex(index)];}
	private int leftValue(int index) {return items[getLeftIndex(index)];}
	private int rightValue(int index) {return items[getRightIndex(index)];}
	
	// swap a newly inserted node with its parent if it is greater than its parent
//	private void swap(int index) {
//		// if current node is greater than parent node, then return
//		if (items[index] > items[getParentIndex(index)]) {
//			// must be smaller than parent, so swap
//			int temp = items[getParentIndex(index)];
//			items[getParentIndex(index)] = items[index];
//			items[index] = temp;
//			// send this new parent node recursively to swap method to check its new parent
//			return swap(getParentIndex(index));
//		} else {
//			return;
//		}
//	}



	// true implementation of swap above
	private void swap(int index1, int index2) {
		int temp = items[index2];
		items[index2] = items[index1];
		items[index1] = temp;
	}
	
	private void ensureExtraCapacity() {
		// this is a basic idea of how array lists operate
		if (size == capacity) {
			items = Arrays.copyOf(items, capacity * 2);
			capacity *= 2;
		}
	}
	
	// peek method will return minimum element in array, which is always first
	private int peek() {
		if (size == 0) throw new IllegalStateException("size is 0!");
		return items[0];
	}
	
	// poll method of a heap removes the top element and returns it
	private int poll() {
		if (size == 0) throw new IllegalStateException("size is 0!");
		int top = items[0];
		// replace top item / root node with last inserted element
		items[0] = items[size-1];
		// array / heap size just got one smaller
		size--;
		// we must replace top element with smaller of two childs again and again
		heapifyDown();
		return top;
	}
	
	// now to add a new element to the heap
	private void add(int value) {
		// first step is to make sure there is enough capacity in array
		ensureExtraCapacity();
		items[size] = value;
		// increase size of course!
		size++;
		// heapify up does not take parameters since we know we are always moving up
		// from size - 1 index
		heapifyUp();
		return;
	}
	
	// an item has just been inserted, time to check its parents
	private void heapifyUp() {
		int lastIndex = size - 1;
		while (hasParent(lastIndex) && parentValue(lastIndex) > items[lastIndex]) {
			swap(getParentIndex(lastIndex), lastIndex);
			lastIndex = getParentIndex(lastIndex);
		}
	}
	
	private void heapifyDown() {
		int topIndex = 0;
		while (hasLeft(topIndex)) {
			int smallerChildIndex = getLeftIndex(topIndex);
			if (hasRight(topIndex) && rightValue(topIndex) < leftValue(topIndex)) {
				smallerChildIndex = getRightIndex(topIndex);
			}
			if (items[topIndex] > items[smallerChildIndex]) {
				swap(topIndex, smallerChildIndex);
				topIndex = smallerChildIndex;
			} else {
				break;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
