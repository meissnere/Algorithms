package techQuestions;

public class MaximumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		
//		System.out.println(nums.length);
		
		System.out.println(maxSubArray(nums));
	}

	public static int maxSubArray(int[] nums) {
		// helper function takes array and start and end index
		return helper(nums, 0, nums.length - 1);
    }
	
	public static int helper(int[] nums, int left, int right) {
		// base case is defined as if n==1 (meaning the subarray that 
		// is sent has length == 1), then just return that element
		// if the left index is the same as the right index
		if (left == right) {
			return nums[left];
		}
		
		int divide = (left + right) / 2;
		
		int leftSum = helper(nums, left, divide);
		int rightSum = helper(nums, divide + 1, right);
		int crossSum = crossSum(nums, left, right, divide);
		
		return Math.max(Math.max(rightSum, leftSum), crossSum);
	}
	
	// cross sum is created to find the max of the subarray containing both
	// elements from left and right subarrays
	public static int crossSum(int[] nums, int left, int right, int divide) {
		if (left == right) return nums[left];

	    int leftSubsum = Integer.MIN_VALUE;
	    int currSum = 0;
	    for(int i = divide; i > left - 1; --i) {
	      currSum += nums[i];
	      leftSubsum = Math.max(leftSubsum, currSum);
	    }

	    int rightSubsum = Integer.MIN_VALUE;
	    currSum = 0;
	    for(int i = divide + 1; i < right + 1; ++i) {
	      currSum += nums[i];
	      rightSubsum = Math.max(rightSubsum, currSum);
	    }

	    return leftSubsum + rightSubsum;
	}
}
