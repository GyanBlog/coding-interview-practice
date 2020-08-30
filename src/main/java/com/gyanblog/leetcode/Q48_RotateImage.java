package com.gyanblog.leetcode;

public class Q48_RotateImage {

	public void rotate(int[][] matrix) {
		int n = matrix[0].length;
		
		for (int layer = 0; layer < n/2; layer++) {
			for (int i=layer; i<n-layer-1; i++) {
				int temp = matrix[layer][i];
				matrix[layer][i] = matrix[n-i-1][layer];
				matrix[n-i-1][layer] = matrix[n-layer-1][n-1-i];
				matrix[n-layer-1][n-1-i] = matrix[i][n-layer-1];
				matrix[i][n-layer-1] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		Q48_RotateImage q = new Q48_RotateImage();
		q.rotate(matrix);
		
		for (int i=0; i<matrix[0].length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
