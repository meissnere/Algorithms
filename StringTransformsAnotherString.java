package techQuestions;

/*
Purpose: Given two strings str1 and str2 of the same length, determine whether you can transform str1
into str2 by doing zero or more conversions.

In one conversion you can convert all occurrences of one character in str1 to any other lowercase
English character.

Return true if and only if you can transform str1 into str2.



Example 1:

Input: str1 = "aabcc", str2 = "ccdee"
Output: true
Explanation: Convert 'c' to 'e' then 'b' to 'd' then 'a' to 'c'. Note that the order of conversions matter.
Example 2:

Input: str1 = "leetcode", str2 = "codeleet"
Output: false
Explanation: There is no way to transform str1 to str2.

Author: Erich Meissner
Date: 5/18/20
Time: 11:55 PM
 */


import java.util.HashMap;

public class StringTransformsAnotherString {
    public static void main(String[] args) {
        String str1 = "leetcode", str2 = "codeleet";
        System.out.println(canConvert(str1, str2));
    }

    // idea -- scan both string simultaneously
    // record the transformation mapping into a map/array
    // the same character should transform to the same char
    // otherwise, we can return false

    // modeling this problem as a graph would be the most intuitive way.
    // the edges in the graph represent the mapping relationships

    /*
    The outdegree of a node in this graph can only be smaller or equal
    to 1; otherwise, we should just return false immediately! this means the
    graph is just linked lists and using a hash map will be sufficient to keep
    track of the edges

    Use a hashmap<character, character> to keep track of the edges
     */
    public static boolean canConvert(String str1, String str2) {
        if (str1.equals(str2)) {
            return true;
        }

        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            // what are the characters in each string at this point?
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            // if we have already created a mapping for c1 and it's
            // map does not equal c2; we know this mapping cannot occur
            if(map.containsKey(c1) && map.get(c1) != c2) {
                return false;
            }
            map.put(c1, c2);
        }
        // must make sure that the value set is less than 26
        if (map.values().size() < 26) {
            return true;
        } else {
            return false;
        }
    }
}
