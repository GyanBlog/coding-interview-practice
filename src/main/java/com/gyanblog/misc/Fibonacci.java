package com.gyanblog.misc;

public class Fibonacci {

	private int[] dp;

	private int getFibo_dp_helper(int n) {
		if (this.dp[n] != 0) return this.dp[n];
		if (n <= 1) return n;
		
		this.dp[n] = getFibo(n-1) + getFibo(n-2);
		return this.dp[n];
	}
	public int getFibo_dp(int n) {
		this.dp = new int[n+1];
		return this.getFibo_dp_helper(n);
	}
	
	public int getFibo(int n) {
		if (n <= 1) return n;
		
		return getFibo(n-1) + getFibo(n-2);
	}
	
	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		
//		for (int i=0; i<10; i++) {
//			System.out.println(i + " = " + f.getFibo(i));
//		}
		for (int i=0; i<10; i++) {
			System.out.println(i + " = " + f.getFibo_dp(i));
		}
	}
}
