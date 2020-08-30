package com.gyanblog.leetcode;

public class Q33_SearchRotatedArray {

	public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
        	int m = (l+r)/2;
        	if (nums[m] == target) return m;
        	
        	if (nums[l] <= nums[m]) {
        		//left sorted
        		if (target >= nums[l] && target <= nums[m]) {
        			r = m - 1;
        		}
        		else {
        			l = m + 1;
        		}
        	}
        	else {
        		//right sorted
        		if (target >= nums[m] && target <= nums[r]) {
        			l = m + 1;
        		}
        		else {
        			r = m - 1;
        		}
        	}
        }
        
        return -1;
    }
	
	public static void main(String[] args) {
		int[] arr = {4,5,6,7,0,1,2};
		int search = 5;
		
		Q33_SearchRotatedArray q = new Q33_SearchRotatedArray();
		int idx = q.search(arr, search);
		System.out.println(idx);
	}
}
