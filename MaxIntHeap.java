package techQuestions;

import java.util.Arrays;

public class MaxIntHeap<T> {
    private int capacity = 10;
    private int size = 0;

    // items integer array initialized to the size set by capacity = 10
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

    public void swap(int i, int j) {
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    public int peek() {
        if (size == 0) throw new IllegalStateException("Heap is Empty! Can't Peek");
        return items[0];
    }

    public void heapifyDown() {
        int topIndex = 0;
        // if there is no left child, no need to check for left child
        while (hasLeft(topIndex)) {
            int largerChildIndex = getLeftIndex(topIndex);
            if (hasLeft(topIndex) && leftValue(topIndex) < rightValue(topIndex)) {
                largerChildIndex = getRightIndex(topIndex);
            }
            if (items[topIndex] < items[largerChildIndex]) {
                swap(topIndex, largerChildIndex);
                topIndex = largerChildIndex;
            } else {
                break;
            }
        }
    }

    public int poll() {
        if (size == 0) throw new IllegalStateException("Heap is Empty! Can't Poll");
        int top = items[0];
        // replace top element with last inserted element
        items[0] = items[size - 1];
        size--;
        // recurse down heap from root node to ensure maxHeap structure
        heapifyDown();
        return top;
    }

    public void ensureExtraCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity = capacity * 2;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public void heapifyUp() {
        int bottomIndex = size-1;
        while (hasParent(bottomIndex) && parentValue(bottomIndex) < items[bottomIndex]) {
            swap(bottomIndex, getParentIndex(bottomIndex));
            bottomIndex = getParentIndex(bottomIndex);
        }
    }

    public void add(int value) {
        ensureExtraCapacity();
        items[size] = value;
        size++;
        heapifyUp();
        return;
    }
}
