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
public class Q3_LongestSubstring_SimpleSolution {
    private String str;
    
    public Q3_LongestSubstring_SimpleSolution(String str) {
       this.str = str;
    }

    private Set<String> getAllUniqueSubstrings() {
       Set<String> res = new HashSet<>();

       int l = this.str.length();
       for (int i=0; i<l; i++) {
          for (int j=i+1; j<l; j++) {
            res.add(this.str.substring(i, j));
          }
       }

       return res;
    }

    //Checks if the string is having unique characters
    private boolean isUniqueChars(String substring) {
      Set<Character> chars = new HashSet<>();
      int l = substring.length();
      
      for (int i=0; i<l; i++) {
         if (chars.contains(substring.charAt(i))) {
            return false;
         }
         chars.add(substring.charAt(i));
      }
      return true;
    }

    public String getResult() {
      //Get all substrings
      Set<String> substrings = this.getAllUniqueSubstrings();

      //check their lengths, and return string with highest length
      String result = null;
      int maxLen = 0;
      for (String substring : substrings) {
         if (this.isUniqueChars(substring)) {
            if (substring.length() > maxLen) {
               result = substring;
               maxLen = substring.length();
            }
         }
      }

      return result;
    }

    public static void main(String[] args) {
       String str = "pwwkew";
       Q3_LongestSubstring_SimpleSolution ss = new Q3_LongestSubstring_SimpleSolution(str);

       String result = ss.getResult();
       System.out.println("Longest substring without repeating chars: " + result);
       System.out.println("Length: " + result.length());
    }
}