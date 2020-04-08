package techQuestions;

public class removeDupsSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,2};
		System.out.println(removeDuplicates(nums));
		for (int k = 0; k < nums.length; k++) {
			System.out.println(nums[k]);
		}
	}

	public static int removeDuplicates(int[] nums) {
	    if (nums.length == 0) return 0;
	    int i = 0;
	    for (int j = 1; j < nums.length; j++) {
	        if (nums[j] != nums[i]) {
	            i++;
	            nums[i] = nums[j];
	        }
	    }
	    return i + 1;
	}
}
