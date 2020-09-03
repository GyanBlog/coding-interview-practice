package com.gyanblog.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q217_ContainsDuplicate {

	public boolean containsDuplicate_bruteforce(int[] nums) {
		if (nums == null || nums.length == 0) return false;
		
		int l = nums.length;
		for (int i=0; i<l; i++) {
			for (int j=i+1; j<l; j++) {
				if (nums[i] == nums[j]) {
					return true;
				}
			}
		}
		return false;
    }
	
	//using extra memory
	public boolean containsDuplicate_extraMemory(int[] nums) {
		if (nums == null || nums.length == 0) return false;
		
		Set<Integer> set = new HashSet<>();
		int l = nums.length;
		for (int i=0; i<l; i++) {
			if (set.contains(nums[i])) {
				return true;
			}
			set.add(nums[i]);
		}
		return false;
	}
	
	//sorting
	public boolean containsDuplicate(int[] nums) {
		if (nums == null || nums.length == 0) return false;
		
		Arrays.sort(nums);
		int l = nums.length;
		for (int i=1; i<l; i++) {
			if (nums[i-1] == nums[i]) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println("Test-1 status=" + (test1() ? "pass" : "fail"));
		System.out.println("Test-2 status=" + (test2() ? "pass" : "fail"));
		System.out.println("Test-3 status=" + (test3() ? "pass" : "fail"));
	}
	
	public static boolean test1() {
		Q217_ContainsDuplicate q = new Q217_ContainsDuplicate();
		int[] arr = {1,2,3,1};
		
		//must contains
		return q.containsDuplicate(arr) == true;
	}
	public static boolean test2() {
		Q217_ContainsDuplicate q = new Q217_ContainsDuplicate();
		int[] arr = {1,2,3,4};
		
		//must contains
		return q.containsDuplicate(arr) == false;
	}
	public static boolean test3() {
		Q217_ContainsDuplicate q = new Q217_ContainsDuplicate();
		int[] arr = {1,1,1,3,3,4,3,2,4,2};
		
		//must contains
		return q.containsDuplicate(arr) == true;
	}
	
}
