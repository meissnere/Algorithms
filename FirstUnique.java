package techQuestions;

import java.util.*;

public class FirstUnique {

    public Set<Integer> allAdded = new HashSet<Integer>();
    public Set<Integer> uniqueOnly = new LinkedHashSet<Integer>();

    public FirstUnique(int[] nums) {
        for (int element : nums) {
            add(element);
        }
    }

    public int showFirstUnique() {
        // our unique set is completely empty!
        if (uniqueOnly.isEmpty()) {
            return -1;
        }
        return uniqueOnly.iterator().next();
    }

    public void add(int value) {
        // we know that an add on a set will fail if
        // the element already exists!
        if (allAdded.add(value)) {
            uniqueOnly.add(value);
        } else {
            // this value is in allAdd! remove it from unique set
            uniqueOnly.remove(value);
        }
    }

    public static void main(String[] args) {
        // let me test this theory of truthiness for a set.add() ...
//        Set<Integer> test = new HashSet<Integer>();
//        System.out.println(test.add(5));
//        System.out.println(test.add(5));
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
