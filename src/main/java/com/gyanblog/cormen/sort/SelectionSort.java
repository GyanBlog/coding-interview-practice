package com.gyanblog.cormen.sort;

import com.gyanblog.common.parents.ProblemParent;
import com.gyanblog.utils.ArrayUtils;
import com.gyanblog.utils.MiscUtils;
import com.gyanblog.utils.RandomUtils;

public class SelectionSort extends ProblemParent {
	private int[] arr;
	public SelectionSort(int[] arr) {
		this.arr = arr;
	}
	@Override
	public void execute() {
		int l = this.arr.length;
		for (int i=0; i<l-1; i++) {
			int smallestNumIndex = i;
			for (int j=i+1; j<l; j++) {
				if (this.arr[smallestNumIndex] > arr[j]) {
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
		
		System.out.println("Initial arrya: " + ArrayUtils.toString(arr));
		SelectionSort ss = new SelectionSort(arr);
		ss.doExecute();
		System.out.println("Ater sort: " + ArrayUtils.toString(arr));
	}
}
