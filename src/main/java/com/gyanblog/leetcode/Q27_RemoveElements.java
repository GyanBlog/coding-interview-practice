package com.gyanblog.leetcode;

public class Q27_RemoveElements {

	public int removeElement(int[] nums, int val) {
        int l = nums.length;
        
        int j=-1;
        for (int i=0; i<l; i++) {
            if (nums[i] != val) {
                j++;
                nums[j] = nums[i];
            }
        }
        
        return j+1;
    }
}
