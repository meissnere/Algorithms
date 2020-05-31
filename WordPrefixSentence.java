package techQuestions;

/*
Purpose: 5416. Check If a Word Occurs As a Prefix of Any Word in a
Sentence
Given a sentence that consists of some words separated by a single space,
and a searchWord.

You have to check if searchWord is a prefix of any word in sentence.

Return the index of the word in sentence where searchWord is a prefix
of this word (1-indexed).

If searchWord is a prefix of more than one word, return the index of
the first word (minimum index). If there is no such word return -1.

A prefix of a string S is any leading contiguous substring of S.

Example 1:

Input: sentence = "i love eating burger", searchWord = "burg"
Output: 4
Explanation: "burg" is prefix of "burger" which is the 4th word in the sentence.
Example 2:

Input: sentence = "this problem is an easy problem", searchWord = "pro"
Output: 2
Explanation: "pro" is prefix of "problem" which is the 2nd and the 6th word in the sentence, but we return 2 as it's the minimal index.
Example 3:

Input: sentence = "i am tired", searchWord = "you"
Output: -1
Explanation: "you" is not a prefix of any word in the sentence.
Example 4:

Input: sentence = "i use triple pillow", searchWord = "pill"
Output: 4
Example 5:

Input: sentence = "hello from the other side", searchWord = "they"
Output: -1

Author: Erich Meissner
Date: 5/23/20
Time: 10:50 PM
 */


import java.util.Arrays;
import java.util.HashMap;

public class WordPrefixSentence {
    public static void main(String[] args) {
        String searchWord = "they";
        String sentence = "hello from the other side";
        System.out.println(isPrefixOfWord(sentence, searchWord));
    }

    public static int isPrefixOfWord(String sentence, String searchWord) {
        HashMap<Integer, Character> prefixMap = new HashMap<>();
        for (int i = 0; i < searchWord.length(); i++) {
            prefixMap.put(i, searchWord.charAt(i));
        }
        String[] split = sentence.split(" ");
        int wordIndex = 1;
        for (String word: split) {
            for (int i = 0; i < prefixMap.size(); i++) {
                if (word.length() < prefixMap.size()) {
                    break;
                }
                if (word.charAt(i) != prefixMap.get(i)) {
                    break;
                }
                if (i == prefixMap.size() - 1) {
                    return wordIndex;
                }
            }
            wordIndex++;
        }
        return -1;
    }
}
