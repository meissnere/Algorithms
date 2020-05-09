package techQuestions;

import java.util.Arrays;

public class CheckStraightLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] coordinates = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
		int[][] secondCoords = {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
		
		System.out.println(checkStraightLineNew(secondCoords));
	}

	public static boolean checkStraightLineNew(int[][] coordinates) {
		// if rise over run for each pair of coordinates
		// is not equal, then we know this is not a straight
		// line!
		int x_base = coordinates[0][0];
		int y_base = coordinates[0][1];
		float slope = (float) 0.0;
		if (coordinates[1][0] - x_base != 0) {
			slope = (float)(coordinates[1][1] - y_base) / (coordinates[1][0] - x_base);
		} else {
			return false;
		}
//		System.out.println(slope);
//		System.out.println(Arrays.deepToString(coordinates));
		for (int i = 2; i < coordinates.length; i++) {
			if (coordinates[i][0] - x_base != 0) {
				float currSlope = (float)(coordinates[i][1] - y_base) / (coordinates[i][0] - x_base);
				if (currSlope != slope) {
					return false;
				}
			} else {
				return false;
			}

		}
		return true;
	}

	
	public static boolean checkStraightLine(int[][] coordinates) {
		System.out.println(Arrays.toString(coordinates[0]));
		
		double slope = calculateSlope(coordinates[0], coordinates[1]);
        for(int i = 0; i < coordinates.length-1; i++) {
        	double hag = calculateSlope(coordinates[i], coordinates[i+1]);
            if (slope != hag) {
                return false;
            }
        }
        
        return true;
    }
    
    public static double calculateSlope(int[] a, int[] b) {
    	System.out.println(Arrays.toString(a));
    	System.out.println(Arrays.toString(b));
    	System.out.println(b[1]);
    	System.out.println(a[1]);
    	System.out.println(b[0]);
    	System.out.println(a[0]);
    	
        return (((double)b[1]-a[1])/((double)b[0]-a[0]));
    }
	
        
//		for (int i = 0; i < coordinates.length - 1; i++) {
//			int x_increase = coordinates[i][0] - coordinates[i+1][0];
//			int y_increase = coordinates[i][1] - coordinates[i+1][1];
//			if (x_increase != y_increase) {
//				return false;
//			}
//		}
//		
//		return true;
//    } 

}
