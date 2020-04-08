package techQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LeetCode1239 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[] test = {"un","iq","ue"};
//		
//		System.out.println(arr.length);
//		System.out.println(arr[0]);
//		String sTest = arr[0];
//		System.out.println(s.length());
		
		List<String> arr = new ArrayList<String>();
		
		arr.add("cha");
		arr.add("r");
		arr.add("act");
		arr.add("ers");
		
		System.out.println(lastTry(arr));
	}

	public static int maxLength(List<String> arr) {
		
		List<Integer> dp = new ArrayList<>();
        dp.add(0);
        int res = 0;
        for (String s : arr) {
        	System.out.print(s + ": ");
            int a = 0, dup = 0;
            for (char c : s.toCharArray()) {
            	int ASCII = c - 'a';
            	System.out.println("current char is: " + c + ", and ASCII is: " + ASCII);
                dup |= a & (1 << (c - 'a'));
                a |= 1 << (c - 'a');
                System.out.print("dup: " + dup + ", a_value: " + a + " || ");
            }
            if (dup > 0) continue;
            System.out.println("dp size is: " + dp.size());
            for (int i = dp.size() - 1; i >= 0; --i) {
                if ((dp.get(i) & a) > 0) continue;
                System.out.println("dp.get(" + i + ") | " + a + " = " + (dp.get(i) | a));
                dp.add(dp.get(i) | a);
                res = Math.max(res, Integer.bitCount(dp.get(i) | a));
            }
            System.out.println();
        }
        return res;
	}
	
	public static int myMethod(List<String> arr) {
        int[] alphabetCount = new int[26];
        
        List<String> verifiedSubstring = new ArrayList<>();
        ArrayList<int[]> characterCounts = new ArrayList<int[]>();
        
        for (String s : arr) {
        	boolean omitSubstring = false;
    		alphabetCount = new int[26];
        	for (char c : s.toCharArray()) {
            	int ASCII = c - 'a';
            	alphabetCount[ASCII] += 1;
            	if (alphabetCount[ASCII] > 1) {
            		omitSubstring = true;
            		System.out.println("you will exit this loop early");
            		break;
            	}
        	}
        	System.out.println(Arrays.toString(alphabetCount));
        	if (omitSubstring == true) {
        		System.out.println("time to move on");
        		continue;
        	}
        	
        	System.out.println(s + " is verified");
        	characterCounts.add(alphabetCount);
        	verifiedSubstring.add(s);
        }
        
        System.out.println(verifiedSubstring.toString());

        int j = 0;
        for (int[] currentAlphaCount : characterCounts) {
        	for (int i = j + 1; i < characterCounts.size(); i++) {
        		
        	}
        	j++;
        	System.out.println(currentAlphaCount[4]);
        }

		return 9999;
	}
	
	public static boolean isUnique(String s) {
		if (s.length() > 26) {
			return false;
		}
		
		boolean[] appeared = new boolean[26];
		
		for (char c : s.toCharArray()) {
			if (appeared[(c-'a')]) {
				return false;
			}
			appeared[(c-'a')] = true;
		}
		
		return true;
	}
	
	public static int lastTry(List<String> arr) {
		
		List<String> res = new ArrayList<>();
		
		// initialize res with an empty string, therefore we can compare a string s with itself
		res.add("");
		
		for (String s : arr) {
			// if this substring is not unique itself, stop testing on it
			if (!isUnique(s)) {
				continue;
			}
			
			// this list of strings will hold all valid concatenations of s and res strings
			List<String> resList = new ArrayList<>();

			// combining current "s" string and all strings in res list thus far
			for (String candidate : res) {
				String temp = candidate + s;
//				System.out.println(temp);
				if (isUnique(temp)) {
					resList.add(temp);
				}
			}
//			System.out.println(resList.toString());
			// add all the unique strings to resList
			res.addAll(resList);
		}
		
		int maxLength = 0;
		for (String concat : res) {
        	maxLength = Math.max(concat.length(), maxLength);
        }
		
		return maxLength;
	}
		
//		Iterator<String> strings = arr.iterator();
//		
//		int[] alphabetCount = new int[26];
		
//		while (strings.hasNext()) {
//			System.out.println(strings.next());
//		}
		
//		for (int i = 0; i<arr.size(); i++) {
//			String s = arr.get(i);
//			for (int j = 0; j<s.length(); j++) {
//				int alphaIndex = s.charAt(j) - 'a';
//				alphabetCount[alphaIndex]++;
//			}
//			for (int z = 0; z<alphabetCount.length; z++) {
//				System.out.print(alphabetCount[z] + " ");
//			}
//			alphabetCount = new int[26];
//			System.out.println();
//		}
//		
//		return 0;

	
}
