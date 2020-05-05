package techQuestions;

/*
Purpose: Given an array nums of 0s and 1s and an integer k, return
True if all 1's are at least k places away from each other, otherwise
return False

Author: Erich Meissner
Date: 5/2/2020
Time: 11:06 PM
*/


public class Check1sLeastKPlaces {

    public static void main(String[] args) {
        int[] nums = {0,0,0};
        int k = 2;

        System.out.println(kLengthApart(nums, k));
    }

    public static boolean kLengthApart(int[] nums, int k) {
        int i = 0;
        while (i < nums.length && nums[i] == 0) {
            i++;
        }
//        if (i >= nums.length) {
//            return false;
//        }
        int count = 0;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] == 0) {
                count++;
                continue;
            }
            if (count < k) {
                return false;
            }
            count = 0;
        }
        return true;
    }
}
