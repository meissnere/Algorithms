package techquestions;

public class MeetingRooms2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] intervals = {{6,15},{13,20},{6,17}};
		
		System.out.println(minMeetingRooms(intervals));
	}

	public static int minMeetingRooms(int[][] intervals) {
		
		int requiredRooms = 1;
		int newRequirement = 1;
		if (intervals == null || intervals.length == 0) {
			return 0;
		}
		
		for (int i = 0; i < intervals.length; i++) {
			newRequirement = 1;
			for (int j = 0; j < intervals.length; j++) {
				if (i == j) {
					continue;
				}
				// if start is within start and end times OR end is within start and end times
				if ((intervals[j][0] >= intervals[i][0] && intervals[j][0] <= intervals[i][1])
						|| (intervals[j][1] >= intervals[i][0] && intervals[j][1] <= intervals[i][1])) {
					System.out.println("j is: " + j + ", i is: " + i);
					newRequirement = newRequirement + 1;
					System.out.println(newRequirement);
				}
			}
			System.out.println(newRequirement);
			requiredRooms = Math.max(newRequirement, requiredRooms);
		}
		
		
		return requiredRooms;
    }
}
