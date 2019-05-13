package com.gyanblog.utils;

public class MiscUtils {

	public static void swapInt(int[] arr, int lIndex, int rIndex) {
		int temp = arr[lIndex];
		arr[lIndex] = arr[rIndex];
		arr[rIndex] = temp;
	}
}
