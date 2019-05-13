package com.gyanblog.cormen.sort;

import com.gyanblog.common.parents.ProblemParent;
import com.gyanblog.utils.ArrayUtils;
import com.gyanblog.utils.RandomUtils;

public class MergeSort extends ProblemParent {

	private int[] arr;
	public MergeSort(int[] arr) {
		this.arr = arr;
	}
	
	private void merge(int[] a, int l, int m, int r) {
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
		for (int i=l; i<= r; i++) {
			if (lindex < left.length && (rindex >= right.length || left[lindex] < right[rindex])) {
				a[i] = left[lindex];
				lindex ++;
			}
			else { // if (lindex >= left.length || ) {
				a[i] = right[rindex];
				rindex ++;
			}
		}
	}
	
	private void doMergeSort(int l, int r) {
		if (l < r) {
			int m = (r+l)/2;
			
			doMergeSort(l, m);
			doMergeSort(m+1, r);
			
			this.merge(this.arr, l, m, r);
		}
	}
	
	@Override
	public void execute() {
		this.doMergeSort(0, this.arr.length-1);
	}

	public static void main(String[] args) {
		int arr[] = new int[25];
		for (int i=0; i<25; i++) {
			arr[i] = RandomUtils.getRandomInt(50);
		}
		
		System.out.println("Initial array: " + ArrayUtils.toString(arr));
		MergeSort ms = new MergeSort(arr);
		
		ms.doExecute();
		System.out.println("After sort: " + ArrayUtils.toString(arr));
	}
}
