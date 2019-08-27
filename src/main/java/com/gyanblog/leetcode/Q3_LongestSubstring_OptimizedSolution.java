package com.gyanblog.leetcode;

import java.util.HashSet;
import java.util.Set;

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
public class Q3_LongestSubstring_OptimizedSolution {
    private String str;
    
    public Q3_LongestSubstring_OptimizedSolution(String str) {
       this.str = str;
    }

    public String getResult() {
      int l = this.str.length();
      Set<Character> set = new HashSet<>();
      int i=0;
      int j=0;
      String maxStr = "";

      while (i < l && j < l) {
         if (!set.contains(this.str.charAt(j))) {
            set.add(this.str.charAt(j));
            j++;
            String s = this.str.substring(i, j);
            if (s.length() > maxStr.length()) {
               maxStr = s;
            }
         }
         else {
            set.remove(this.str.charAt(i));
            i++;
         }
      }

      return maxStr;
    }

    public static void main(String[] args) {
       String str = "pwwkew";
       Q3_LongestSubstring_OptimizedSolution ss = new Q3_LongestSubstring_OptimizedSolution(str);

       String result = ss.getResult();
       System.out.println("Longest substring without repeating chars: " + result);
       System.out.println("Length: " + result.length());
    }
}