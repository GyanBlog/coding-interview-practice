package com.gyanblog.misc;

public class Test {

	public static int count(int rem, int denom) {
		if (rem <= 0) return 0;
		int nd = 0;
		switch(denom) {
		case 7:
			nd = 3;
			break;
		case 3:
			nd = 2;
			break;
		case 2:
			return 1;
		}
		
		int ways = 0;
		for (int i=0; i*denom < rem; i++) {
			ways += count(rem - i*denom, nd);
		}
		
		return ways;
	}
	
	public static void main(String[] args) {
		System.out.println(count(12, 7));
	}
}
