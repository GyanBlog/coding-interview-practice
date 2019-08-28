package com.gyanblog.leetcode;

/**
 * Implement atoi which converts a string to an integer.
 * 
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

	The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
	
	If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
	
	If no valid conversion could be performed, a zero value is returned.
	
	Note:
	
	    Only the space character ' ' is considered as whitespace character.
	    Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.


 * Explanation: https://www.gyanblog.com/gyan/coding-interview/leetcode-string-integer-atoi/
 *
 */
public class Q8_StringToInteger {

	public int myAtoi(String str) {
		int s = 0;
		boolean neg = false;
		boolean foundFirstValidInteger = false;
		int l = str.length();
		
		for (int i=0; i<l; i++) {
			char c = str.charAt(i);
			
			if (!foundFirstValidInteger) {
				if (c == ' ') continue;
				if (c == '+') {
					foundFirstValidInteger = true;
					continue;
				}
				if (c == '-') {
					foundFirstValidInteger = true;
					neg = true;
					continue;
				}
			}
			
			if (c >= '0' && c <= '9') {
				foundFirstValidInteger = true;
				int num = c - '0';
				
				if (s > Integer.MAX_VALUE/10 || (s == Integer.MAX_VALUE/10 && num > 7)) {
					if (neg) return Integer.MIN_VALUE;
					return Integer.MAX_VALUE;
				}
				s = s*10 + num;
			}
			else if (!foundFirstValidInteger) {
				return 0;
			}
			else {
				if (neg) return -s;
				
				System.out.println("debug 1");
				return s;
			}
		}
		
		if (neg) return -s;
		
		System.out.println("debug 2");
		return s;
	}
	
	public static void main(String[] args) {
		Q8_StringToInteger q7 = new Q8_StringToInteger();
		
		String str = "    -42";
		System.out.println("\"" + str + "\" -> " + q7.myAtoi(str));
		
		str = "42";
		System.out.println("\"" + str + "\" -> " + q7.myAtoi(str));
		
		str = "4193 with words";
		System.out.println("\"" + str + "\" -> " + q7.myAtoi(str));
		
		str = "words and 987";
		System.out.println("\"" + str + "\" -> " + q7.myAtoi(str));
		
		str = "-91283472332";
		System.out.println("\"" + str + "\" -> " + q7.myAtoi(str));
		
		str = "3.14159";
		System.out.println("\"" + str + "\" -> " + q7.myAtoi(str));
		
		str = "+-2";
		System.out.println("\"" + str + "\" -> " + q7.myAtoi(str));
		
		str = "  -0012a42";
		System.out.println("\"" + str + "\" -> " + q7.myAtoi(str));
		
		str = "2147483648";
		System.out.println("\"" + str + "\" -> " + q7.myAtoi(str));
	}
}
