package techQuestions;

/*
Purpose: Given an array of size n, find the majority element. The
majority element is the element that appears more than n/2 times.

You may assume that the array is non-empty and the majority element
always exists in the array.

Input: [2,2,1,1,1,2,2]
Output: 2

Input: [3,2,3]
Output: 3

Author: Erich Meissner
Date: 5/6/2020
Time: 11:06 AM
*/


import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {
        int nums[] = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int minAppearance = nums.length / 2;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            if (map.get(nums[i]) > minAppearance) {
                return nums[i];
            }
        }
        return 1;
    }
}
