package techQuestions;

public class JumpGame {
//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
//Each element in the array represents your maximum jump length at that position.
//
//Determine if you are able to reach the last index.
    public static void main(String[] args) {
        int[] nums = {2, 0, 0, 1, 4};
        System.out.println(canJump(nums));
    }

    // brute force is trying every possible jump
    // at all indexes you reach within that recursion
    public static boolean canJump(int[] nums) {
        // if the first index tell you to jump 0,
        // then return false
        if (nums.length == 1) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }
        // we start at index = 0
        return canJumpRecurser(nums, 0);
    }

    // write the recursive method outlined above:
    public static boolean canJumpRecurser(int[] nums, int stepIndex) {
        // return true if we're currently at the final index
        // this is our recursive base case
        if (stepIndex == nums.length - 1) {
            return true;
        }

        // create a jump variable that gets you to end, and if not,
        // make it that largest jump possible
        int longest_step = Math.min(stepIndex + nums[stepIndex],nums.length - 1);
        if (longest_step == nums.length - 1) {
            return true;
        }
        // must create a loop to go through all possible jumps!
        for (int next_step = stepIndex + 1; next_step <= longest_step; next_step++) {
            if (canJumpRecurser(nums, next_step)) {
                return true;
            }
        }
        // if we ever get here, we know we cant reach end
        return false;
    }
}
