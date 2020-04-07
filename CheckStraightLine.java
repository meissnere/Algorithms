package techQuestions;

import java.util.Arrays;

public class CheckStraightLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] coordinates = {{-4,-3},{1,0},{3,-1},{0,-1},{-5,2}};
		
		System.out.println(checkStraightLine(coordinates));
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
