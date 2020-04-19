package techQuestions;

public class SearchRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;

        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        } else if (nums.length == 1 && nums[0] != target) {
            return -1;
        }
        int endVal = nums[nums.length - 1];
        int startVal = nums[0];

        // check if the target is even in the nums array
        if (target > endVal && target < startVal) {
            return -1;
        }

        return searchRecurse(nums, target, nums.length - 1, 0);
    }

    public static int searchRecurse(int[] nums, int target, int end, int start) {
        if (start > end) {
            return -1;
        }
        int middleIndex = start + (end - start) / 2;
        // base case to end recursion:
        if (nums[middleIndex] == target) {
            return middleIndex;
        }
        if (nums[middleIndex] >= nums[start]) {
            if(target >= nums[start] && target < nums[middleIndex]) {
                return searchRecurse(nums, target, middleIndex - 1, start);
            } else {
                return searchRecurse(nums, target, end, middleIndex + 1);
            }
        } else {
            if(target <= nums[end] && target > nums[middleIndex]) {
                return searchRecurse(nums, target, end, middleIndex + 1);
            } else {
                return searchRecurse(nums, target, middleIndex - 1, start);
            }
        }
    }
}
