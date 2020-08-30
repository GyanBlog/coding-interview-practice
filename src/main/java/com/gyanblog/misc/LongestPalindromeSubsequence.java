package com.gyanblog.misc;

public class LongestPalindromeSubsequence {
	public static int longestP(String s, int l, int r) {
		if (l > r) return 0;
		if (l == r) return 1;
		
		if (s.charAt(l) == s.charAt(r)) {
			return 2 + longestP(s, l+1, r-1);
		}
		else {
			return Math.max(longestP(s, l+1, r), longestP(s, l, r-1));
		}
    }
	
	public static String longestPS(String s, int l, int r) {
		if (l > r) return "";
		if (l == r) return "" + s.charAt(l);
		
		if (s.charAt(l) == s.charAt(r)) {
			return s.charAt(l) + longestPS(s, l+1, r-1) + s.charAt(r);
		}
		else {
			String one = longestPS(s, l+1, r);
			String two = longestPS(s, l, r-1);
			if (one.length() > two.length()) return one;
			return two;
		}
    }
	
	public static void main(String[] args) {
		String s = "character";
		
		System.out.println(longestPS(s, 0, s.length()-1));
	}
}
