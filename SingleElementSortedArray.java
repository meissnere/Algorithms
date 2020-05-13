package techQuestions;

/*
Purpose: You are given a sorted array consisting of only integers
where every element appears exactly twice, except for one element
which appears exactly once. Find this single element that appears only once.

Example 1:

Input: [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: [3,3,7,7,10,11,11]
Output: 10


Note: Your solution should run in O(log n) time and O(1) space.
Author: Erich Meissner
Date: 5/12/20
Time: 9:36 PM
 */


public class SingleElementSortedArray {
    public static void main(String[] args) {
        int[] nums = {1,1,3,3,4,4,8,8,9};
        System.out.println(singleNonDuplicate(nums));
    }

    public static int singleNonDuplicate(int[] nums) {
        int start = 0;
        int finish = nums.length - 1;
        while (start < finish) {
            int mid = ((finish - start) / 2) + start;
            boolean lookRight = (finish - mid) % 2 == 0;
            if (nums[mid+1] != nums[mid] && nums[mid-1] != nums[mid]) {
                return nums[mid];
            }
            if (nums[mid + 1] == nums[mid]) {
                if (lookRight) {
                    start = mid + 2;
                } else {
                    finish = mid - 1;
                }
            } else {
                // must be in case where number left of mid
                // is equal to mid value
                if (lookRight) {
                    finish = mid - 2;
                } else {
                    start = mid + 1;
                }
            }
        }
        return nums[start];
    }

    public static int binarySearch(int[] nums, int index) {
        if (index == 0) {
            if (nums[1] != nums[0]) {
                return nums[0];
            }
        }
        if (index == nums.length-1) {
            if (nums[nums.length-2] != nums[index]) {
                return nums[index];
            }
        }
        if (nums[index] != nums[index - 1] && nums[index] != nums[index + 1]) {
            return nums[index];
        }
        if (nums[index-1] == nums[index]) {
            if ((index-2) % 2 == 0) {
                // must look right
                int newMid = index + 1 + ((nums.length - (index + 1)) / 2);
                return binarySearch(nums, newMid);
            } else {
                int newMid = (index - 2) / 2;
                return binarySearch(nums, newMid);
            }
        } else {
            if ((index-1) % 2 == 0) {
                // must look right
                int newMid = index + 2 + ((nums.length - (index + 2)) / 2);
                return binarySearch(nums, newMid);
            } else {
                int newMid = (index - 1) / 2;
                return binarySearch(nums, newMid);
            }
        }
    }
}
