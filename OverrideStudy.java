package techQuestions;

import java.util.*;

public class OverrideStudy {
    public static void main(String[] args) {
        String[] logLines = {"mi2 jog mid pet", "wz3 34 54 398"};
        System.out.println(Arrays.toString(reorderLines(logLines.length, logLines)));
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static String[] reorderLines(int logFileSize, String[] logLines)
    {
        // making sure I understand question:
        // each line is a space delimited list of strings, and every
        // line begins with an alphanumeric identifier
        // each line has either:
        // 1) a list of words using English letters
        // 2) list of only integers
        // reorder the log file such that:
        // -- all lines with words are at the top of the log file
        // -- lines with words are ordered alphabetically
        // -- in case of tie, use identifier

        // I believe using the sort method on this list will make my life
        // easier, but I'm worried you might want me to write my
        // own Override for some custom sort? I know how to work with
        // arrays better, so I will convert this list to a string array

        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String firstString, String secondString) {
                // we know we can skip the alphanumeric identifier
                // for a space after this identifier
                String[] delimited1 = firstString.split(" ", 2);
                String[] delimited2 = secondString.split(" ", 2);

                // check if either of the strings are digits
                boolean isNum1 = Character.isDigit(delimited1[1].charAt(0));
                boolean isNum2 = Character.isDigit(delimited2[1].charAt(0));

                // check if string one is a digit and string two is not
                if (isNum1 && !isNum2) {
                    return 1;
                }
                // they are both digits
                if (isNum1 && isNum2) {
                    // we just leave in original order
                    return 0;
                }
                // they are both all letters
                if (!isNum1 && !isNum2) {
                    if (delimited1[1].compareTo(delimited2[1]) == 0) {
                        return delimited1[0].compareTo(delimited2[0]);
                    } else {
                        return delimited1[1].compareTo(delimited2[1]);
                    }
                } else {
                    // last case that isn't accounted for
                    // string 1 is not a digit but string 2 is
                    return -1;
                }
            }
        };


        Arrays.sort(logLines, myComp);
        return logLines;
    }
}
