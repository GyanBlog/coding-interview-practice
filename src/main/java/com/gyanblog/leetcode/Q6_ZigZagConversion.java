package com.gyanblog.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)

	P   A   H   N
	A P L S I I G
	Y   I   R

	And then read line by line: "PAHNAPLSIIGYIR"
 *
 * For explanation: https://www.gyanblog.com/gyan/coding-interview/leetcode-zigzag-pattern/
 */
public class Q6_ZigZagConversion {
	private String str;
	
	public Q6_ZigZagConversion(String str) {
		this.str = str;
	}
	
	public String conversion(int numRows) {
		int l = this.str.length();
		List<StringBuffer> zigzag = new ArrayList<StringBuffer>();
		for (int i=0; i<numRows; i++) {
			zigzag.add(new StringBuffer());
		}
		
		boolean comingFromTop = true;
		int zig = 0;
		for (int i=0; i<l; i++) {
			zigzag.get(zig).append(this.str.charAt(i));
			
			if (zig == numRows-1) {
				comingFromTop = false;
			}
			else if (zig == 0) {
				comingFromTop = true;
			}
			zig = comingFromTop ? zig + 1 : zig - 1;
			zig = zig % numRows;
		}
		
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<numRows; i++) {
			sb.append(zigzag.get(i));
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String str = "PAYPALISHIRING";
		Q6_ZigZagConversion q = new Q6_ZigZagConversion(str);
		
		System.out.println(q.conversion(3));
		
		System.out.println("~~~~~~~~~~~~~~~~~");
		System.out.println(q.conversion(4));
	}
}
