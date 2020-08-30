package com.gyanblog.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q46_Permutation {
	public List<List<Integer>> permute(int[] nums) {
		return this.permute(nums, 0);
	}

	private List<List<Integer>> permute(int[] nums, int index) {
		if (index == nums.length) {
			List<Integer> l = new ArrayList();
			List<List<Integer>> ll = new ArrayList();
			ll.add(l);
			return ll;
		}

		int num = nums[index];
		List<List<Integer>> res = this.permute(nums, index + 1);

		List<List<Integer>> res2 = new ArrayList<>();
	    for (List<Integer> list : res) {
    		for (int i=0; i<=list.size(); i++) {
    			List<Integer> ir = insert(list, i, num);
    			res2.add(ir);
    		}
	    }

		return res2;
	}
	
	private static List<Integer> insert(List<Integer> list, int index, int num) {
		List<Integer> r = new ArrayList<>();
		if (index == list.size()) {
			r.addAll(list);
			r.add(num);
			return r;
		}

		for (int i=0; i<list.size(); i++) {
			if (i == index) {
				r.add(num);
			}
			r.add(list.get(i));
		}

		return r;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3};

		Q46_Permutation q = new Q46_Permutation();
		List<List<Integer>> res = q.permute(nums);
		System.out.println(res);

//		test();
	}
}
