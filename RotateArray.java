package techquestions;

public class RotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5,6,7};
		
		int n = 19;
		
		char c = 9;
		
		int nsfasdg = (int) c;
		
		System.out.println("hag");
		
		String s = n + "";
		
//		rotate(arr, 3);
//		
//		for (int nummies : arr) {
//			System.out.println(nummies);
//		}
	}
	
	public static void rotate(int[] nums, int k) {
        int[] cp = new int[k+1];
        
        for (int i = 0; i <= k; i++) {
        	cp[i] = nums[i];
        	System.out.println(cp[i]);
        }
        
        int j = 0;
        for (int i = k + 1; i < nums.length; i++) {
        	nums[j] = nums[i];
        	j++;
        }
               
        int z = 0;

        for (int i = k; i < nums.length; i++) {
        	nums[i] = cp[z];
        	System.out.println("i is: " + i + " and nums is: " + nums[i]);
        	z++;
        }
        
    }

}
