package techQuestions;

public class MaxScoreSplitString {
//    Given a string s of zeros and ones, return the maximum
//    score after splitting the string into two non-empty substrings
//    (i.e. left substring and right substring).
//
//     The score after splitting a string is the number of zeros in the
//     left substring plus the number of ones in the right substring.
    public static void main (String[] args) {
        String s = "011101";
        System.out.println(maxScore(s));
    }

    public static int maxScore(String s) {
        int maxScore = 0;
        if (s.length() == 0) {
            return 0;
        }
//        System.out.println(s.substring(3));
        for (int i = 0; i < s.length() - 1; i++) {
            String left = s.substring(0, i+1);
            String right = s.substring(i+1, s.length());
//            System.out.println("left is: " + left + ", right is: " + right);
            maxScore = Math.max(calc(left, true) + calc(right, false), maxScore);
        }
        return maxScore;
    }

    public static int calc(String sub, boolean isLeft) {
        int count = 0;
        if (isLeft) {
            for (char c: sub.toCharArray()) {
                if (c == '0') {
                    count++;
                }
            }
        } else {
            for (char c: sub.toCharArray()) {
                if (c == '1') {
                    count++;
                }
            }
        }
        return count;
    }
}
