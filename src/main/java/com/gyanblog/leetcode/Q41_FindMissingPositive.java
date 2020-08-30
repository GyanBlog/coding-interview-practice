package com.gyanblog.leetcode;

import java.util.Arrays;

import com.gyanblog.utils.ArrayUtils;

public class Q41_FindMissingPositive {

	public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        
        Arrays.sort(nums);
        
        if (nums.length == 1) {
        	if (nums[0] <= 0 || nums[0] > 1) return 1;
        	
        	else return nums[0] + 1; //2
        }
        if (nums[nums.length-1] == 1) return 2;
        
        int startIndex = 0;
        while (startIndex < nums.length && nums[startIndex] <= 0) {
        	startIndex ++;
        }

        if (startIndex == nums.length) {
        	//reached end
        	if (nums[startIndex-1] > 1) return 1;
        	if (nums[startIndex-1] < 0) return 1;
        	
        	return nums[startIndex-1] + 1;
        }
        
        //got first positive number
        if (nums[startIndex] > 1) return 1;
        
        //check last number, if there is no missing number
//        if (nums[nums.length-1] == (nums[startIndex] + nums.length - startIndex - 1)) {
//        	return nums[nums.length - 1] + 1;
//        }
        
        int l = startIndex;
        int r = nums.length - 1;
        while (l <= r) {
        	int m = (l+r)/2;
        	
        	int offset = m - l;//m == l ? (m - l) : (m - l - 1);
        	if (nums[m] <= (nums[l] + offset)) {
        		//left to mid is OK
        		
        		//now that we are going to right, just check mid and next element
        		if (l+1 <= r && nums[l+1] - nums[m] > 1) {
        			return nums[m] + 1;
        		}
        		
        		l = m + 1;
        	}
        	else { //if (nums[m] > (nums[l] + m - l - 1)) {
        		r = m;
        	}
        }
        
        return 1;
    }
	
	public static void main(String[] args) {
		int[][] nums = {
//				{1, 1},
//				{2, 2},
				{1, 2, 2, 3, 4, 6},
				{1, 2, 0},
				{3, 4, -1, 1},
				{7,8,9,11,12},
				{2},
				{0, 1},
				{1, 2},
				{2, 3},
				{1, 3, 5},
				{},
				{100, 101},
				{-1, -2}
		};
		for (int[] num : nums) {
			Q41_FindMissingPositive q = new Q41_FindMissingPositive();
			int res = q.firstMissingPositive(num);
			
//			System.out.println("~~~~~~~~~~~~~~~~~~~");
			System.out.println(ArrayUtils.toString(num) + " -> " + res);
		}
	}
}
