package com.gyanblog.leetcode;

public class Q38CountAndSay {

	private String getNext(String str) {
		int count = 1;
		char ch = str.charAt(0);
		StringBuffer sb = new StringBuffer();
		
		for (int i=1; i<str.length(); i++) {
			if (ch == str.charAt(i)) {
				count ++;
			}
			else {
				sb.append(count).append(ch);
				ch = str.charAt(i);
				count = 1;
			}
		}
		sb.append(count).append(ch);
		
		return sb.toString();
	}
	
	public String countAndSay(int n) {
		if (n == 1) {
			return "1";
		}
		
		String next = this.countAndSay(n-1);
		String res = this.getNext(next);
		System.out.println(n + "-" + res);
		return res;
    }
	
	public static void main(String[] args) {
		int n = 30;
		Q38CountAndSay q = new Q38CountAndSay();
		String res = q.countAndSay(n);
		System.out.println(res);
	}
}
