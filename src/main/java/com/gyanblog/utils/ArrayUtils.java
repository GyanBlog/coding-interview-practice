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
}
