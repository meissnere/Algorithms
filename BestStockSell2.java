package techQuestions;

public class BestStockSell2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {7,1,5,3,6,4};
		
		System.out.println(bestStockSell2(prices));
	}
	
	public static int bestStockSell2(int[] prices) {
		int maxProfit = 0;
		int peak = prices[0];
		int valley = prices[0];
		
		int i = 0;
		while (i < prices.length - 1) {
			// discovering valley
			while (i < prices.length - 1 && prices[i] >= prices[i+1]) {
				i++;
			}
			valley = prices[i];
			while (i < prices.length - 1 && prices[i] <= prices[i+1]) {
				i++;
			}
			peak = prices[i];
			maxProfit = maxProfit + (peak - valley);
		}
		
		return maxProfit;
//		return calculatePrices(arr, 0);
	}

	public static int calculatePrices(int[] arr, int startIndex) {
		return 0;
	}
}
