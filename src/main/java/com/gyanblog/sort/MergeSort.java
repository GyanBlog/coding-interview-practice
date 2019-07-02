package com.gyanblog.sort;

import com.gyanblog.utils.ArrayUtils;
import com.gyanblog.utils.RandomUtils;

/**
 * For detailed explanation: 
 * 	https://www.gyanblog.com/gyan/coding-interview-merge-sort/
 *
 */
public class MergeSort {

	private static void merge(int[] a, int l, int m, int r) {
		int[] left = new int[m-l+1];
		int[] right = new int[r-m];
		
		for (int i=l; i<=m; i++) {
			left[i-l] = a[i];
		}
		for (int i=m+1; i<=r; i++) {
			right[i-m-1] = a[i];
		}
		
		int lindex = 0;
		int rindex = 0;
		for (int i=l; i<=r; i++) {
			if (lindex < left.length && (rindex >= right.length || left[lindex] < right[rindex])) {
				a[i] = left[lindex];
				lindex ++;
			}
			else {
				a[i] = right[rindex];
				rindex ++;
			}
		}
	}
	
	/**
	 * Alternate merge method
	 */
	private static void merge2(int[] a, int l, int m, int r) {
		int l1 = m-l+1;
		int l2 = r-m;
		int[] left = new int[l1];
		int[] right = new int[l2];
		
		for (int i=0; i<l1; i++) {
			left[i] = a[l+i];
		}
		for (int i=0; i<l2; i++) {
			right[i] = a[m+1+i];
		}
		
		int lindex = 0;
		int rindex = 0;
		int i=l;
		while (lindex < l1 && rindex < l2) {
			if (left[lindex] < right[rindex]) {
				a[i] = left[lindex];
				lindex++;
			}
			else {
				a[i] = right[rindex];
				rindex++;
			}
			i++;
		}
		
		//copy the leftover array
		for (int j=lindex; j<l1; j++) {
			a[i] = left[j];
			i++;
		}
		for (int j=rindex; j<l2; j++) {
			a[i] = right[j];
			j++;
		}
	}
	
	public static void doMergeSort(int[] arr, int l, int r) {
		if (l < r) {
			int m = (r+l)/2;
			
			doMergeSort(arr, l, m);
			doMergeSort(arr, m+1, r);
			
			merge(arr, l, m, r);
		}
	}
	
	public static void main(String[] args) {
		int arr[] = new int[25];
		for (int i=0; i<25; i++) {
			arr[i] = RandomUtils.getRandomInt(100);
		}
		
		System.out.println("Initial array: " + ArrayUtils.toString(arr));
		MergeSort.doMergeSort(arr, 0, arr.length-1);
		System.out.println("After sort: " + ArrayUtils.toString(arr));
	}
}
