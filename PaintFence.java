package techquestions;

public class PaintFence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int posts = 1, colors = 0;
		System.out.println(paintFence(posts, colors));
	}
	
	public static int paintFence(int n, int k) {
		// if there are no posts to color, then return 0 possibilities
		if (n == 0) {
			return 0;
		}
		
		// if there is just one post to color, then return number of colors
		if (n == 1) {
			return k;
		}
		
		// if there are no colors, there are no options
		if (k == 0) {
            return 0;
        }
		
		// initializing first two posts for the count
		
		// there are as many options as there are colors to paint first two the same
		int sameColorCount = k;
		
		// there are this many options to paint first two different colors
		int diffColorCount = k * (k - 1);
		
		for (int i = 2; i < n; i++) {
			int temp = diffColorCount;
			// if we color 3rd post a different color than the second
			diffColorCount = (sameColorCount + diffColorCount) * (k - 1);
			// if we color 3rd post the same color as the second
			sameColorCount = temp;
		}
		
		return sameColorCount + diffColorCount;
	}

}
