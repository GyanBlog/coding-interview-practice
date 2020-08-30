package com.gyanblog.leetcode;

import java.util.Arrays;

import com.gyanblog.utils.ArrayUtils;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

4 3 2 5 4 -> 43425
4 3 2 6 5 4 -> 434256
1 1 5 -> 1 5 1
2 2 5 1 -> 2 5 1 2 
 *
 */
public class Q31_NextPermutation {

	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length == 0) return;
		
		//check if next largest not possible. Return sorted one
		boolean possible = false;
		int l = nums.length;
		for (int i=0; i<l-1; i++) {
			if (nums[i] < nums[i+1]) {
				possible = true;
				break;
			}
		}
		
		if (!possible) {
			System.out.println("Next largest not possible. Getting minimum...");
			Arrays.sort(nums);
			return;
		}
		
		//possible, lets find out
		
		boolean done = false;
		for (int i=l-1; i>0; i--) {
			if (nums[i] > nums[i-1]) {
				//found point
				
				//search in right side for next largest than this digit
				int minLargestIdx = i;
				for (int j=minLargestIdx+1; j<l; j++) {
					if (nums[j] > nums[i-1] && nums[minLargestIdx] > nums[j]) {
						minLargestIdx = j;
					}
				}
				
				//swap
				this.swap(nums, i-1, minLargestIdx);
				
				//sort
				Arrays.sort(nums, i, l);
				
				done = true;
				break;
			}
			
			if (done) break;
		}
    }
	
	private void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}
	
	public static void main(String[] args) {
		Q31_NextPermutation q = new Q31_NextPermutation();
		
		int[] nums = {4,2,0,2,3,2,0}; 

		System.out.println(ArrayUtils.toString(nums));
		q.nextPermutation(nums);
		System.out.println(ArrayUtils.toString(nums));
	}
}

