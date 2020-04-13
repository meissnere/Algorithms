package techQuestions;

import java.util.Collections;
import java.util.PriorityQueue;

public class NewStoneWeight {
    public static void main(String[] args) {
        int[] weights = {2,7,4,1,8,1};

        System.out.println(lastStoneWeightHeap(weights));
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

    public static int lastStoneWeightHeap(int[] stones) {
        MaxIntHeap<Integer> heap = new MaxIntHeap<>();
        for (int stone: stones) {
            heap.add(stone);
        }

        // While there is more than one stone left, we need to remove the two largest
        // and smash them together. If there is a resulting stone, we need to put into
        // the heap.
        while (heap.size() > 1) {
            int stone1 = heap.poll();
            int stone2 = heap.poll();
            if (stone1 != stone2) {
                heap.add(stone1 - stone2);
            }
        }

        // Check whether or not there is a stone left to return.
        return heap.isEmpty() ? 0 : heap.poll();
    }
}
