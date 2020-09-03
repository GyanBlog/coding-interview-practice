package com.gyanblog.leetcode;

public class Q5499_DetectPattern {

	private boolean compareArray(int[] arr, int[] expected, int startIndex, int length) {
		int matchCount = 0;
		for (int i=0; i<length && i+startIndex < arr.length; i++) {
			if (arr[i+startIndex] != expected[i]) {
				return false;
			}
			else {
				matchCount ++;
			}
		}
		
		return matchCount == length;
	}
	
	public boolean containsPattern(int[] arr, int m, int k) {
        for (int i=0; i<arr.length; i++) {
        	int matchedCount = 0;
        	
        	if (i+m >= arr.length) continue;
        	
        	int j=i;
        	int[] expectedArray = new int[m];
        	for (int x=0; x<m; x++) {
        		expectedArray[x] = arr[j+x];
        	}
        	for (;j<=arr.length && j+m-1 < arr.length; j+=m) {
        		if (this.compareArray(arr, expectedArray, j, m)) {
        			matchedCount ++;
        		}
        		else {
        			break;
        		}
        	}
        	
        	if (matchedCount == k) {
        		return true;
        	}
        }
        return false;
    }
	
	public static void main(String[] args) {
		System.out.println("Test-1 status=" + (test1() ? "pass" : "fail"));
		System.out.println("Test-2 status=" + (test2() ? "pass" : "fail"));
		System.out.println("Test-3 status=" + (test3() ? "pass" : "fail"));
		System.out.println("Test-4 status=" + (test4() ? "pass" : "fail"));
		System.out.println("Test-5 status=" + (test5() ? "pass" : "fail"));
	}
	
	public static boolean test1() {
		Q5499_DetectPattern q = new Q5499_DetectPattern();
		int[] arr = {1,2,1,2,1,1,1,3};
		
		//must contains
		return q.containsPattern(arr, 2, 2) == true;
	}
	
	public static boolean test2() {
		Q5499_DetectPattern q = new Q5499_DetectPattern();
		int[] arr = {1,2,1,2,1,3};
		
		//must contains
		return q.containsPattern(arr, 2, 3) == false;
	}
	
	public static boolean test3() {
		Q5499_DetectPattern q = new Q5499_DetectPattern();
		int[] arr = {1,2,4,4,4,4};
		
		//must contains
		return q.containsPattern(arr, 1, 3) == true;
	}
	
	public static boolean test4() {
		Q5499_DetectPattern q = new Q5499_DetectPattern();
		int[] arr = {1,2,3,1,2};
		
		//must contains
		return q.containsPattern(arr, 2, 2) == false;
	}
	public static boolean test5() {
		Q5499_DetectPattern q = new Q5499_DetectPattern();
		int[] arr = {2,2};
		
		//must contains
		return q.containsPattern(arr, 1, 2) == true;
	}
}
