package techQuestions;

public class PalindromPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "tacoasdcat";
		
		System.out.println(palindrome(s));
	}
	
	public static boolean palindrome(String s) {
		// create counter for letters in the string 
		int[] counter = new int[128];
		
		int AsciiValue = 0;
		for (int i = 0; i < s.length(); i++) {
			AsciiValue = s.charAt(i);
			counter[AsciiValue]++;
		}
		
		int oddLetters = 0;
		for (int j = 0; j < counter.length; j++) {
			if ((counter[j] % 2) != 0) {
				oddLetters++;
			}
		}
		
		if (oddLetters > 1) {
			return false;
		} else if ((s.length() % 2) != 0) {
			if (oddLetters != 1) {
				return false;
			}
		} else if ((s.length() % 2) == 0 && oddLetters > 0) {
			return false;
		} 
		
		return true;
	}
}
