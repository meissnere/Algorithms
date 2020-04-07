package techquestions;

public class HappyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 19;
		System.out.println(isHappy(n));
	}
	
	public static boolean isHappy(int n) {
		if (n == 1) {
			return true;
		}
		
		int sum = 0;
		String number = n + "";

		for (int i = 0; i < number.length(); i++) {
			int ascii = number.charAt(i);
			int digit = Character.getNumericValue(ascii);
			sum += digit * digit;
			System.out.println("sum: " + sum);
		}
		
		System.out.println("new call!");
		return isHappy(sum);
	}

}
