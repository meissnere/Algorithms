package techQuestions;

/*
Purpose: Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");
trie.search("app");     // returns true

Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.

Author: Erich Meissner
Date: 5/14/20
Time: 6:42 PM
 */
class Trie {

    // private to this class, develop/initialize a root
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
        // root value is an empty character
        root.val = ' ';
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode insertRootTemp = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // check if the child character doesn't exist yet
            if (insertRootTemp.children[c - 'a'] == null) {
                // add it if it doesn't exist
                insertRootTemp.children[c - 'a'] = new TrieNode('c');
            }
            // always move to next trie node
            insertRootTemp = insertRootTemp.children[c - 'a'];
        }
        // we must be at the end of this word. set isWord to true
        insertRootTemp.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode searchRootTemp = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (searchRootTemp.children[c - 'a'] == null) {
                return false;
            }
            // move to child
            searchRootTemp = searchRootTemp.children[c - 'a'];
        }
        // if we exited this loop, then let's check the boolean
        // at this point
        return searchRootTemp.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode startsRootTemp = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (startsRootTemp.children[c - 'a'] == null) {
                return false;
            }
            // traverse down trie nodes
            startsRootTemp = startsRootTemp.children[c - 'a'];
        }
        // if we got here, we do not need to perform isWord check
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

// we need to implement a node class for our trie structure
class TrieNode {
    // remember that a boolean is required to know if a string key is a word
    public boolean isWord;
    public TrieNode() {}
    // the accessible value of the TrieNode node is a character
    public char val;
    // a TrieNode node can have up to 26 children; store this in a TrieNode array
    public TrieNode[] children = new TrieNode[26];
    TrieNode(char c) {
        TrieNode node = new TrieNode();
        node.val = c;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }
}
