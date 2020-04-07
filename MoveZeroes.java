package techquestions;

import java.util.Arrays;

public class MoveZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,1,0,3,12};
		
		moveZeroes(nums);
		
		System.out.println(Arrays.toString(nums));
	}
	
	public static void moveZeroes(int[] nums) {
		int z = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[z] == 0) {
				continue;
			}
			nums[z] = nums[i];
			z++;
		}
	}

}
