package com.gyanblog.leetcode;

import java.util.HashMap;
import java.util.Map;

import com.gyanblog.utils.ArrayUtils;
import com.gyanblog.utils.RandomUtils;

/**
 * For detailed explanation, see: https://www.gyanblog.com/gyan/coding-interview/leetcode-solutions-two-sum/
 */
public class Q1_TwoSum {

    /**
     * Runs in O(n^2)
     */
    public int[] twoSum_bad(int[] nums, int target) {
        int l = nums.length;
        for (int i=0; i<l; i++) {
            for (int j=i+1; j<l; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    /**
     * Runs in O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int l = nums.length;
        for (int i=0; i<l; i++) {
            int pairValue = target-nums[i];
            if (hashMap.containsKey(pairValue)) {
                return new int[]{i, hashMap.get(pairValue)};
            }

            if (!hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], i);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] nums = RandomUtils.getRamdomArray(10, 20);
        System.out.println(ArrayUtils.toString(nums));

        Q1_TwoSum twoSum = new Q1_TwoSum();
        System.out.println("Finding 20");
        int[] indices = twoSum.twoSum(nums, 20);
        System.out.println(ArrayUtils.toString(indices));

        System.out.println("Finding 30");
        indices = twoSum.twoSum(nums, 30);
        System.out.println(ArrayUtils.toString(indices));

        System.out.println("Finding 10");
        indices = twoSum.twoSum(nums, 10);
        System.out.println(ArrayUtils.toString(indices));
    }
}