package com.gyanblog.cormen.sort;

import com.gyanblog.utils.ArrayUtils;
import com.gyanblog.utils.MiscUtils;
import com.gyanblog.utils.RandomUtils;

public class SelectionSort {
	
	public static void sort(int[] arr) {
		int l = arr.length;
		for (int i=0; i<l-1; i++) {
			int smallestNumIndex = i;
			for (int j=i+1; j<l; j++) {
				if (arr[smallestNumIndex] > arr[j]) {
					smallestNumIndex = j;
				}
			}
			if (i != smallestNumIndex) {
				//swap
				MiscUtils.swapInt(arr, i, smallestNumIndex);
			}
		}
	}
	
	public static void main(String[] args) {
		int arr[] = new int[25];
		for (int i=0; i<25; i++) {
			arr[i] = RandomUtils.getRandomInt(50);
		}
		
		System.out.println("Initial array: " + ArrayUtils.toString(arr));
		SelectionSort.sort(arr);
		System.out.println("After sort: " + ArrayUtils.toString(arr));
	}
}
