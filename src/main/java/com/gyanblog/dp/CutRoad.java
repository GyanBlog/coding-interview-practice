package com.gyanblog.dp;

/*
 * The rod-cutting problem is the following. 
 * Given a rod of length n inches and a table of prices pi for i D 1; 2; : : : ; n, 
 * determine the maximum revenue rn obtain- able by cutting up the rod and selling the pieces. 
 * Note that if the price pn for a rod of length n is large enough, an optimal solution may require no cutting at all.
 */
public class CutRoad {

	public int cutRod(int[] arr, int n) {
		if (n <= 0) {
			return 0;
		}
		
		int max = Integer.MIN_VALUE;
		for (int i=0; i<n; i++) {
			max = Math.max(max, arr[i] + cutRod(arr, n-i-1));
		}
		return max;
	}
	
	private int[] dp;
	public int cutRod_dp(int[] arr, int n) {
		this.dp = new int[n+1];
		for (int i=0; i<=n; i++) {
			this.dp[i] = Integer.MIN_VALUE;
		}
		
		return this.cutRod_dp_helper(arr, n);
	}
	
	private int cutRod_dp_helper(int[] arr, int n) {
		if (this.dp[n] >= 0) return this.dp[n];
		if (n <= 0) {
			return 0;
		}
		
		int max = Integer.MIN_VALUE;
		for (int i=0; i<n; i++) {
			max = Math.max(max, arr[i] + cutRod(arr, n-i-1));
		}
		
		this.dp[n] = max;
		return max;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
		
		CutRoad c = new CutRoad();
		int res = c.cutRod_dp(arr, 4);
		System.out.println(res);
	}
}
