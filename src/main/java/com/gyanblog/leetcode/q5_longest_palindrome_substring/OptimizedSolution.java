package com.gyanblog.leetcode.q5_longest_palindrome_substring;

public class OptimizedSolution {
    private String str;
    public OptimizedSolution(String str) {
        this.str = str;
    }

    private String expand(int left, int right) {
        while (left >=0 && right < this.str.length() && this.str.charAt(left) == this.str.charAt(right)) {
            left--;
            right++;
        }
        return this.str.substring(left, right);
    }

    public String getLongestPalindromeSubstring() {
        String maxStr = "";
        for (int i=0; i<this.str.length(); i++) {
            String s1 = this.expand(i, i);
            String s2 = this.expand(i, i+1);
            
            String max = s1.length() > s2.length() ? s1 : s2;
            if (maxStr.length() < max.length()) {
                maxStr = max;
            }
        }

        return maxStr;
    }

    public static void main(String[] args) {
        String s = "abac";
        OptimizedSolution os = new OptimizedSolution(s);
        System.out.println("Result: " + os.getLongestPalindromeSubstring());
    }
}