package com.gyanblog.leetcode;

public class Q5_LongestPalindromeSubstring_Simple {
	private String str;
	
	public Q5_LongestPalindromeSubstring_Simple(String str) {
		this.str = str;
	}
	
	private boolean isPalindrome(String s) {
		int lastIndex = s.length()-1;
		int startIndex = 0;
		while (startIndex < s.length() && lastIndex >= 0) {
			if (s.charAt(startIndex) != s.charAt(lastIndex)) {
				return false;
			}
			startIndex ++;
			lastIndex --;
		}
		return true;
	}
	
	public String longestPalindrome() {
		String max = "";
		
		//generate all substrings
		for (int i=0; i<this.str.length(); i++) {
			for (int j=i+1; j<this.str.length(); j++) {
				String substring = this.str.substring(i, j);
				if (this.isPalindrome(substring)) {
					if (max.length() < substring.length()) {
						max = substring;
					}
				}
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		String str = "cbbd";
		Q5_LongestPalindromeSubstring_Simple s = new Q5_LongestPalindromeSubstring_Simple(str);
		
		System.out.println(s.longestPalindrome());
	}
}
