package techQuestions;

/*
Purpose: Given a collection of distinct integers,
return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

Author: Erich Meissner
Date: 5/14/20
Time: 7:47 PM
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        // convert the nums array into a list
        // so we can stay in line with expected output
        List<Integer> numsList = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            numsList.add(nums[i]);
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtracker(numsList, result, nums.length, 0);
        return result;
    }

    public static void backtracker(List<Integer> nums, List<List<Integer>>
                                   result, int len, int start) {
        // base case is if we have met the end of the list length
        if (start == len) {
            // append the swapped up nums to the resultant list
            result.add(new ArrayList<>(nums));
        }
        // we start a for loop at the start parameter
        for (int i = start; i < len; i++) {
            // swap start with current i value, every nums
            // value will get their chance at the head
            Collections.swap(nums, i, start);
            // recurse with a start value incremented
            backtracker(nums, result, len, start+1);
            // this is where we back track...we re-enter loop
            // with original nums list passed here
            Collections.swap(nums, i, start);
        }
    }
}
