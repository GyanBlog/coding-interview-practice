package com.gyanblog.leetcode;

public class Q5_LongestPalindromeSubstring_Optimized {
	private String str;
	
	public Q5_LongestPalindromeSubstring_Optimized(String str) {
		this.str = str;
	}
	
	private String findPalindrome(int startIndex, int endIndex) {
		String palindrome = "";
		while (startIndex >= 0 && endIndex < this.str.length() && this.str.charAt(startIndex) == this.str.charAt(endIndex)) {
			palindrome = this.str.substring(startIndex, endIndex+1);
			startIndex --;
			endIndex ++;
		}
		
		return palindrome;
	}
	
	public String longestPalindrome() {
		String max = "";

		for (int i=0; i<this.str.length()-1; i++) {
			String s1 = this.findPalindrome(i, i);
			String s2 = this.findPalindrome(i,  i+1);
			
			String maxOfTwo = s1.length() > s2.length() ? s1 : s2;
			if (max.length() < maxOfTwo.length()) {
				max = maxOfTwo;
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		String str = "cbbd";
		Q5_LongestPalindromeSubstring_Optimized s = new Q5_LongestPalindromeSubstring_Optimized(str);
		
		System.out.println(s.longestPalindrome());
	}
}
