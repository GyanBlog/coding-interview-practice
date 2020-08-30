package com.gyanblog.leetcode;

import com.gyanblog.utils.ArrayUtils;

public class Q34_FindFirstLastPosition {

	public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
        	return new int[]{-1, -1};
        }
        
        int start = -1;
        int end = -1;
        
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
        	int m = (l + r) / 2;
        	if (nums[m] == target) {
        		int t = m;
        		while (m >= 0 && nums[m] == target) {
        			m--;
        		}
        		start = m+1;
        		
        		while (t < nums.length && nums[t] == target) {
        			t++;
        		}
        		end = t-1;
        		
        		break;
        	}
        	else if (target > nums[m]) {
        		l = m + 1;
        	}
        	else if (target < nums[m]) {
        		r = m - 1;
        	}
        }
        
        return new int[]{start, end};
    }
	
	public static void main(String[] args) {
		int[] arr = {5,7,7,8,8,10};
		int target = 7;
		
		Q34_FindFirstLastPosition q = new Q34_FindFirstLastPosition();
		int[] pos = q.searchRange(arr, target);
		System.out.println(ArrayUtils.toString(pos));
	}
}
