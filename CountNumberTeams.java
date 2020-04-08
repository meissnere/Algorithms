package techQuestions;

public class CountNumberTeams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] rating = {2,5,3,4,1};
		
		String s = "22 hjkewrb 23423";
		System.out.println(s.split(" ")[1]);
		
		System.out.println(numTeams(rating));
	}
	
	public static int numTeams(int[] rating) {
		if (rating.length < 1 || rating == null) {
			return 0;
		}
		int teams = 0;
		for (int i = 0; i < rating.length - 2; i++) {
			for (int j = i + 1; j < rating.length - 1; j++) {
				for (int k = j + 1; k < rating.length; k++) {
					if ((rating[i] > rating[j] && rating[j] > rating[k]) || (rating[i] < rating[j] && rating[j] < rating[k])) { 
						teams++;
					}
				}
			}
		}
		return teams;
	}

}
