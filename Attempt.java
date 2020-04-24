package techQuestions;

import java.util.*;

public class Attempt {

    private DoublyLinkedListNode head;
    private DoublyLinkedListNode tail;

    static class DoublyLinkedListNode {
        int key;
        int value;
        DoublyLinkedListNode next;
        DoublyLinkedListNode prev;
    }

    public void add(DoublyLinkedListNode node) {
        // new node gets added to head!
        node.next = head.next;
        node.prev = head;

        // what to do with old node? we don't
        // need to updated it's next pointer
        head.next.prev = node;
        head.next = node;
    }

    public void popTail() {
        // capacity has been met, pop LRU
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
    }

    public void moveToHead(DoublyLinkedListNode node) {
        // must remove this node first
        DoublyLinkedListNode prev = node.prev;
        DoublyLinkedListNode next = node.next;
        prev.next = next;
        next.prev = prev;
        //let's re-add this node
        add(node);
    }

    static HashMap<Integer, DoublyLinkedListNode> map = new HashMap<>();

    public static void main(String[] args) {
    	Attempt cache = new Attempt(2);
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));       // returns 1
		cache.put(3, 3);    // evicts key 2
		cache.get(2);       // returns -1 (not found)
		cache.put(4, 4);    // evicts key 1
		cache.get(1);       // returns -1 (not found)
		cache.get(3);       // returns 3
		cache.get(4);       // returns 4
        System.out.println("test");
    }


    int capacity;
    int size;

    public Attempt(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {
        DoublyLinkedListNode node = map.get(key);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (size == capacity) {
            // we must remove least recently used!
            popTail();
        }
        // now we can add this new value
        DoublyLinkedListNode node = new DoublyLinkedListNode();
        node.value = value;
        node.key = key;
        add(node);
        map.put(key, node);
    }
}
