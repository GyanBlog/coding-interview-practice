package com.gyanblog.cormen.sort;

public class Inversions {

	/**
	 * Method which will perform in O(n^2)
	 */
	public static void calculate_bad(int[] arr) {
		for (int i=0; i<arr.length-1; i++) {
			for (int j=i+1; j<arr.length; j++) {
				if (arr[i] > arr[j]) {
					System.out.println(arr[i] + " " + arr[j]);
				}
			}
		}
	}
	
	private static void calculate_good_recursive(int[] arr, int l, int m, int r) {
		int l1 = m-l+1;
		int l2 = r-m;
		
		int[] left = new int[l1];
		for (int i=0; i<l1; i++) {
			left[i] = arr[l+i];
		}
		
		int[] right = new int[l2];
		for (int i=0; i<l2; i++) {
			right[i] = arr[m+i+1];
		}
		
		int lindex = 0;
		int rindex = 0;
		while (lindex < l1 && rindex < l2) {
			if (right[rindex] < left[lindex]) {
				for (int jj=lindex; jj<l1; jj++) {
					System.out.println(left[jj] + " " + right[rindex]);
				}
			}
			
			if (left[lindex] <= right[rindex]) {
				arr[l] = left[lindex];
				lindex ++;
			}
			else {
				arr[l] = right[rindex];
				rindex ++;
			}
			
			l++;
		}
		while (lindex < l1) {
			arr[l] = left[lindex];
			l++; lindex ++;
		}
		while (rindex < l2) {
			arr[l] = right[rindex];
			l++; rindex ++;
		}
	}
	
	private static void inversions_merge_sort_method(int[] arr, int l, int r) {
		if (l < r) {
			int m = (l+r)/2;
			inversions_merge_sort_method(arr, l, m);
			inversions_merge_sort_method(arr, m+1, r);
			
			calculate_good_recursive(arr, l, m, r);
		}
	}
	public static void calculate_good(int[] arr) {
		inversions_merge_sort_method(arr, 0, arr.length-1);
	}
	
	public static void main(String[] args) {
		int[] arr = {2, 3, 8, 6, 1, 4};
		
		Inversions.calculate_bad(arr);
		System.out.println("--------------");
		Inversions.calculate_good(arr);
//		System.out.println(ArrayUtils.toString(arr));
	}
}
