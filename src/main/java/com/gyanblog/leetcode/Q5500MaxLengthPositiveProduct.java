package com.gyanblog.leetcode;

public class Q5500MaxLengthPositiveProduct {

	public int getMaxLen2(int[] nums) {
		int max = 0;
		
		int firstNegativeIndex = -1;
		int negativeCount = 0;
		
		int zeroIndex = -1;
		
		for (int i=0; i<nums.length; i++) {
			if (nums[i] < 0) {
				negativeCount ++;
				if (firstNegativeIndex == -1) {
					firstNegativeIndex = i;
				} 
			}
			
			if (nums[i] == 0) {
				firstNegativeIndex = -1;
				negativeCount = 0;
				zeroIndex = i;
			}
			else {
				if (negativeCount % 2 == 0) {
					max = Math.max(max, i-zeroIndex);
				}
				else {
					//1, 2, -1, -1, -1
					max = Math.max(max, i-firstNegativeIndex);
				}
			}
		}
		return max;
    }
	
	public int getMaxLen(int[] nums) {
		int max = 0;
		
		int firstNegativeIndex = -1;
		int negativeCount = 0;
		
		int zeroIndex = -1;
		
		for (int i=0; i<nums.length; i++) {
			//{-1,-2,-3,0,1};
			if (nums[i] < 0) {
				negativeCount ++;
				if (firstNegativeIndex == -1) {
					firstNegativeIndex = i;
				} 
				else {
					if (negativeCount % 2 == 0) {
						max = Math.max(max, i-zeroIndex);
					}
				}
			}
			else if (nums[i] == 0) {
				firstNegativeIndex = -1;
				negativeCount = 0;
				zeroIndex = i;
			}
			else {
				if (negativeCount % 2 == 0) {
					max = Math.max(max, i-zeroIndex);
				}
				else {
					max = Math.max(max, i-firstNegativeIndex);
				}
			}
		}
		
		
		return max;
    }
	
	public static void main(String[] args) {
		System.out.println("Test-1 status=" + (test1() ? "pass" : "fail"));
		System.out.println("Test-2 status=" + (test2() ? "pass" : "fail"));
		System.out.println("Test-3 status=" + (test3() ? "pass" : "fail"));
		System.out.println("Test-4 status=" + (test4() ? "pass" : "fail"));
		System.out.println("Test-5 status=" + (test5() ? "pass" : "fail"));
	}
	
	public static boolean test1() {
		Q5500MaxLengthPositiveProduct q = new Q5500MaxLengthPositiveProduct();
		int[] arr = {1,-2,-3,4};
		
		//must contains
		return q.getMaxLen(arr) == 4;
	}
	
	public static boolean test2() {
		Q5500MaxLengthPositiveProduct q = new Q5500MaxLengthPositiveProduct();
		int[] arr = {0,1,-2,-3,-4};
		
		//must contains
		return q.getMaxLen(arr) == 3;
	}
	
	public static boolean test3() {
		Q5500MaxLengthPositiveProduct q = new Q5500MaxLengthPositiveProduct();
		int[] arr = {-1,-2,-3,0,1};
		
		//must contains
		return q.getMaxLen(arr) == 2;
	}
	
	public static boolean test4() {
		Q5500MaxLengthPositiveProduct q = new Q5500MaxLengthPositiveProduct();
		int[] arr = {-1,2};
		
		//must contains
		return q.getMaxLen(arr) == 1;
	}
	
	public static boolean test5() {
		Q5500MaxLengthPositiveProduct q = new Q5500MaxLengthPositiveProduct();
		int[] arr = {1,2,3,5,-6,4,0,10};
		
		//must contains
		return q.getMaxLen(arr) == 4;
	}
}
