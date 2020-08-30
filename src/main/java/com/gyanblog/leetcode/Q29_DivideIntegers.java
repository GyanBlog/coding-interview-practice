package com.gyanblog.leetcode;

public class Q29_DivideIntegers {

//	public int divide(int dividend, int divisor) {
//		if (divisor == 1) return dividend;
//		if (divisor == Integer.MIN_VALUE) return Integer.MAX_VALUE;
//
//		boolean divNeg = divisor < 0;
//		boolean isNeg = dividend < 0;
//		boolean oneMinus = false;
//
//		if (dividend == Integer.MIN_VALUE && divisor == 1) {
//			return Integer.MIN_VALUE;
//		}
//		if (dividend == Integer.MIN_VALUE && divisor == -1) {
//			return Integer.MAX_VALUE;
//		}
//		//dividend is neg max. Means, if I will convert it to positive number, it will be integer overflow
//		if (dividend == Integer.MIN_VALUE) {
//			//lets have number - 1
//			dividend = Integer.MAX_VALUE;
//			oneMinus = true;
//		}
//
//		if (divNeg) {
//			divisor = Math.abs(divisor);
//		}
//		if (isNeg) {
//			dividend = Math.abs(dividend);
//		}
//		
//		int result = 0;
//		
//		while (dividend >= divisor) {
//			int count = 0;
//			while (dividend >= (divisor << count) && ((divisor << count) >= divisor)) {
//				count ++;
//			}
//			count --;
//			
//			dividend = dividend - (divisor << count);
//			result += (1 << count);
//			
//			if (oneMinus) {
//				//add 1 which was decremented earlier.
//				dividend ++;
//				oneMinus = false;
//			}
//		}
//		
//		if (divNeg && isNeg) return result;
//		if (divNeg || isNeg) return -result;
//		return result;
//	}
//	
//	public static void main(String[] args) {
//		Q29_DivideIntegers q = new Q29_DivideIntegers();
//		
//		int dividend = -1010369383;
//		int divisor = -2147483648;
//		int res = q.divide(dividend, divisor);
//		System.out.println("Result:        " + res);
//		System.out.println("Actual Result: " + dividend / divisor);
//		
//	}
}

