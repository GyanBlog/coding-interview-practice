package com.gyanblog.leetcode;

public class Q35_SearchInsertPos {

	public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        
        int l = 0;
        int r = nums.length-1;
        int pos = 0;
        while (l <= r) {
        	int m = (l+r)/2;
        	if (nums[m] == target) return m;
        	
        	if (target < nums[m]) {
        		if (m-1 < 0) {
        			return 0;
        		}
        		if (m-1 >= 0 && nums[m-1] < target) {
        			return m;
        		}
        		r = m-1;
        	}
        	else {
        		if (m+1 == nums.length) {
        			return nums.length;
        		}
        		if (m+1 < nums.length && target < nums[m+1]) {
        			return m+1;
        		}
        		l = m + 1;
        	}
        }
        
        return pos;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,3,5,6};
		int target = 2;
		
		Q35_SearchInsertPos q = new Q35_SearchInsertPos();
		int res = q.searchInsert(nums, target);
		System.out.println(res);
	}
}
