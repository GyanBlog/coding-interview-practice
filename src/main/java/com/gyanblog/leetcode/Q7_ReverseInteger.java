package com.gyanblog.leetcode;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.

	Example 1:
	
	Input: 123
	Output: 321
 *
 * For explanation: https://www.gyanblog.com/gyan/coding-interview/leetcode-reverse-integer/
 */
public class Q7_ReverseInteger {
	
	public int reverse(int x) {
		boolean neg = false;
		if (x < 0) {
			//negative number
			neg = true;
			x = -x;
		}
		int s = 0;
		while (x > 0) {
			int rem = x%10;
			
			if (s > Integer.MAX_VALUE/10 || (s == Integer.MAX_VALUE/10 && rem > 7)) {
				return 0;
			}
			
			s = s*10 + rem;
			
			x = x/10;
		}
		
		if (neg) {
			return -s;
		}
		return s;
	}
	
	public static void main(String[] args) {
		Q7_ReverseInteger q7 = new Q7_ReverseInteger();
		
		int x = 1234;
		System.out.println("Reverse of " + x + "=" + q7.reverse(x));
		
		x = 1534236469;
		System.out.println("Reverse of " + x + "=" + q7.reverse(x));
		
		x = -1256;
		System.out.println("Reverse of " + x + "=" + q7.reverse(x));
	}
}
