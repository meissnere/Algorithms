package techQuestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FirstUnique {

    public static List<Integer> list = new ArrayList<Integer>();
    public Set<Integer> set = new HashSet<Integer>();

    public FirstUnique(int[] nums) {
        for (int element : nums) {
            if (list.contains(element)) {
                list.remove(list.indexOf(element));
                set.add(element);
                continue;
            } else if (set.contains(element)) {
                continue;
            }
            list.add(element);
        }
    }

    public int showFirstUnique() {
        if (list.isEmpty()) {
            return -1;
        }
        return list.get(0);
    }

    public void add(int value) {
        if (list.contains(value)) {
            list.remove(list.indexOf(value));
            return;
        } else if (set.contains(value)) {
            return;
        }
        list.add(value);
    }

    public static void main(String[] args) {
        int[] nums = {7,7,7,7,7,7};
        FirstUnique obj = new FirstUnique(nums);
        obj.add(7);
        obj.add(3);
        obj.add(3);
        obj.add(7);
        obj.add(17);
        System.out.println(obj.showFirstUnique());
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
