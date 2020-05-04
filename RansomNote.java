package techQuestions;

/*
Purpose: Given an arbitrary ransom note string and another
string containing letters from all the magazines, write a
function that will return true if the ransom note can be
constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.
Author: "Erich Meissner"
Date: 5/4/20
Time: 12:35 AM
 */


import java.util.HashMap;

public class RansomNote {
    public static void main(String[] args) {
        String ransom = "aa";
        String magazines = "ab";
        System.out.println(canConstruct(ransom, magazines));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c: magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c: ransomNote.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                return false;
            }
            map.put(c, map.get(c)-1);
        }
        return true;
    }
}
