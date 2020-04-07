package techquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {4,3,10,9,8};
		
		List<Integer> output = minSubsequence(nums);
		
		System.out.println(output.toString());
	}
	
	public static List<Integer> minSubsequence(int[] nums) {
        int sum = 0;
        
        Arrays.sort(nums);
        
        System.out.println(Arrays.toString(nums));
        
        for (int i = 0; i < nums.length; i++) {
        	sum = sum + nums[i];
        }
        
        int z = 0;
        int minSum = nums[nums.length-1];
        int rest = sum - minSum;
        System.out.println(minSum + " " + rest);
        while (z <= nums.length) {
        	if (minSum - rest > 0) {
        		break;
        	}
        	z++;
        	minSum = minSum + nums[nums.length-z-1];
        }
        
        List<Integer> result = new ArrayList<>(z);
        z = z - 1;
        int a = nums.length - 1;
        for (int q = 0; q < result.size(); q++) {
        	result.add(nums[a]);
        	a--;
        }
        
        
        return result;
    }

}
