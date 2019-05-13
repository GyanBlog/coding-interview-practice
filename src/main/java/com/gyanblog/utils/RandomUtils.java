package com.gyanblog.utils;

import java.util.Random;

public class RandomUtils {

	public static int getRandomInt(int maxInt) {
		return new Random().nextInt(maxInt);
	}
	
	public static int[] getRamdomArray(int size) {
		int arr[] = new int[size];
		for (int i=0; i<size; i++) {
			arr[i] = RandomUtils.getRandomInt(500);
		}
		return arr;
	}
}
