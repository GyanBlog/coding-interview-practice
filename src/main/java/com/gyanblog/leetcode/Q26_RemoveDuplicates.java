package com.gyanblog.leetcode;

import com.gyanblog.utils.ArrayUtils;

public class Q26_RemoveDuplicates {
	
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int num = nums[0];
		int j=1;
		
		for (int i=1; i<nums.length; i++) {
			if (num != nums[i]) {
				num = nums[i];
				
				nums[j] = nums[i];
				j ++;
			}
		}
		
		return j;
    }
	
	public int removeDuplicates2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int j=1;
		for (int i=1; i<nums.length; i++) {
			if (nums[j-1]!= nums[i]) {
				nums[j]= nums[i];
				
				j ++;
			}
		}
		
		return j;
    }
	
	
	public static void main(String[] args) {
		System.out.println("Test-1 status=" + (test1() ? "pass" : "fail"));
		
		System.out.println("Test-2 status=" + (test2() ? "pass" : "fail"));
		
		System.out.println("Test-3 status=" + (test3() ? "pass" : "fail"));
	}
	
	public static boolean test1() {
		Q26_RemoveDuplicates q = new Q26_RemoveDuplicates();
		
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		int result = q.removeDuplicates2(nums);
		
		return result == 5 && ArrayUtils.compareArray(nums, new int[]{0,1,2,3,4}, result);
	}
	
	public static boolean test2() {
		Q26_RemoveDuplicates q = new Q26_RemoveDuplicates();
		
		int[] nums = {1,1,2};
		int result = q.removeDuplicates2(nums);
		return result == 2 && ArrayUtils.compareArray(nums, new int[]{1,2}, result);
	}
	public static boolean test3() {
		Q26_RemoveDuplicates q = new Q26_RemoveDuplicates();
		
		int[] nums = {1};
		int result = q.removeDuplicates2(nums);
		return result == 1 && ArrayUtils.compareArray(nums, new int[]{1}, result);
	}
}
