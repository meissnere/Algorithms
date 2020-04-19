package techQuestions;

//Given alphanumeric string s. (Alphanumeric string is a string consisting of lowercase English letters and digits).
//        You have to find a permutation of the string where no letter
//        is followed by another letter and no digit is
//        followed by another digit. That is, no two adjacent
//        characters have the same type. Return the reformatted string or return an
//        empty string if it is impossible to reformat the string.

import java.util.Arrays;

public class ReformatString {
    public static void main(String[] args) {
        String s = "covid2019";
        System.out.println(reformat(s));
    }
    public static String reformat(String s) {
        if (s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        int charCount = 0, intCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((int) s.charAt(i) < 58) {
                intCount++;
            } else {
                charCount++;
            }
        }
        if (intCount - charCount > 1 || charCount - intCount > 1) {
            return "";
        } else {
            char[] cArray = s.toCharArray();
            Arrays.sort(cArray);
            System.out.println(Arrays.toString(cArray));
            StringBuilder sb = new StringBuilder();
            int j = s.length()-1;
            for (int i = 0; i < s.length() / 2; i++) {
                sb.append(cArray[i]);
                sb.append(cArray[j]);
                j--;
            }
            if (cArray.length % 2 != 0) {
                int middleIndex = cArray.length / 2;
                boolean isInt = false;
                if ((int) cArray[middleIndex] < 58) {
                    isInt = true;
                }
                if ((int) sb.charAt(sb.length() - 1) < 58) {
                    if (isInt) {
                        sb.insert(0, cArray[middleIndex]);
                    } else {
                        sb.append(cArray[middleIndex]);
                    }
                } else {
                    if (isInt) {
                        sb.append(cArray[middleIndex]);
                    } else {
                        sb.insert(0, cArray[middleIndex]);
                    }
                }
            }
            return sb.toString();
        }
    }

}
