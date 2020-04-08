package techQuestions;
public class TrappingRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
		
		System.out.println(trappedWater(heights));
	}

	public static int trappedWater(int[] height) {
		// simple check to see if height is null
		if (height == null) {
			// no water trapped
			return 0;
		}
		int[] left_max = new int[height.length];
		for (int t = 0; t < left_max.length; t++) {
			left_max[t] = 0;
		}
		//left_max for height[0] is 0
		left_max[0] = height[0];
		// start at height[1] and go to end
		for (int i = 1; i < height.length; i++) {
			left_max[i] = Math.max(height[i], left_max[i-1]);
			System.out.println("at " + i + ", max Left is: " + left_max[i]);
		}				
		int[] right_max = new int[height.length];
		// right_max for end of array is the value of 
		right_max[height.length - 1] = height[height.length - 1];
		for (int j = height.length - 2; j >= 0; j--) {
			right_max[j] = Math.max(height[j], right_max[j+1]);
			System.out.println("at " + j + ", max Right is: " + right_max[j]);
		}
		int ans = 0;
		for (int k = 0; k < height.length; k++) {
			System.out.println(ans + ": leftMax: " + left_max[k] + ", rightMax: " + right_max[k] + ", height: " + height[k]);
			ans = ans + Math.min(left_max[k], right_max[k]) - height[k];
		}
		
		return ans;
	}
}
