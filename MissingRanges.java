import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

    public static void main(String[] args) {
        int lower = 0;
        int upper = 99;
        int[] nums = {0,1,3,50,75};
        System.out.println(findMissingRanges(nums, lower, upper));
    }

    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<String>();

        if (nums.length == (upper - lower + 1)) {
            return result;
        }

        if (nums.length == 0) {
            if (lower == upper) {
                result.add(Integer.toString(lower));
                return result;
            } else {
                result.add(Integer.toString(lower) + "->" + Integer.toString(upper));
                return result;
            }
        }

        if (nums[0] != lower) {
            if (nums[0] - 1 == lower) {
                result.add(Integer.toString(lower));
            } else {
                result.add(Integer.toString(lower) + "->" + Integer.toString(nums[0]-1));
            }
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i+1] != (nums[i] + 1)) {
                if (nums[i+1] - nums[i] > 2) {
                    result.add(Integer.toString(nums[i]+1) + "->" + Integer.toString(nums[i+1]-1));
                } else {
                    result.add(Integer.toString(nums[i]+1));
                }
            }
        }

        if (nums[nums.length - 1] != upper) {
            if (nums[nums.length - 1] + 1 == upper) {
                result.add(Integer.toString(upper));
            } else {
                result.add(Integer.toString(nums[nums.length - 1]+1) + "->" + Integer.toString(upper));
            }
        }

        return result;

    }
}
