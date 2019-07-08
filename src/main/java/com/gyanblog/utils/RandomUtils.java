package com.gyanblog.utils;

import java.util.Random;

public class RandomUtils {

	public static int getRandomInt(int maxInt) {
		return new Random().nextInt(maxInt);
	}
	
	/**
	 * Get a random array, with max random value of 500 (hard coded)
	 */
	public static int[] getRamdomArray(int size) {
		int arr[] = new int[size];
		for (int i=0; i<size; i++) {
			arr[i] = RandomUtils.getRandomInt(500);
		}
		return arr;
	}

	/**
	 * Get a random array, with max random value specified
	 */
	public static int[] getRamdomArray(int size, int maxRandomValue) {
		int arr[] = new int[size];
		for (int i=0; i<size; i++) {
			arr[i] = RandomUtils.getRandomInt(maxRandomValue);
		}
		return arr;
	}
}
