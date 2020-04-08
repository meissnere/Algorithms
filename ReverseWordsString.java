package techQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWordsString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "    test this   input with    multiple white     space     ";

		
		System.out.println(reverseWords(s));
	}
	
	public static StringBuilder trimSpaces(String s) {
		int left = 0, right = s.length() - 1;
	    // remove leading spaces
	    while (left <= right && s.charAt(left) == ' ') ++left;

	    // remove trailing spaces
	    while (left <= right && s.charAt(right) == ' ') --right;

	    // reduce multiple spaces to single one
	    StringBuilder sb = new StringBuilder();
	    while (left <= right) {
	      char c = s.charAt(left);
	      
//	      System.out.println("left index is: " + left + ", and c is: " + c);

	      if (c != ' ') sb.append(c);
	      else if (sb.charAt(sb.length() - 1) != ' ') sb.append(c);

//	      System.out.println("sb is:" + sb + ", and length is: " + sb.length());
//	      System.out.println();
	      ++left;
	    }
	    return sb;
	}
	
	public static void reverse(StringBuilder sb, int left, int right) {

		while (left < right) {
			char temp = sb.charAt(right);
			sb.setCharAt(right, sb.charAt(left));
			sb.setCharAt(left, temp);
			right--;
			left++;
		}
	}
	
	public static String reverseEachWord(StringBuilder sb) {
		ArrayList<Integer> whiteSpaces = new ArrayList<Integer>();
		
		int n = sb.length();
		
		int start = 0, end = 0;
		
		while (start < n) {
			while (end < n && sb.charAt(end) != ' ') {
				end++;
			}
			reverse(sb, start, end - 1);
			start = end + 1;
			end++;
		}
		
		return sb.toString();
	}
	
	public static String reverseWords(String s) {
		StringBuilder sb = trimSpaces(s);
		
		reverse(sb, 0, sb.length()-1);
		
//		System.out.println(sb);
		
		return reverseEachWord(sb);
    }

}
