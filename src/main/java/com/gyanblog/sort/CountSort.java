package com.gyanblog.sort;

import com.gyanblog.utils.ArrayUtils;
import com.gyanblog.utils.RandomUtils;

/**
 * Count Sort
 * 
 * For explanation: https://www.gyanblog.com/gyan/coding-interview/counting-sort-algorithm-in-java/
 */
public class CountSort {
    private int[] arr;

    public CountSort(int[] arr) {
        this.arr = arr;
    }

    /**
     * Count sort, max value-k
     * @param k, the max value in array
     */
    public int[] doSort(int k) {
        int[] c = new int[k+1];

        //count number of occurence
        for (int i=0; i<this.arr.length; i++) {
            c[this.arr[i]] ++;
        }

        //accumulate
        for (int i=1; i<c.length; i++) {
            c[i] += c[i-1];
        }
        int[] result = new int[this.arr.length];

        //put the number to its designated place
        for (int i=this.arr.length-1; i>=0; i--) {
            result[c[this.arr[i]]-1] = this.arr[i];
            c[this.arr[i]] --;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = RandomUtils.getRamdomArray(10, 10);

        System.out.println("Original array: " + ArrayUtils.toString(arr));
        
        CountSort cs = new CountSort(arr);
        int[] result = cs.doSort(ArrayUtils.getMaxValue(arr));

        System.out.println("Final array: " + ArrayUtils.toString(result));
    }
}