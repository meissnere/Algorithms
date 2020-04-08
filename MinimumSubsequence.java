package techQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {10,2,5};
		
		List<Integer> output = minSubsequence(nums);
		
		System.out.println(output.toString());
	}
	
	public static List<Integer> minSubsequence(int[] nums) {
		
		if (nums.length == 1) {
			List<Integer> case1 = new ArrayList<>();
			case1.add(nums[0]);
			return case1;
		}
		 
        int sum = 0;
        
        Arrays.sort(nums);
        
        System.out.println(Arrays.toString(nums));
        
        for (int i = 0; i < nums.length; i++) {
        	sum = sum + nums[i];
        }
        
        int z = 0;
        int minSum = nums[nums.length-1];
        int rest = sum - minSum;
        System.out.println(minSum + " " + rest + " " + nums.length);
        while (z <= nums.length) {
        	if (minSum - rest > 0) {
//        		z++;
        		break;
        	}
        	z++;
        	minSum = minSum + nums[nums.length-z-1];
        	System.out.println("new sum is: " + minSum);
        }
        
        System.out.println(z);

        if (z == 0) {
        	z = 1;
        }
        if (z == 1) {
        	z = 2;
        }
        List<Integer> result = new ArrayList<>(z);
        int a = nums.length - 1;
        for (int q = 0; q < z; q++) {
        	result.add(nums[a]);
        	System.out.println(nums[a]);
        	a--;
        }
        
        
        return result;
    }

}
