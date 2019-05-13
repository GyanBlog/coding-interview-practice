package com.gyanblog.utils;

public class ArrayUtils {

	public static String toString(Object[] arr) {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<arr.length; i++) {
			sb.append(arr[i]).append(",");
		}
		return sb.toString();
	}
	
	public static String toString(int[] arr) {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<arr.length; i++) {
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
