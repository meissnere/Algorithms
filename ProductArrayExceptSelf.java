package techQuestions;

import java.util.Arrays;

public class ProductArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {4,5,1,8,2};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        // answer with 0(N) space complexity where N is
        // the number of elements in nums array
//        int[] L = new int[nums.length],
//                R = new int[nums.length];
//        L[0] = 1;
//        R[nums.length - 1] = 1;
//        for (int i = 1; i < nums.length; i++) {
//            L[i] = L[i-1] * nums[i-1];
//        }
//        for (int i = nums.length-2; i >= 0; i--) {
//            R[i] = R[i+1] * nums[i+1];
//        }

        // what about O(1) space complexity?? don't
        // allocate these extra arrays. Output/answer
        // array doesn't count towards space
        // complexity
        int[] answer = new int[nums.length];
        // initialize answer array with prod of left
        answer[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i-1] * nums[i-1];
        }

        int R = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            R = R * nums[i+1];
            answer[i] = answer[i] * R;
        }

//        System.out.println(Arrays.toString(R) +
//                " " + Arrays.toString(L));
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = L[i] * R[i];
//        }
        return answer;
    };

}
