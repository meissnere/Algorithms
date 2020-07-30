package techQuestions;

/*
Purpose: You have an array of logs.  Each log is a space delimited string of words.

For each log, the first word in each log is an alphanumeric identifier.  Then, either:

Each word after the identifier will consist only of lowercase letters, or;
Each word after the identifier will consist only of digits.
We will call these two varieties of logs letter-logs and digit-logs. It is
guaranteed that each log has at least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log.
The letter-logs are ordered lexicographically ignoring identifier, with the
identifier used in case of ties. The digit-logs should be put in their original order.

Return the final order of the logs.

Example 1:

Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]

Author: Erich Meissner
Date: 6/23/20
Time: 10:45 AM
 */


import java.util.Arrays;

public class ReorderDataLogFiles {
    public static void main(String[] args) {
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};

        System.out.println(Arrays.toString(reorderLogFiles(logs)));
    }

    public static String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (first_log, second_log) -> {
            // split first two string arrays to compare
            String[] split1 = first_log.split(" ", 2);
            String[] split2 = second_log.split(" ", 2);
            boolean dig1 = Character.isDigit(split1[1].charAt(0));
            boolean dig2 = Character.isDigit(split2[1].charAt(0));
            if (!dig1 && !dig2) {
                int compare = split1[1].compareTo(split2[1]);
                // if the two strings are not equal lexicographically
                if (compare != 0) {
                    return compare;
                }
                // if they are equal, then compare their identifiers
                return split1[0].compareTo(split2[0]);
            }
            if (dig1) {
                if (dig2) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return -1;
            }
        });
        return logs;
    }

}
