package com.gyanblog.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q136_SingleNumber {

	public int singleNumber_extraMemory(int[] nums) {
        int l = nums.length;
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<l; i++) {
        	Integer count = map.get(nums[i]);
        	if (count == null) {
        		count = 1;
        	}
        	else {
        		count ++;
        	}
        	
        	map.put(nums[i], count);
        }
        
        for (Integer key : map.keySet()) {
        	if (map.get(key) != 2) {
        		return key;
        	}
        }
        return -1;
    }
	
	public int singleNumber_sort(int[] nums) {
        int l = nums.length;
        
        Arrays.sort(nums);
        int i=0;
        while (i<l-1) {
        	if (nums[i] != nums[i+1]) {
        		return nums[i];
        	}
        	
        	i += 2;
        }
        if (l % 2 == 1) {
        	return nums[l-1];
        }
        return -1;
    }
	
	//maths
	public int singleNumber(int[] nums) {
		int l = nums.length;
		Set<Integer> set = new HashSet<>();
		
		int sum = 0;
		int uniqueElementSum = 0;
		
		for (int i=0; i<l; i++) {
			if (!set.contains(nums[i])) {
				set.add(nums[i]);
				uniqueElementSum += nums[i];
			}
			
			sum += nums[i];
		}
		
		return 2 * uniqueElementSum - sum;
	}
	
	public static void main(String[] args) {
		System.out.println("Test-1 status=" + (test1() ? "pass" : "fail"));
		System.out.println("Test-2 status=" + (test2() ? "pass" : "fail"));
	}
	
	public static boolean test1() {
		Q136_SingleNumber q = new Q136_SingleNumber();
		int[] arr = {2,2,1};
		
		//must contains
		return q.singleNumber(arr) == 1;
	}
	public static boolean test2() {
		Q136_SingleNumber q = new Q136_SingleNumber();
		int[] arr = {4,1,2,1,2};
		
		//must contains
		return q.singleNumber(arr) == 4;
	}
}
