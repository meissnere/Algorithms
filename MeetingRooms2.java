package techQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] intervals = {{11,30},{10,20},{3,19},{8,12},{2,7},{1,10}};
		
		System.out.println(minMeetingRooms(intervals));
	}

	public static int minMeetingRooms(int[][] intervals) {
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		System.out.println(Arrays.deepToString(intervals));

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		if (intervals.length == 0) {
			return 0;
		}
		// add first end time to minHeap
		minHeap.add(intervals[0][1]);
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] < minHeap.peek()) {
				minHeap.add(intervals[i][1]);
			} else {
				minHeap.remove();
				minHeap.add(intervals[i][1]);
			}
		}

		return minHeap.size();

    }
}
