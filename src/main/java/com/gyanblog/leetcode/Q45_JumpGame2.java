package com.gyanblog.leetcode;

public class Q45_JumpGame2 {

	private int min = Integer.MAX_VALUE;

	public int jump(int[] nums) {
		if (nums.length == 0) return 0;
		
        int[] jumps = new int[nums.length];
        jumps[0] = 0;
        
        for (int i=1; i<nums.length; i++) {
        	jumps[i] = Integer.MAX_VALUE;
        	for (int j=0; j<i; j++) {
        		if (j + nums[j] >= i && jumps[j] != Integer.MAX_VALUE) {
        			jumps[i] = Math.min(jumps[i], 1 + jumps[j]);
        			break;
        		}
        	}
        }
        
        return jumps[nums.length-1];
    }
	
	public int jump_bruteforce(int[] nums) {
        return this.jump(nums, 0, 0);
    }
	private int jump(int[] nums, int index, int jumps) {
		//reached
		if (nums.length-1 == index) return jumps;

		for (int i=1; index<nums.length && i<=nums[index]; i++) {
			int mJump = jump(nums, index + i, jumps + 1);

			this.min = Math.min(this.min, mJump);
		}

		return this.min;
	}

	public static void main(String[] args) {
		int[] nums = {5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5};
		Q45_JumpGame2 q = new Q45_JumpGame2();
		int res = q.jump(nums);
		System.out.println(res);
	}
}

