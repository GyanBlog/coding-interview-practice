package com.gyanblog.sort;

import com.gyanblog.utils.ArrayUtils;

/**
 * Radix Sort
 * For explanation: https://www.gyanblog.com/gyan/coding-interview/radix-sort-algorithm-java/
 */
public class RadixSort {
    private int[] arr;

    public RadixSort(int[] arr) {
        this.arr = arr;
    }

    /**
     * Using CountSort as stable sort
     */
    private void countSort(int position) {
        int[] c = new int[10];  //0 to 9
        for (int i=0; i<this.arr.length; i++) {
            int digit = this.getDigit(this.arr[i], position);
            c[digit] ++;
        }
        //accumulate
        for (int i=1; i<c.length; i++) {
            c[i] = c[i] + c[i-1];
        }

        int[] res = new int[this.arr.length];
        for (int i=this.arr.length-1; i>=0; i--) {
            int digit = this.getDigit(this.arr[i], position);

            res[c[digit]-1] = this.arr[i];
            c[digit] --;
        }

        this.arr = res;
        System.out.println(ArrayUtils.toString(arr));
    }

    private int getDigit(int num, int position) {
        return num/position % 10;
    }

    /**
     * Main method for radix sort
     */
    public void sort() {
        int max = ArrayUtils.getMaxValue(this.arr);
        
        int position = 1;

        while (max/position > 0) {
            this.countSort(position);

            position *= 10;
        }
    }

    public static void main(String[] args) {
        int[] arr = {329, 457, 657, 839, 436, 720, 355};

        System.out.println(ArrayUtils.toString(arr));
        RadixSort rs = new RadixSort(arr);
        rs.sort();

        System.out.println(ArrayUtils.toString(arr));
    }
}