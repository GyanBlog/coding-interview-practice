package com.gyanblog.leetcode;

import com.gyanblog.utils.ArrayUtils;

public class Q283_MoveZeroes {

	public void moveZeroes_simple(int[] nums) {
		int left=0;
		
		for (int i=0; i<nums.length; i++) {
			if (nums[i] != 0) {
				nums[left] = nums[i];
				left ++;
			}
		}
		
		for (int i=left; i<nums.length; i++) {
			nums[i] = 0;
		}
    }
	
	public void moveZeroes(int[] nums) {
		int left=0;
		
		for (int i=0; i<nums.length; i++) {
			if (nums[i] != 0) {
				//swap
				int t = nums[i];
				nums[i] = nums[left];
				nums[left] = t;
				
				left ++;
			}
		}
    }
	
	public static void main(String[] args) {
		System.out.println("Test-1 status=" + (test1() ? "pass" : "fail"));
	}
	
	public static boolean test1() {
		Q283_MoveZeroes q = new Q283_MoveZeroes();
		
		int[] arr = {0,1,0,3,12};
		
		//must contains
		q.moveZeroes(arr);
		return ArrayUtils.compareArray(arr, new int[] {1,3,12,0,0}, arr.length);
	}
}
