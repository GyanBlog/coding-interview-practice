package com.gyanblog.sort;

import com.gyanblog.utils.ArrayUtils;
import com.gyanblog.utils.RandomUtils;

/**
 * For detailed analysis:
 * https://www.gyanblog.com/gyan/coding-interview-bubble-sort/
 */
public class BubbleSort {

	public static void sort(int[] arr) {
		int l = arr.length;
		for (int i=0; i<l-1; i++) {
			for (int j=0; j<(l-i-1); j++) {
				if (arr[j] > arr[j+1]) {
					//swap
					int t = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = t;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int arr[] = new int[25];
		for (int i=0; i<25; i++) {
			arr[i] = RandomUtils.getRandomInt(50);
		}
		
		System.out.println("Initial array: " + ArrayUtils.toString(arr));
		BubbleSort.sort(arr);
		System.out.println("After sort: " + ArrayUtils.toString(arr));
	}
}
