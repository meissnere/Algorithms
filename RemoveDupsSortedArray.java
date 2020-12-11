public class RemoveDupsSortedArray {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
    }

    public static int[] removeDup(int[] arr, int index) {
        for (int i = index + 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }

        return arr;
    }

    public static int removeDuplicates(int[] nums) {
        int count = 1;
        int finalLength = nums.length;
        int i = 1;

        while (i < finalLength) {
            if (nums[i-1] == nums[i]) {
                count++;
                if (count > 2) {
                    removeDup(nums, i);
                    finalLength--;
                    i--;
                }
            } else {
                count = 1;
            }
            i++;
        }
        return finalLength;
    }

}
