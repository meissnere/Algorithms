package techquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class DegreeOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,2,3,1};
		System.out.println(findShortestSubArray(nums));
	}

	public static int findShortestSubArray(int[] nums) {
		
		Map<Integer, Integer> right = new HashMap(),
				left = new HashMap(), count = new HashMap();
		
		for (int i = 0; i < nums.length; i++) {
			int x = nums[i];
			if (left.get(x) == null) {
				left.put(x, i);
			}
			right.put(x, i);
			count.put(x, count.getOrDefault(x, 0)+1);
		}
		
		
		int ans = nums.length;
		int degree = Collections.max(count.values());
		
//		System.out.println(left.entrySet() + ", right: " + right.entrySet() + ", count: " + count.entrySet());
		
		for (int x: count.keySet()) {
			if (count.get(x) == degree) {
				ans = Math.min(ans, right.get(x) - left.get(x) + 1);
			}
		}
		
		
		return ans;
		
		
		
		
		
		
		
		
		
		
//		Map<Integer, Integer> occurrences = new HashMap<>();
//		System.out.println(occurrences.keySet());
//		for (int i = 0; i < nums.length; i++) {
//			if (occurrences.containsKey(nums[i]) == true) {
//				System.out.println(nums[i] + ": " + occurrences.containsKey(nums[i]));
//				occurrences.put(nums[i], (occurrences.get(nums[i])+1));
//			} else {
//				occurrences.put(nums[i], 1);
//			}
//		}
//		System.out.println(occurrences.keySet() + ", " + occurrences.values());
//		int max = Collections.max(occurrences.values());
//		System.out.println("max is: " + max);
//		
//		int ourNum = 999;
//		int j = 0;
//		ArrayList<Integer> ans = new ArrayList<>();
//		for (int x: occurrences.keySet()) {
//			
//			if (occurrences.get(x) == max) {
//				ourNum = x;
//				System.out.println("ourNum is: " + ourNum);
//				int start = 0;
//				for (int i = 0; i < nums.length; i++) {
//					if (nums[i] == ourNum) {
//						System.out.println("start is: " + i);
//						start = i;
//						break;
//					}
//				}
//				
//				int end = -999;
//				for (int i = nums.length - 1; i >= 0; i--) {
//					if (nums[i] == ourNum) {
//						System.out.println("end is: " + i);
//						end = i;
//						break;
//					}
//				}
//				
//				ans.add(j, end - start + 1); 
//				System.out.println("ans is: " + ans.get(j));
//				j++;
//			}
//		}
//		System.out.println(ans);
//
//		int[] newAns = ans.stream().mapToInt(i -> i).toArray();
//		Arrays.sort(newAns);
//		
//		System.out.println(Arrays.toString(newAns));
//		
//		System.out.println("shortest length is: " + newAns[0]);
//		
//		return newAns[0];
	}
	

}
