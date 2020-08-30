package com.gyanblog.leetcode;

public class Q28_StrStr {

	public int strStr3(String haystack, String needle) {
        int l = haystack.length();
        int nl = needle.length();
        
        if (l == 0 && nl == 0) return 0;
        if (nl == 0) return 0;
        
        for (int i=0; (i+nl)<=l; i++) {
        	if (needle.equals(haystack.substring(i, i+nl))) {
        		return i;
        	}
        }
        return -1;
    }
	
	public int strStr(String haystack, String needle) {
        int l = haystack.length();
        int nl = needle.length();
        
        if (l == 0 && nl == 0) return 0;
        if (nl == 0) return 0;
        
        int j=0;
        for (int i=0; i<l; i++) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                int pos = this.helper(haystack, i, l, needle, nl);
                if (pos >= 0) return pos;
            }
            else {
                j = 0;
            }
        }
        return -1;
    }
    
    private int helper(String haystack, int startIndex, int hayLen, String needle, int nLen) {
        if ((hayLen-startIndex) < nLen) return -1;
        
        int resIndex = -1;
        int j=0;
        for (int i=startIndex; i<hayLen; i++) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (resIndex == -1) {
                    resIndex = i;
                }
                j++;
                
                if (j == nLen) {
                    return resIndex;
                }
            }
            else {
            	//lets return from here, no need to check further. Outer function is doing it.
                return -1;
            }
        }
        
        return -1;
    }
    
    public int strStr2(String haystack, String needle) {
        int l = haystack.length();
        int nl = needle.length();
        
        if (l == 0 && nl == 0) return 0;
        if (nl == 0) return 0;
        
        int j=0;
        for (int i=0; i<l; i++) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                int pos = this.helper2(haystack, i, l, needle, nl);
                if (pos >= 0) return pos;
            }
            else {
                j = 0;
            }
        }
        return -1;
    }
    private int helper2(String haystack, int startIndex, int hayLen, String needle, int nLen) {
        if ((hayLen-startIndex) < nLen) return -1;

        if (needle.equals(haystack.substring(startIndex, startIndex + nLen))) {
        	return startIndex;
        }
        return -1;
    }
    
    public static void main(String[] args) {
		Q28_StrStr q = new Q28_StrStr();
		int pos = q.strStr3("mississippi", "issip");
		System.out.println(pos);
	}
}
