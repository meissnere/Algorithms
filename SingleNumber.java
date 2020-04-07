package techquestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4, 1, 2, 1, 2};
		
		System.out.println(singleNumber(nums));
	}
	
	public static int singleNumber(int[] nums) {
		Set<Integer> set = new HashSet<>();
		
		int sumSet = 0;
		int doubleSet = 0;
		
		for (int num: nums) {
			if (!set.contains(num)) {
				set.add(num);
				sumSet = sumSet + num;
				doubleSet = doubleSet + num;
			} else {
				sumSet = sumSet + num;
			}
		}
		
		doubleSet = 2 * doubleSet;
		
		return doubleSet - sumSet;
		
	}

}
