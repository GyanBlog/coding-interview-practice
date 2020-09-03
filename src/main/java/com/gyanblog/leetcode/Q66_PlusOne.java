package com.gyanblog.leetcode;

import com.gyanblog.utils.ArrayUtils;

public class Q66_PlusOne {
	
	public int[] plusOne(int[] digits) {
        int l = digits.length;
        
        //initializing carry with the number we want to add for first time.
        int carry = 1;
        
        for (int i=l-1; i>=0; i--) {
        	digits[i] = digits[i] + carry;
        	
        	carry = digits[i]/10;
        	digits[i] = digits[i]%10;
        }
        int targetSize = carry == 1 ? l+1 : l;
        int[] res = new int[targetSize];
        
        int i=0;
        if (carry == 1) {
        	res[0] = carry;
        	i = 1;
        }
        for (; i<targetSize; i++) {
        	res[i] = digits[i-carry];
        }
        return res;
    }

	public static void main(String[] args) {
		System.out.println("Test-1 status=" + (test1() ? "pass" : "fail"));
		System.out.println("Test-2 status=" + (test2() ? "pass" : "fail"));
		System.out.println("Test-3 status=" + (test3() ? "pass" : "fail"));
		System.out.println("Test-4 status=" + (test4() ? "pass" : "fail"));
	}
	
	public static boolean test1() {
		Q66_PlusOne q = new Q66_PlusOne();
		
		int[] arr = {1,2,3};
		
		//must contains
		int[] res = q.plusOne(arr);
		return ArrayUtils.compareArray(res, new int[] {1,2,4}, res.length);
	}
	public static boolean test2() {
		Q66_PlusOne q = new Q66_PlusOne();
		
		int[] arr = {4,3,2,1};
		
		//must contains
		int[] res = q.plusOne(arr);
		return ArrayUtils.compareArray(res, new int[] {4,3,2,2}, res.length);
	}
	
	public static boolean test3() {
		Q66_PlusOne q = new Q66_PlusOne();
		
		int[] arr = {4,3,2,9};
		
		//must contains
		int[] res = q.plusOne(arr);
		return ArrayUtils.compareArray(res, new int[] {4,3,3,0}, res.length);
	}
	
	public static boolean test4() {
		Q66_PlusOne q = new Q66_PlusOne();
		
		int[] arr = {9,9,9,9};
		
		//must contains
		int[] res = q.plusOne(arr);
		return ArrayUtils.compareArray(res, new int[] {1,0,0,0,0}, res.length);
	}
}
