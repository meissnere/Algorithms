package techquestions;

public class ValidAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "anagram";
		String t = "nagarbm";
		
		System.out.println(validAnagram(s,t));
	}
	
	public static boolean validAnagram(String s, String t) {
		int[] sCharCount = new int[128];
		int[] tCharCount = new int[128];

		
		if (s.length() != t.length()) {
			return false;
		}
		
		int sAsciiValue = 0, tAsciiValue = 1;
		for (int i = 0; i < s.length(); i++) {
			sAsciiValue = s.charAt(i);
			sCharCount[sAsciiValue] = sCharCount[sAsciiValue] + 1;
			tAsciiValue = t.charAt(i);
			tCharCount[tAsciiValue] = tCharCount[tAsciiValue] + 1;
		}
		
		for (int j = 0; j < 128; j++) {
			if (sCharCount[j] != tCharCount[j]) {
				return false;
			}
		}
		
		return true;
	}

}
