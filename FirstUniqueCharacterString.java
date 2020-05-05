package techQuestions;

/*
Purpose: Given a string, find the first non-repeating character in it
and return it's index. If it doesn't exist, return -1.

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.

Author: Erich Meissner
Date: 5/5/2020
Time: 11:52 AM
*/


import java.util.HashMap;

public class FirstUniqueCharacterString {
    public static void main(String[] args) {
        System.out.println(firstUnique("z"));
    }

    public static int firstUnique(String s) {
        if (s.length() == 0) {
            return -1;
        } else if (s.length() == 1) {
            return 0;
        }
        // create hash map with character as key and
        // index as value; if the character already exists,
        // remove it from the hash map
        HashMap<Character, Integer> map = new HashMap<>();
        int i =0;
        for (char c: s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, Integer.MAX_VALUE);
                i++;
                continue;
            }
            map.put(c, i);
            i++;
        }
        int minIndex = Integer.MAX_VALUE;
        for (int index: map.values()) {
            minIndex = Math.min(minIndex, index);
        }

        // finally, return the smallest index available from
        // value set
        if (minIndex == Integer.MAX_VALUE) {
            return -1;
        }
        return minIndex;
    }
}
