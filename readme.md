# Algorithms
Algorithm Studies from Master's in Computer Science

## Trie Data Structure
The Trie or prefix tree is a tree data structure we use for retrieval
of a key in a dataset of strings. There are various applications of
this very efficient data structure such as:

![Google Search Autocomplete](assets/autocomplete.png)

![Spell Checker](assets/spellchecker.png)

![Longest Prefix Matching](assets/longestprefix.png)

This example is especially interesting due to its relevance in
computer networking. The longest prefix matching algorithm is used
by routers in Internet Protocol (IP) networking to select an entry
from a forwarding table. Because each entry in a forwarding table
may specify a sub-network, one destination address may match more
than one forwarding table entry. The most specific of the matching
table entries -- the one with the longest subnet mask -- is called
the longest prefix match. It is called this because it is also the
entry where the largest number of leading address bits of the
destination address match those in the table entry.

An example IPv4 forwarding table:

```
192.168.20.16/28
192.168.0.0/16
```

Suppose the address 192.168.20.19 needs to be looked up. Both of
these entries in the forwarding table "match", meaning both
entries contain the looked up address. The longest prefix of these
two candidate routes is `192.168.20.16/28` because its subnet mask
(/28) is longer than the other entry's mask (/16), making the
router more specific. 

![T9 Text](assets/t9text.png)

![Word Games](assets/wordgame.png)

Other data structures, like balanced trees and hash tables, also
give us the ability to search for a word in a dataset of strings.
So why a trie? Even though a hash table has O(1) time complexity
for looking for a key, it is not efficient in the following
operations:
- Finding all keys with a common prefix
- Enumerating a dataset of strings in lexicographical order

Furthermore, as a hash table increases in size, there are lots of
hash collisions, and the search time complexity could deteriorate
to O(N), where *N* is the number of keys inserted. A trie could use
less space compared to a Hash Table when storing many keys with
the same prefix. In this case, employing a trie has only O(M) time
complexity, where *M* is the key length. Also, searching for a key
in a balanced tree costs O(M log M) time.

### Trie Node Structure
A trie is a rooted tree, and its nodes have the following fields
- Maximum of *R* links to its children where each link corresponds
to one of *R* character values from the dataset of an alphabet.
Assume *R* == 26, the number of lowercase latin letters.
- Boolean field which specifies whether the node corresponds to
the end of the key or is just a prefix.

![Trie Key](assets/trieKey.png)

```java
class TrieNode {

    // R links to node children
    private TrieNode[] links;

    private final int R = 26;

    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch -'a'] != null;
    }
    public TrieNode get(char ch) {
        return links[ch -'a'];
    }
    public void put(char ch, TrieNode node) {
        links[ch -'a'] = node;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}
```

![T9 Text](assets/t9text.png)
