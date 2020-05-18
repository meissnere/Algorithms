package techQuestions;

/*
Purpose: Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be
larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

Author: Erich Meissner
Date: 5/17/20
Time: 8:50 PM
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsString {
    public static void main(String[] args) {
        String s = "abab", p = "ab";
        System.out.println(findAnagrams(s,p).toString());
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        if (sLen < pLen) {
            return new ArrayList<>();
        }
        // key is character and value is count
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            charCount.put(p.charAt(i), charCount.getOrDefault(p.charAt(i), 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        HashMap<Character, Integer> freshCount = new HashMap<>();
        outerloop:
        for (int i = 0; i < sLen; i++) {
//            if (!charCount.containsKey(s.charAt(i))) {
//                continue;
//            }
            freshCount.put(s.charAt(i), freshCount.getOrDefault(s.charAt(i), 0) + 1);
//            for (int j = i + 1; j < i + pLen; j++) {
////                System.out.println("j value is: " + j);
//                if (!charCount.containsKey(s.charAt(j))) {
//                    continue outerloop;
//                }
//                freshCount.put(s.charAt(j), freshCount.getOrDefault(s.charAt(j), 0) + 1);
//                if (freshCount.get(s.charAt(j)) > charCount.get(s.charAt(j))) {
//                    continue outerloop;
//                }
//            }
//            System.out.println(freshCount.entrySet());
//            System.out.println("charC");
//            System.out.println(charCount.entrySet());
            if (i >= pLen) {
                char c = s.charAt(i - pLen);
                if (freshCount.get(c) == 1) {
                    freshCount.remove(c);
                } else if (freshCount.get(c) > 1) {
                    freshCount.put(c, freshCount.get(c) - 1);
                }
            }
            if (freshCount.equals(charCount)) {
                ans.add(i - pLen + 1);
            }
        }
        return ans;
    }
}
