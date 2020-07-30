package techQuestions;

/*
Purpose: Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest.
If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.

Author: Erich Meissner
Date: 6/23/20
Time: 4:03 PM
 */


import java.util.*;

public class TopKMostFrequent {

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(topKFrequent(words, 2).toString());
    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<String, Integer>(words.length);
        for (String word: words) {
            count.put(word, count.getOrDefault(count, 0) + 1);
        }
        return new ArrayList<>();
    }
}
