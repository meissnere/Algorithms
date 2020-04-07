package techquestions;

public class HouseRobber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] houseMoney = {2,7,9,3,1,85};
		System.out.println(maxRob(houseMoney));
	}
	
	public static int maxRob(int[] nums) {
		// starts at nums[-2]
		int prevMax = 0;
		// starts at nums[-1]
		int currMax = 0;
		
		for (int x: nums) {
			int temp = currMax;
			// currMax = max between nums[-2] + nums[0] & nums[-1]
			currMax = Math.max(prevMax + x, currMax);
			// prevMax now equals nums[-1]
			prevMax = temp;
		}
		
		return currMax;
	}

}
