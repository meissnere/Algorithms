package techquestions;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "cbbbbd";
		System.out.println(longestPSubstring(s));
	}
	
	private static int maxLen = 0;
	private static int start;
	public static String longestPSubstring(String s) {
		int sLen = s.length();
		
		if (sLen < 2) {
			return s;
		}
		
		for (int i = 0; i < sLen - 1; i++) {
			// check for an odd length palindrome
			palindromeIndexer(s, i, i);
			// check for an even length palindrom
			palindromeIndexer(s, i, i+1);
		}
		
		return s.substring(start, start + maxLen);
	}
	
	public static void palindromeIndexer(String s, int k, int j) {
		System.out.print("for start: " + k + ", and end: " + j);
		while (k >= 0 && j < s.length() && s.charAt(j) == s.charAt(k)) {
			k--;
			j++;
		}
		if (maxLen < j - k - 1) {
			start = k + 1;
			maxLen = j - k - 1;
		}
		System.out.println(", maxLen = " + maxLen + ", and start is: " + start);
	}

}
