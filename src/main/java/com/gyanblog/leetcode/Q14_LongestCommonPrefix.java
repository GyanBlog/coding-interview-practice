package com.gyanblog.leetcode;

public class Q14_LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
        int strsLen = strs.length;
        if (strsLen == 0) {
            return "";
        }
        int l = strs[0].length();
        
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<l; i++) {
            char ch = strs[0].charAt(i);
            boolean matched = true;
            for (int j=1; j<strsLen; j++) {
                if (i >= strs[j].length() || ch != strs[j].charAt(i)) {
                    matched = false;
                    break;
                }
            }
            if (!matched) {
                break;
            }
            sb.append(ch);
        }
        
        return sb.toString();
    }
	
	
	
	public static void main(String[] args) {
		String[] arr = {"flower","flow","flight"};
		
		Q14_LongestCommonPrefix q = new Q14_LongestCommonPrefix();
		String res = q.longestCommonPrefix(arr);
		System.out.println(res);
	}
}
