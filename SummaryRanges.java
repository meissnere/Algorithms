package techQuestions;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,7};
        List<String> output = summaryRanges(nums);

        System.out.println("heillo");
    }

    public static List<String> summaryRanges(int[] nums) {
        if (nums == null) {
            return new ArrayList<String>();
        }

        List<String> list = new ArrayList<>();

        int start = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i+1] != nums[i] + 1) {
                if (start == i) {
                    list.add(nums[i] + "");
                } else {
                    list.add(nums[start] + "->" + nums[i]);
                    start = i + 1;
                }
            }
        }

        return list;
    }

}
