package techQuestions;

/*
Purpose: Given a string s and an integer k.

Return the maximum number of vowel letters in any substring of s
with length k.

Vowel letters in English are (a, e, i, o, u).

Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
Example 2:

Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.
Example 3:

Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.
Example 4:

Input: s = "rhythms", k = 4
Output: 0
Explanation: We can see that s doesn't have any vowel letters.
Example 5:

Input: s = "tryhard", k = 4
Output: 1

Author: Erich Meissner
Date: 5/23/20
Time: 11:18 PM
 */

public class MaxNumVowelsSubstring {
    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        System.out.println(maxVowels(s, k));
    }

    public static int maxVowels(String s, int k) {
        int maxVowels = 0;
        int initialCount = 0;
        int i = 0;
        while (i < k) {
            if (isVowel(s.charAt(i))) {
                initialCount++;
            }
            i++;
        }
        maxVowels = Math.max(initialCount, maxVowels);
        for (i = 1; i < s.length() - k + 1; i++) {
            if (isVowel(s.charAt(i-1))) {
               initialCount--;
            }
            if (isVowel(s.charAt(i+(k-1)))) {
                initialCount++;
            }
            maxVowels = Math.max(initialCount, maxVowels);
        }
        return maxVowels;
    }

    public static boolean isVowel(char c) {
        if (c == 'a'|| c == 'e'|| c == 'i'|| c == 'o'|| c == 'u') {
            return true;
        }
        return false;
    }
}
