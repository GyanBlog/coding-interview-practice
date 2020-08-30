package com.gyanblog.utils;

public class ArrayUtils {

	public static String toString(Object[] arr) {
		if (arr == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<arr.length; i++) {
			sb.append(arr[i]).append(",");
		}
		return sb.toString();
	}
	
	public static String toString(int[] arr) {
		if (arr == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<arr.length; i++) {
			sb.append(arr[i]).append(",");
		}
		return sb.toString();
	}

	public static String toString(int[] arr, int len) {
		if (arr == null) {
			return null;
		}
		if (len > arr.length) {
			len = arr.length;
		}

		StringBuilder sb = new StringBuilder();
		for (int i=0; i<len; i++) {
			sb.append(arr[i]).append(",");
		}
		return sb.toString();
	}
	
	public static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	/**
	 * Get index of max element from array
	 */
	public static int getMaxIndex(int[] arr) {
		int maxIndex = 0;
		for (int i=1; i<arr.length; i++) {
			if (arr[i] > arr[maxIndex]) {
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	/**
	 * Get max value from array
	 */
	public static int getMaxValue(int[] arr) {
		int maxValue = 0;
		for (int i=1; i<arr.length; i++) {
			if (arr[i] > maxValue) {
				maxValue = arr[i];
			}
		}
		return maxValue;
	}
	
	/**
	 * Check if two arrays are equal
	 * @param arr
	 * @param expected
	 * @param length
	 * @return
	 */
	public static boolean compareArray(int[] arr, int[] expected, int length) {
		if (arr.length < length || expected.length < length) {
			return false;
		}
		for (int i=0; i<length; i++) {
			if (arr[i] != expected[i]) {
				return false;
			}
		}
		return true;
	}
}
