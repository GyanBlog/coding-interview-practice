package com.gyanblog.leetcode;

import java.util.Arrays;

public class Q16_ClosestThreeSum {

	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		
		int l = nums.length;
		int minDiff = Integer.MAX_VALUE;
		int result = 0;
		for (int i=0; i<l; i++) {
			int j=i+1;
			int k=l-1;
			
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == target) return sum;
				else if (sum < target) j++;
				else k--;
				
				if (Math.abs(target - sum) < minDiff) {
					minDiff = Math.abs(target - sum);
					result = sum;
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Q16_ClosestThreeSum q = new Q16_ClosestThreeSum();
		
		int[] nums = {-1, 2, 1, -4};
		int sum = q.threeSumClosest(nums, 1);
		System.out.println(sum);
	}
}
