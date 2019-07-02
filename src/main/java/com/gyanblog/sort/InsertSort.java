package com.gyanblog.sort;

import com.gyanblog.utils.ArrayUtils;
import com.gyanblog.utils.RandomUtils;

/**
 * For detailed analysis:
 * https://www.gyanblog.com/gyan/coding-interview-insertion-sort/
 */
public class InsertSort {
	
	public static void sort(int[] arr) {
		int len = arr.length;
		System.out.println("Original: " + ArrayUtils.toString(arr));
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		for (int i=1; i<len; i++) {
			int key = arr[i];
			int j = i-1;
			while (j >= 0 && key < arr[j]) {
				arr[j+1] = arr[j];
				j--;
			}
			
			arr[j+1] = key;
			System.out.println("Round #" + i + ": " + ArrayUtils.toString(arr) + ", Key=" + key);
		}
	}

	public static void main(String[] args) {
		int[] a1 = new int[20];
		for (int i=0; i<20; i++) {
			a1[i] = RandomUtils.getRandomInt(100);
		}
		
		InsertSort.sort(a1);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(ArrayUtils.toString(a1));
	}
}
