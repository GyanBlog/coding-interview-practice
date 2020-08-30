package com.gyanblog.leetcode;

import com.gyanblog.utils.ArrayUtils;

public class Q189_RotateArray {

	public void rotate_simple(int[] nums, int k) {
        if (k==0) return;
        if (nums == null || nums.length == 0) return;
        
        for (int i=0; i<k; i++) {
        	int j=nums.length-1;
        	int temp = nums[j];
        	for (; j>0; j--) {
        		nums[j] = nums[j-1];
        	}
        	nums[0] = temp;
        }
    }
	
	public void rotate_extraspace(int[] nums, int k) {
		if (k==0) return;
		if (nums == null || nums.length == 0) return;
      
		int[] res = new int[nums.length];
		for (int i=0; i<nums.length; i++) {
			int newIndex = (i + k) % nums.length;
			res[newIndex] = nums[i];
		}
		
		//assign back to original array
		for (int i=0; i<nums.length; i++) {
			nums[i] = res[i];
		}
	}
	
	public void rotate(int[] nums, int k) {
		if (k==0) return;
        if (nums == null || nums.length == 0) return;
        
        int count = 0;
        for (int i=0; i<nums.length && count < nums.length; i++) {
        	
        	int currentIndex = i;
        	int newIndex = (currentIndex + k) % nums.length;
        	
        	int currentTemp = nums[currentIndex];
        	int nextTemp;
        	
        	while (newIndex != i) {
        		nextTemp = nums[newIndex];
        		nums[newIndex] = currentTemp;
        		currentIndex = newIndex;
        		
        		newIndex = (currentIndex + k) % nums.length;
        		currentTemp = nextTemp;
        		
        		//how many replacements has been done
        		count ++;
        	}
        	//assign value from where we started
        	nums[newIndex] = currentTemp;
        	count ++;
        }
	}
	
	public static void main(String[] args) {
		System.out.println("Test-1 status=" + (test1() ? "pass" : "fail"));
		System.out.println("Test-2 status=" + (test2() ? "pass" : "fail"));
	}
	
	public static boolean test1() {
		Q189_RotateArray q = new Q189_RotateArray();
		int[] nums = {1,2,3,4,5,6,7};
		int k = 3;
		
		q.rotate(nums, k);
		return ArrayUtils.compareArray(nums, new int[] {5,6,7,1,2,3,4}, nums.length);
	}
	
	public static boolean test2() {
		Q189_RotateArray q = new Q189_RotateArray();
		int[] nums = {-1,-100,3,99};
		int k = 2;
		
		q.rotate(nums, k);
		return ArrayUtils.compareArray(nums, new int[] {3,99,-1,-100}, nums.length);
	}
}
