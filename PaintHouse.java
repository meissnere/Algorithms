package techquestions;

import java.util.Arrays;

public class PaintHouse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] costs = {{17,2,17},{16,16,5},{14,3,19},{4,3,2}};
		
		System.out.println(minCost(costs));
	}
	
	public static int minCost(int[][] costs) {		
		int numColors = 3;
		
		int numHouses = costs.length; 
		
//		System.out.println(numHouses);
		
		//start at 2nd row (i.e. House1)
				
//		System.out.println(Arrays.deepToString(costs));
		
		for (int i = 1; i < numHouses; i++) {
			// we're starting at 2nd row and choosing red
			// must look back to first row's blue and green costs
			costs[i][0] = costs[i][0] + Math.min(costs[i-1][1], costs[i-1][2]);
			// we're starting at 2nd row and choosing blue
			// must look back to first row's red and green costs
			costs[i][1] = costs[i][1] + Math.min(costs[i-1][0], costs[i-1][2]);
			// we're starting at 2nd row and choosing green
			// must look back to first row's red and blue costs
			costs[i][2] = costs[i][2] + Math.min(costs[i-1][0], costs[i-1][1]);
		}
		
//		System.out.println(Arrays.deepToString(costs));

		// create int that will point to last row
		int lastRow = numHouses - 1;
		// should be 12 here
		return Math.min(Math.min(costs[lastRow][0], costs[lastRow][1]), costs[lastRow][2]);
	}

}
