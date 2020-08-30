package com.gyanblog.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q40_CombinationSum2 {

	private void helper(List<List<Integer>> res, List<Integer> iRes, int[] candidates, int target, int index) {
		if (target == 0) {
			res.add(new ArrayList<>(iRes));
			return;
		}
		if (target < 0) return;
		
		for (int i=index; i<candidates.length; i++) {
			if (candidates[i] > target) return;
			
			iRes.add(candidates[i]);
			helper(res, iRes, candidates, target - candidates[i], i + 1);
			
			//remove last
			iRes.remove(iRes.size() - 1);
			
			//move ahead of duplicate numbers
			while (i+1 < candidates.length && candidates[i+1] == candidates[i]) {
				i++;
			}
		}
	}
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
        	return res;
        }
        
        List<Integer> iRes = new ArrayList<>();
        Arrays.sort(candidates);
        helper(res, iRes, candidates, target, 0);
        
        return res;
    }
	
	public static void main(String[] args) {
		int[] candidates = {10,1,2,7,6,1,5};
		int target = 8;
		Q40_CombinationSum2 q = new Q40_CombinationSum2();
		List<List<Integer>> res = q.combinationSum2(candidates, target);
		
		System.out.println(res);
	}
}
