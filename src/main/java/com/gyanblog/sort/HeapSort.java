package com.gyanblog.sort;

import com.gyanblog.utils.ArrayUtils;
import com.gyanblog.utils.RandomUtils;

/**
 * Heap sort
 * For detailed explanation: https://www.gyanblog.com/gyan/coding-interview/heap-sort-algorithm/
 */
public class HeapSort {
	private int[] arr;
	private int heapsize;

	public HeapSort(int[] arr) {
		this.arr = arr;
		this.heapsize = this.arr.length;
	}
	
	private int getLeftChild(int index) {
		return (index * 2) + 1;
	}
	private int getRightChild(int index) {
		return (index * 2) + 2;
	}
	
	private void max_heapify(int index) {
		int l = this.getLeftChild(index);
		int r = this.getRightChild(index);
		
		int indexOfLargest = index;
		if (l < this.heapsize && this.arr[l] > this.arr[index]) {
			indexOfLargest = l;
		}

		if (r < this.heapsize && this.arr[r] > this.arr[indexOfLargest]) {
			indexOfLargest = r;
		}
		
		if (indexOfLargest != index) {
			ArrayUtils.swap(this.arr, index, indexOfLargest);
			this.max_heapify(indexOfLargest);
		}
	}
	
	private void buildMaxHeap() {
		for (int i=this.heapsize/2; i>=0; i--) {
			this.max_heapify(i);
		}
	}
	
	public void doHeapSort() {
		this.buildMaxHeap();
		int l = this.arr.length;
		for (int i=l-1; i>0; i--){
			ArrayUtils.swap(this.arr, 0, i);
			this.heapsize--;
			
			this.max_heapify(0);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = RandomUtils.getRamdomArray(10);
		HeapSort heapSort = new HeapSort(arr);

		System.out.println(ArrayUtils.toString(arr));
		heapSort.doHeapSort();
		System.out.println(ArrayUtils.toString(arr));
	}
}
