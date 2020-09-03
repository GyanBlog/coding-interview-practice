package com.gyanblog.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gyanblog.utils.ArrayUtils;

public class Q350_IntersectionTwoArrays {

	public int[] intersect_extraMemory(int[] nums1, int[] nums2) {
		if (nums1.length == 0 || nums2.length == 0) {
			return new int[] {};
		}
		
		//prepare map with number of occurence of each number
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int j=0; j<nums2.length; j++) {
			Integer count = map.getOrDefault(nums2[j], 0);
			count ++;
			
			map.put(nums2[j], count);
		}
		
		List<Integer> res = new ArrayList<Integer>();
		for (int i=0; i<nums1.length; i++) {
			int count = map.getOrDefault(nums1[i], 0);
			if (count > 0) {
				res.add(nums1[i]);

				count --;
				map.put(nums1[i], count);
			}
		}
		
		//copy the result array
		int[] r = new int[res.size()];
		for (int i=0; i<res.size(); i++) {
			r[i] = res.get(i);
		}
		
		return r;
    }
	
	//sorting
	public int[] intersect(int[] nums1, int[] nums2) {
		if (nums1.length == 0 || nums2.length == 0) {
			return new int[] {};
		}
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		
		int i=0;
		int j=0;
		
		List<Integer> res = new ArrayList<Integer>();
		while (i<nums1.length && j<nums2.length) {
			if (nums1[i] == nums2[j]) {
				res.add(nums1[i]);
				i++;
				j++;
			}
			else if (nums1[i] < nums2[j]) {
				i++;
			}
			else {
				j++;
			}
		}
		
		//copy the result array
		int[] r = new int[res.size()];
		for (i=0; i<res.size(); i++) {
			r[i] = res.get(i);
		}
		
		return r;
	}
	
	
	public static void main(String[] args) {
		System.out.println("Test-1 status=" + (test1() ? "pass" : "fail"));
		System.out.println("Test-2 status=" + (test2() ? "pass" : "fail"));
	}
	
	public static boolean test1() {
		Q350_IntersectionTwoArrays q = new Q350_IntersectionTwoArrays();
		
		int[] nums1= {1,2,2,1};
		int[] nums2= {2,2};
		
		//must contains
		int[] res = q.intersect(nums1, nums2);
		return ArrayUtils.compareArray(res, new int[] {2,2}, res.length);
	}
	
	public static boolean test2() {
		Q350_IntersectionTwoArrays q = new Q350_IntersectionTwoArrays();
		
		int[] nums1= {9,4,9,8,4};
		int[] nums2= {4,9,5};
		
		//must contains
		int[] res = q.intersect(nums1, nums2);
		Arrays.sort(res);
		return ArrayUtils.compareArray(res, new int[] {4,9}, res.length);
	}
}
