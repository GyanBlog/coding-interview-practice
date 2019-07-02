package com.gyanblog.sort;

import com.gyanblog.utils.ArrayUtils;
import com.gyanblog.utils.RandomUtils;

public class QuickSort {

	public static int partition(int[] arr, int l, int r) {
		int p = r;
		
		int sm = l;
		for (int i=l; i<r; i++) {
			if (arr[i] < arr[p]) {
				ArrayUtils.swap(arr, i, sm);
				sm++;
			}
		}
		ArrayUtils.swap(arr, sm, p);
		return sm;
	}
	
	public static void qsort(int[] arr, int l, int r) {
		if (l < r) {
			int p = partition(arr, l, r);
			
			qsort(arr, l, p-1);
			qsort(arr, p+1, r);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = RandomUtils.getRamdomArray(10);
		System.out.println(ArrayUtils.toString(arr));
		
		qsort(arr, 0, arr.length-1);
		System.out.println(ArrayUtils.toString(arr));
	}
}
