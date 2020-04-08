package techQuestions;

import java.util.HashMap;
import java.util.Map;

public class LRUCache{
	
	private doublyLinkedNode head;
	private doublyLinkedNode tail;
	
	class doublyLinkedNode {
		int key;
		int value;
		doublyLinkedNode next;
		doublyLinkedNode prev;
	}
	
	public void add(doublyLinkedNode node) {
		// new node gets added right after the head
		node.prev = head;
		node.next = head.next;
		
		// old is node that was right after the head
		// old's prev pointer to this new node
		head.next.prev = node;
		head.next = node;
	}
	
	public void remove(doublyLinkedNode node) {
		doublyLinkedNode prev = node.prev;
		doublyLinkedNode next = node.next;
		
		//now let's just skip over node
		prev.next = next;
		next.prev = prev;
		// no more pointers to node
	}
	
	public void moveToHead(doublyLinkedNode node) {
		remove(node);
		add(node);
	}
	
	public doublyLinkedNode popTail() {
		doublyLinkedNode res = tail.prev;
		remove(tail.prev);
		return res;
	}
    
    private Map<Integer, doublyLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    
    public LRUCache(int capacity) {
    	this.size = 0;
    	this.capacity = capacity;
    	
    	
    	head = new doublyLinkedNode();
    	tail = new doublyLinkedNode();
    	
    	head.next = tail;
    	tail.prev = head;
    }
    
    public int get(int key) {
    	doublyLinkedNode getNode = cache.get(key);
    	
    	if (getNode == null) {
    		return -1;
    	}
    	
    	// since it was just accessed, must move to head
    	moveToHead(getNode);
    	return getNode.value;
    }
    
    public void put(int key, int value) {
    	doublyLinkedNode putNode = cache.get(key);
    	
    	if (putNode != null) {
    		putNode.value = value;
    		moveToHead(putNode);
    	} else {
    		doublyLinkedNode newPut = new doublyLinkedNode();
    		newPut.key = key;
    		newPut.value = value;
    		
    		cache.put(key, newPut);
    		add(newPut);
    		
    		// increment the size of this hashmap / doublylinkedlist
    		size++;
    		
    		if (size > capacity) {
    			// must now pop tail of doublylinkedlist
    			doublyLinkedNode tail = popTail();
    			cache.remove(tail.key);
    			size--;
    		}
    	}
    }

    public static void main(String[] args) {
    	String s1 = "ABABAB";
    	String s2 = "ABAB";
    	
    	System.out.println(s1.substring(4));
    	
//    	LRUCache test = new LRUCache(2);
//    	test.put(1, 1);
//    	test.put(2, 2);
//    	System.out.println(test.get(1)); // return 1
//    	test.put(3, 3);
//    	System.out.println(test.get(2)); // return -1
//    	test.put(4, 4);
//    	System.out.println(test.get(1)); // return -1
//    	System.out.println(test.get(3)); // return 3
//    	System.out.println(test.get(4)); // return 4
	}
}