package com.gyanblog.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q39_CombinationSum {

	private void helper(List<List<Integer>> res, List<Integer> iRes, int[] candidates, int target, int index) {
		if (target == 0) {
			//target achieved
			res.add(new ArrayList<>(iRes));
			return;
		}
		
		if (target < 0) return;
		
		while (index < candidates.length && target - candidates[index] >= 0) {
			iRes.add(candidates[index]);
			helper(res, iRes, candidates, target - candidates[index], index);
			
			index ++;
			
			//remove last, so that we can go back to the set without the current element
			iRes.remove(iRes.size()-1);
		}
	}
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> iRes = new ArrayList<>();
		
		Arrays.sort(candidates);
		helper(res, iRes, candidates, target, 0);
		
		return res;
    }
	
	public static void main(String[] args) {
		int[] candidates = {8, 7, 4, 3};
		int target = 11;
		
		Q39_CombinationSum q = new Q39_CombinationSum();
		List<List<Integer>> res = q.combinationSum(candidates, target);
		System.out.println(res);
	}
}
