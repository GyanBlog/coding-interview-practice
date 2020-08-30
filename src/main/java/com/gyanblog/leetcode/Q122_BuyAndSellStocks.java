package com.gyanblog.leetcode;

public class Q122_BuyAndSellStocks {

	private int maxProfit_simpleRecursive(int[] prices, int startIndex) {
        if (startIndex >= prices.length) {
        	return 0;
        }
        
        int maxProfit = 0;
        for (int i=startIndex; i<prices.length; i++) {
        	int max = 0;
        	for (int j=i+1; j<prices.length; j++) {
        		//when can we sell
        		if (prices[j] > prices[i]) {
        			int profit = (prices[j] - prices[i]) + this.maxProfit_simpleRecursive(prices, j+1);
        			if (max < profit) {
        				max = profit;
        			}
        		}
        	}
        	
        	if (maxProfit < max) {
        		maxProfit = max;
        	}
        }
        
        return maxProfit;
    }
	
	public int maxProfit_simple(int[] prices) {
        return this.maxProfit_simpleRecursive(prices, 0);
    }
	
	public int maxProfit_better(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int max = 0;
		int i=0;
		
		int lowPrice = prices[i];
		int highPrice = prices[i];
		i++;
		
		while (i < prices.length) {
			while (i < prices.length && prices[i-1] >= prices[i]) {
				i++;
			}
			lowPrice = prices[i-1];
			
			while (i<prices.length && prices[i] >= prices[i-1]) {
				i++;
			}
			highPrice = prices[i-1];
			
			max += (highPrice - lowPrice);
		}
		
		return max;
	}
	
	public int maxProfit_better2(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int max = 0;
		
		for (int i=1; i<prices.length; i++) {
			if (prices[i] > prices[i-1]) {
				max += (prices[i] - prices[i-1]);
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
//		System.out.println("Test-1 status=" + (test1() ? "pass" : "fail"));
		
		System.out.println("Test-2 status=" + (test2() ? "pass" : "fail"));
	}
	
	public static boolean test1() {
		Q122_BuyAndSellStocks q = new Q122_BuyAndSellStocks();
		int[] prices = {7,1,5,3,6,4};
		int result = q.maxProfit_better(prices);
		
		return result == 7;
	}
	
	public static boolean test2() {
		Q122_BuyAndSellStocks q = new Q122_BuyAndSellStocks();
		int[] prices = {3, 3};
		int result = q.maxProfit_better(prices);
		
		return result == 0;
	}
}
