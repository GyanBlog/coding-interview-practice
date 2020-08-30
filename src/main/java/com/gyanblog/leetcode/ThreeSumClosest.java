package com.gyanblog.leetcode;

import java.util.Arrays;

public class ThreeSumClosest {

	public int threeSumClosest(int[] nums, int target) {
		int l = nums.length;
		int res = nums[0] + nums[1] + nums[2];
		for (int i=0; i<l; i++) {
			for (int j=i+1; j<l; j++) {
				for (int k=j+1; k<l; k++) {
					int s = nums[i] + nums[j] + nums[k];
					if (Math.abs(target-s) < Math.abs(target-res)) {
						res = s;
					}
				}
			}
		}
		return res;
    }
	
	public int threeSumClosest2(int[] nums, int target) {
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
		int[] nums = {-1,2,1,-4};
		int target = 1;
		
		ThreeSumClosest sum = new ThreeSumClosest();
		int res = sum.threeSumClosest2(nums, target);
		System.out.println(res);
	}
}
