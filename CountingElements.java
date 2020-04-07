package techQuestions;

import java.util.HashSet;

public class CountingElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,5,3,1,0};
		
		System.out.println(countElements(arr));
	}
	
	public static int countElements(int[] arr) {
		int count = 0;
		
		HashSet<Integer> set = new HashSet<>();
		
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (set.contains(arr[i] + 1)) {
				count++;
			}
		}
		
		return count;
	}

}
