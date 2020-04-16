package techQuestions;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class ContiguousArray {
    public static void main(String[] args) {
        int[] weights = {0,1,0,1};

        System.out.println(findMaxLengthMap(weights));
    }

    public static int findMaxLengthMap(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // key = count , value = index
        int count = 0;
        map.put(0, -1);
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                count--;
            }
            if (map.containsKey(count)) {
                maxLength = Math.max(maxLength, i - map.get(count));
                continue;
            }
            map.put(count, i);
        }
        return maxLength;
    }

    public static int findMaxLength(int[] nums) {

        // first for loop runs N times where N == nums.length
        // second for loop runt N-1 times
        int max_length = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int zero_count = 0;
            int one_count = 0;
            if (nums[i] == 1) {
                one_count++;
            } else {
                zero_count++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (((zero_count - one_count) > (nums.length - j)) || ((one_count - zero_count) > (nums.length - j))) {
                    break;
                }
                if (nums[j] == 1) {
                    one_count++;
                } else {
                    zero_count++;
                }
                if (zero_count == one_count) {
                    max_length = Math.max(max_length, (j - i) + 1);
                }
            }
        }
        return max_length;
    }
}
