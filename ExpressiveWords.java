package techQuestions;

/*
Purpose: Sometimes people repeat letters to represent extra feeling, such as "hello" -> "heeellooo",
"hi" -> "hiiii".  In these strings like "heeellooo", we have groups of adjacent letters that are all
the same:  "h", "eee", "ll", "ooo".

For some given string S, a query word is stretchy if it can be made to be equal to S by any number
of applications of the following extension operation: choose a group consisting of characters c,
and add some number of characters c to the group so that the size of the group is 3 or more.

For example, starting with "hello", we could do an extension on the group "o" to get "hellooo",
but we cannot get "helloo" since the group "oo" has size less than 3.  Also, we could do another
extension like "ll" -> "lllll" to get "helllllooo".  If S = "helllllooo", then the query word "hello"
would be stretchy because of these two extension operations: query = "hello" -> "hellooo" -> "helllllooo" = S.

Given a list of query words, return the number of words that are stretchy.

Example:
Input:
S = "heeellooo"
words = ["hello", "hi", "helo"]
Output: 1
Explanation:
We can extend "e" and "o" in the word "hello" to get "heeellooo".
We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.

Notes:

0 <= len(S) <= 100.
0 <= len(words) <= 100.
0 <= len(words[i]) <= 100.
S and all words in words consist only of lowercase letters

Author: Erich Meissner
Date: 5/18/20
Time: 12:39 AM
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExpressiveWords {
    public static void main(String[] args) {
        String s = "heeellooo";
        String[] words = {"hello", "hi", "helo"};
        System.out.println(expressiveWords(s, words));
    }

    public static int expressiveWords(String S, String[] words) {
        CounterExpress R = new CounterExpress();
        int ans = 0;
        search: for (String word: words) {
            CounterExpress R2 = new CounterExpress();
            if (!R.RLE(S).equals(R2.RLE(word))) continue;
            for (int i = 0; i < R.sCount.size(); ++i) {
                int c1 = R.sCount.get(i);
                int c2 = R2.sCount.get(i);
                if (c1 < 3 && c1 != c2 || c1 < c2)
                    continue search;
            }
            ans++;
        }
        return ans;
    }
}

class CounterExpress {
    List<Integer> sCount;
    public String RLE(String S) {
        sCount = new ArrayList<>();
        StringBuilder key = new StringBuilder();
        char[] SArray = S.toCharArray();
        int prev = -1;
        for (int i = 0; i < S.length(); i++) {
            if (i == S.length() - 1 || SArray[i] != SArray[i+1]) {
                key.append(SArray[i]);
                sCount.add(i-prev);
                prev = i;
            }
        }
        return key.toString();
    }
}
