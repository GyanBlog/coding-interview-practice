package com.gyanblog.leetcode;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * 
 * Explanation: https://www.gyanblog.com/gyan/coding-interview/check-palindrome/ 
 */
public class Q9_Palindrome {

	private int reverseInt(int x) {
		int s = 0;
		while (x > 0) {
			s = s*10 + x%10;
			x = x/10;
		}
		return s;
	}
	
    public boolean isPalindrome_1(int x) {
    	if (x < 0) return false;
    	return x == this.reverseInt(x);
    }
    
    /**
     * Example: 1234
     * place=0, result=4
     * place=1, result=3
     */
    private int getDigit(int x, int place) {
    	x = x / (int)Math.pow(10, place);
    	return x % 10;
    }
    
    public boolean isPalindrome_2(int x) {
    	if (x < 0) return false;
    	int l = 0;
    	int temp = x;
    	while (temp > 0) {
    		l++;
    		temp /= 10;
    	}
    	
    	for (int i=0; i<l; i++) {
    		if (this.getDigit(x, i) != this.getDigit(x, l-1-i)) {
    			return false;
    		}
    	}
    	return true;
    }
	
	public static void main(String[] args) {
		Q9_Palindrome q7 = new Q9_Palindrome();
		
		int x = 1234;
		System.out.println(x + " - " + q7.isPalindrome_1(x));
		System.out.println(x + " - " + q7.isPalindrome_2(x));
		
		x = 121;
		System.out.println(x + " - " + q7.isPalindrome_1(x));
		System.out.println(x + " - " + q7.isPalindrome_2(x));
		
		x = 1221;
		System.out.println(x + " - " + q7.isPalindrome_1(x));
		System.out.println(x + " - " + q7.isPalindrome_2(x));
		
		x = -121;
		System.out.println(x + " - " + q7.isPalindrome_1(x));
		System.out.println(x + " - " + q7.isPalindrome_2(x));
	}
}
