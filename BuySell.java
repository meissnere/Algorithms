package techquestions;

public class BuySell {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {1, 2};
		System.out.println(maxProfit(prices));
	}
	
	public static int maxProfit(int[] prices) {
		int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            }
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        
        return maxProfit;
	}

}
