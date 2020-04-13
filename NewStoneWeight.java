package techQuestions;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class NewStoneWeight {
    public static void main(String[] args) {
        int[] weights = {2,7,4,1,8,1};

        System.out.println(lastStoneWeight(weights));
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(stones.length, Collections.reverseOrder());
        for (int stone: stones) {
            queue.add(stone);
        }

        while (!(queue.size() == 0 || queue.size() == 1)) {
            int firstStone = queue.poll();
            int secondStone = queue.poll();
            int smashResult = firstStone - secondStone;
            if (smashResult == 0) {
                continue;
            }
            queue.add(smashResult);
        }

        if (queue.isEmpty()) {
            return 0;
        }
        return queue.poll();
    }
}
