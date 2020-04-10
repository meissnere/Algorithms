package techQuestions;

import java.util.Stack;

public class BackspaceStringCompare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "a#c";
		String T = "b";
		
		System.out.println(backspaceCompare(S, T));
	}
	
	// Given two strings S and T, return if they are equal when both 
	// are typed into empty text editors. # means a backspace character.
	public static boolean backspaceCompare(String S, String T) {
		Stack<Character> stack_S = new Stack<>();
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) != '#') {
				stack_S.add(S.charAt(i));
			} else if (stack_S.isEmpty()) {
				continue;
			} else {
				stack_S.pop();
			}
		}
		Stack<Character> stack_T = new Stack<>();
		for (int i = 0; i < T.length(); i++) {
			if (T.charAt(i) != '#') {
				stack_T.add(T.charAt(i));
			} else if (stack_T.isEmpty()) {
				continue;
			} else {
				stack_T.pop();
			}
		}
		S = stack_S.toString();
		T = stack_T.toString();
		return S.equals(T);
    }

}
