package com.gyanblog.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem-3
 *  Given a string, find the length of the longest substring without repeating characters.

    Example 1:
    Input: "abcabcbb"
    Output: 3 

    Example 2:
    Input: "bbbbb"
    Output: 1

    Example 3:
    Input: "pwwkew"
    Output: 3

    For explanation see: https://www.gyanblog.com/gyan/coding-interview/leetcode-solution-longest-substring-without-repeating/
 */
public class Q3_LongestSubstring_MoreOptimizedSolution {
    private String str;
    public Q3_LongestSubstring_MoreOptimizedSolution(String str) {
        this.str = str;
    }

    public String getResult() {
        Map<Character, Integer> map = new HashMap<>();
        int l = this.str.length();
        int i=0; int j=0;
        String maxStr = "";

        for (; j<l; j++) {
            if (map.containsKey(this.str.charAt(j))) {
                i = Math.max(map.get(this.str.charAt(j)), i);
            }

            if (j-i+1 > maxStr.length()) {
                maxStr = this.str.substring(i, j+1);
            }

            map.put(this.str.charAt(j), j+1);
        }

        return maxStr;
    }

    public static void main(String[] args) {
        Q3_LongestSubstring_MoreOptimizedSolution ss = new Q3_LongestSubstring_MoreOptimizedSolution("pwwkew");

        String result = ss.getResult();
        System.out.println("Longest substring without repeating chars: " + result);
        System.out.println("Length: " + result.length());
    }
}