package com.gyanblog.leetcode.q4_median_sorted_arrays;

import com.gyanblog.utils.ArrayUtils;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
   Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

   For detailed explanation: https://www.gyanblog.com/gyan/coding-interview/leetcode-find-median-two-sorted-arrays/
 */
public class SimpleSolution {
    private int[] arr1;
    private int[] arr2;
    
    public SimpleSolution(int[] arr1, int[] arr2) {
        this.arr1 = arr1;
        this.arr2 = arr2;
    }

    private int[] merge() {
        int[] res = new int[this.arr1.length + this.arr2.length];
        //index for arr1
        int i=0;
        //index for arr2
        int j=0;
        // result index
        int k=0;

        while (i < this.arr1.length && j < this.arr2.length) {
            if (this.arr1[i] < this.arr2[j]) {
                res[k] = this.arr1[i];
                i++;
            }
            else {
                res[k] = this.arr2[j];
                j++;
            }
            k++;
        }
        for (; i<this.arr1.length; i++) {
            res[k] = this.arr1[i];
            k++;
        }
        for (; j<this.arr2.length; j++) {
            res[k] = this.arr2[j];
            k++;
        }

        return res;
    }

    public double getMedian() {
        int[] mergedArray = this.merge();
        int l = mergedArray.length;
        
        //if length is odd. Median is middle number
        //else, its average of middle two elements

        if (l % 2 != 0) {
            return mergedArray[l/2];
        }

        //else
        return (double)(mergedArray[(l-1)/2] + mergedArray[(l)/2]) / 2;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 6};
        int[] arr2 = {2, 4};

        SimpleSolution ss = new SimpleSolution(arr1, arr2);

        System.out.println("Arr1: " + ArrayUtils.toString(arr1));
        System.out.println("Arr2: " + ArrayUtils.toString(arr2));
        System.out.println("Median: " + ss.getMedian());
    }
}